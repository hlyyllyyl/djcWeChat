package com.decisioncustom.service;


import com.decisioncustom.domain.TCustomerColumn;
import com.decisioncustom.pojo.CustomerColumnPojo;
import com.decisioncustom.query.CustomerColumnQuery;

import java.util.List;

public interface ICustomerColumnService extends ICrudService<TCustomerColumn,Long> {
    /*查询所有购买栏目*/
    List<TCustomerColumn> selectAllByQuery(CustomerColumnQuery customerColumnQuery);
    /*查询客户所有购买栏目*/
    TCustomerColumn selectAllByCustomer(CustomerColumnPojo customerColumnPojo);
}
