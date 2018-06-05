package com.decisioncustom.mapper;


import com.decisioncustom.domain.TColumn;
import com.decisioncustom.domain.TCustomerColumn;
import com.decisioncustom.pojo.CustomerColumnPojo;
import com.decisioncustom.query.CustomerColumnQuery;

import java.util.List;


public interface TCustomerColumnMapper extends CrudMapper<TCustomerColumn> {
    /*查询所有父栏目*/
    List<TColumn> selectParentColumn();

    /*查询置顶数量*/
    Long selectTopNum(Long parentId);

    /*查询所有购买栏目*/
    List<TCustomerColumn> selectAllByQuery(CustomerColumnQuery customerColumnQuery);

    /*查询客户所购买栏目*/
    TCustomerColumn selectAllByCustomer(CustomerColumnPojo customerColumnPojo);
}
