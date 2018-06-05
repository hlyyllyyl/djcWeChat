package com.decisioncustom.service;


import com.decisioncustom.domain.TCustomer;
import com.decisioncustom.pojo.CustomerPojo;
import com.decisioncustom.query.CustomerQuery;

import java.util.List;
import java.util.Map;

public interface ICustomerService extends ICrudService<TCustomer,Long>{

    /**
     * 启动报备流程
     * @param businessObjId
     */
    void startProcess(Long businessObjId);

    Map<String, String> loadFormData(Long businessObjId);

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

    /*修改客户基本信息*/
    TCustomer updateCustomer(TCustomer customer);

    /*通过Id查询客户*/
    TCustomer getCustomerById(CustomerPojo customerPojo);

    /*通过名字登录*/
    TCustomer loginByCustomerName(String customerName);

    /*通过微信登录*/
    TCustomer loginByWeChat(String fromUserName);
}
