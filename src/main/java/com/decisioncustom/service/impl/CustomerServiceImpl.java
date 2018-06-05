package com.decisioncustom.service.impl;

import com.decisioncustom.domain.TCustomer;
import com.decisioncustom.domain.TEmployee;
import com.decisioncustom.mapper.TCustomerMapper;
import com.decisioncustom.pojo.CustomerPojo;
import com.decisioncustom.query.CustomerQuery;
import com.decisioncustom.service.ICustomerService;
import com.decisioncustom.service.IWorkFlowService;
import com.decisioncustom.utils.activiti.ProcessDefinitionKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public  class CustomerServiceImpl extends ICrudServiceImpl<TCustomer,Long> implements ICustomerService {


    private TCustomerMapper dao;

    @Autowired
    public void setDao(TCustomerMapper dao) {
        // 由Spring注入dao
        this.dao = dao;

        // 自动建表
        dao.createTable();
    }

    @Autowired
    private IWorkFlowService workFlowService;


    @Override
    public void startProcess(Long businessObjId) {
        //修改状态
        //*********不要调用自己service方法,有可能是已经修过的,不是数据库中原生的**************
        TCustomer customer = dao.selectByPrimaryKey(businessObjId);
        customer.setAge(1);
        dao.updateByPrimaryKey(customer);
        //开启流程-processDefinitionKey,流程变量
        String processDefinitionKey = ProcessDefinitionKeyUtils
                .buildProcessDefinitionKey(TCustomer.class);//约定大于配置 业务对象类名+Flow
        Map<String, Object> variables = new HashMap<>();
        //通过客户获取营销任务
        String seller = customer.getServiceMan().getRealName();
        variables.put("seller", seller);

        //在流程已启动把业务对象类型和业务对象Id放入流程变量,以后再流程中就可以获取这两个参数,通过他们就可以查询业务对象.
        variables.put("businessObjType", customer.getClass().getSimpleName());
        variables.put("businessObjId", customer.getId());
        workFlowService.startProcess(processDefinitionKey,variables);
    }

    @Override
    public Map<String, String> loadFormData(Long businessObjId) {
        TCustomer customer = dao.selectByPrimaryKey(businessObjId);
        //声明
        Map<String, String> result = new HashMap<>();
        //转换
        result.put("name", customer.getRealName());

        String genderStr = "未知";
        Integer gender = customer.getGender();
        if (gender == 0) {
            genderStr = "男";
        }else if (gender==1) {
            genderStr = "女";
        }
        result.put("gender", genderStr);
       /* TSystemDictionaryItem job = customer.getJob();
        if (job!= null) {
            result.put("job", job.getTitle());
        }*/

        TEmployee seller = customer.getServiceMan();
        if (seller!= null) {
            result.put("seller", seller.getRealName());
        }
        Integer status = customer.getAge();
        // 0初始录入，-1作废（放入资源池）1 报备中 2 报备完成
        String statusStr = "作废";
        if (status == 0) {
            statusStr = "初始录入";
        }else if (status==1) {
            statusStr = "报备中";
        }
        else if (status==2) {
            statusStr = "报备完成";
        }
        result.put("status", statusStr);
        //返回
        return result;
    }

    @Override
    public List<TCustomer> getAllTCustomerById(Long serviceManId) {
        return dao.getAllTCustomerById(serviceManId);
    }

    @Override
    public List<TCustomer> getAllTCustomerByTeam(Long team) {
        return dao.getAllTCustomerByTeam(team);
    }

    @Override
    public List<TCustomer> getAllTCustomerByQuery(CustomerQuery customerQuery) {
        return dao.getAllTCustomerByQuery(customerQuery);
    }

    @Override
    public TCustomer updateCustomer(TCustomer customer) {
        dao.updateByPrimaryKey(customer);
        return customer;
    }

    @Override
    public TCustomer getCustomerById(CustomerPojo customerPojo) {
        return dao.getCustomerById(customerPojo);
    }

    @Override
    public TCustomer loginByCustomerName(String customerName) {
        return dao.loginByCustomerName(customerName);
    }

    @Override
    public TCustomer loginByWeChat(String fromUserName) {
        return dao.loginByWeChat(fromUserName);
    }


    @Override
    @Transactional()
    public void delete(Serializable id) {
        dao.removeCustomerEmployees(id);
        dao.deleteByPrimaryKey(id);
    }
}
