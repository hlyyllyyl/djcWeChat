package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TCustomer;
import com.decisioncustom.domain.TCustomerComplain;
import com.decisioncustom.domain.TCustomerComplainEmployee;
import com.decisioncustom.domain.TEmployee;
import com.decisioncustom.mapper.TCustomerComplainMapper;
import com.decisioncustom.mapper.TCustomerMapper;
import com.decisioncustom.pojo.CustomerCompanyPojo;
import com.decisioncustom.query.CustomerComplainQuery;
import com.decisioncustom.query.CustomerQuery;
import com.decisioncustom.service.ICustomerComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Service
@Transactional
public  class CustomerComplainServiceImpl extends ICrudServiceImpl<TCustomerComplain,Long>
        implements ICustomerComplainService {

    @Autowired
    private TCustomerComplainMapper customerComplainMapper;
    @Autowired
    private TCustomerMapper customerMapper;

    @Override
    @Transactional(readOnly = false)
    public TCustomerComplain createSelective(TCustomerComplain resource) {
        customerComplainMapper.insertSelective(resource);
        List<TCustomerComplainEmployee> customerComplainEmployee= resource.getCustomerComplainEmployee();


        if(customerComplainEmployee.size()==0){
            return resource;
        }
        customerComplainMapper.saveComplainEmployees(customerComplainEmployee);
        return resource;
    }
    @Override
    @Transactional(readOnly = false)
    public TCustomerComplain updateSelective(TCustomerComplain resource) {
        customerComplainMapper.updateByPrimaryKeySelective(resource);
        customerComplainMapper.removeComplainEmployees(resource.getId());

        if(resource.getCustomerComplainEmployee().size()==0){
            return resource;
        }
        customerComplainMapper.saveComplainEmployees(resource.getCustomerComplainEmployee());
        return resource;
    }
    @Override
    @Transactional()
    public void delete(Serializable id) {
        customerComplainMapper.removeComplainEmployees(id);
        customerComplainMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List<TCustomerComplain> findAll() {
        List<TCustomerComplain> customerComplainList= customerComplainMapper.selectAll();
        return  getCustomerComplainList(customerComplainList);
    }

    @Override
    public List<TCustomerComplain> getAllComplainByQuery(CustomerComplainQuery complainQuery) {
        List<TCustomerComplain> customerComplainList= customerComplainMapper.getAllComplainByQuery(complainQuery);
        return getCustomerComplainList(customerComplainList);
    }

    @Override
    public List<CustomerCompanyPojo> selectCountByDay(String ct) {
        return customerComplainMapper.selectCountByDay(ct);
    }

    @Override
    public List<CustomerCompanyPojo> selectCountByMonth(String mt) {
        return customerComplainMapper.selectCountByMonth(mt);
    }

    public List<TCustomerComplain> getCustomerComplainList(List<TCustomerComplain> customerComplainList){
        for(TCustomerComplain c: customerComplainList){
            Long customerId = c.getCustomerId();
            CustomerQuery customerQuery= new CustomerQuery();
            customerQuery.setCustomerId(customerId);
            List<TCustomer> customer = customerMapper.getAllTCustomerByQuery(customerQuery);
            for (TCustomer cu :customer){
               /* List<TEmployee> saleMans= cu.getSaleMans();
                c.setSaleMans(saleMans);*/
            }
        }
        return customerComplainList;
    }
}
