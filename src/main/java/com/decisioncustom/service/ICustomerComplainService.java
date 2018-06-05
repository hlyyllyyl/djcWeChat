package com.decisioncustom.service;


import com.decisioncustom.domain.TCustomerComplain;
import com.decisioncustom.pojo.CustomerCompanyPojo;
import com.decisioncustom.query.CustomerComplainQuery;

import java.util.List;

public interface ICustomerComplainService extends ICrudService<TCustomerComplain,Long>{

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
