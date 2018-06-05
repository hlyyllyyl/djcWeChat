package com.decisioncustom.mapper;


import com.decisioncustom.domain.TCustomerComplain;
import com.decisioncustom.domain.TCustomerComplainEmployee;
import com.decisioncustom.pojo.CustomerCompanyPojo;
import com.decisioncustom.query.CustomerComplainQuery;

import java.io.Serializable;
import java.util.List;

public interface TCustomerComplainMapper extends CrudMapper<TCustomerComplain>{

    //通过roleid删除中间表关联关系
    void removeComplainEmployees(Serializable id);
    //保存中间表关联关系
    void saveComplainEmployees(List<TCustomerComplainEmployee> customerComplainEmployees);

    /**
     * 查询所有客户投诉
     * @return
     */
    List<TCustomerComplain> getAllComplainByQuery(CustomerComplainQuery complainQuery);

    /**
     * 客户投诉日汇总查询
     * @return
     */
    List<CustomerCompanyPojo> selectCountByDay(String ct);

    /**
     * 客户投诉日汇总查询
     * @return
     */
    List<CustomerCompanyPojo> selectCountByMonth(String mt);

}
