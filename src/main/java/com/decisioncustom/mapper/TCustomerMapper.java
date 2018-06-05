package com.decisioncustom.mapper;


import com.decisioncustom.domain.TCustomer;
import com.decisioncustom.domain.TCustomerEmployee;
import com.decisioncustom.pojo.CustomerPojo;
import com.decisioncustom.query.CustomerQuery;

import java.io.Serializable;
import java.util.List;

public interface TCustomerMapper extends CrudMapper<TCustomer>{
    /**
     * 根据客服ID查询所有客户
     * @return
     */
    List<TCustomer> getAllTCustomerById(Long serviceManId);

    /**
     * 根据小组ID查询所有客户
     * @return
     */
    List<TCustomer> getAllTCustomerByTeam(Long team);

    /**
     * 查询所有客户
     * @return
     */
    List<TCustomer> getAllTCustomerByQuery(CustomerQuery customerQuery);

    //通过roleid删除中间表关联关系
    void removeCustomerEmployees(Serializable id);
    //保存中间表关联关系
    void saveCustomerEmployees(List<TCustomerEmployee> customerEmployees);

    /**
     * 基础功能
     */
    void createTable();

    /*通过Id查询客户*/
    TCustomer getCustomerById(CustomerPojo customerPojo);

    /*通过名字登录*/
    TCustomer loginByCustomerName(String customerName);

    /*通过微信登录*/
    TCustomer loginByWeChat(String fromUserName);
}
