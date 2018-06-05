package com.decisioncustom.activiti.listener;

import com.decisioncustom.service.IEmployeeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 用来设置审核经理
 * @author Administrator
 *
 */
//由于要注入Spring里面的Bean,所以本身也要交给Spring管理
//问题:不能注入employeeService
//分析:
	//ManagerSettingListener是给流程引擎创建"审批任务"是用来设置办理者,
	//而这时ManagerSettingListener的bean已经交个Spring管理,正常情况流程引擎直接从Spring中获取就ok.
	//但是流程引擎不知道要从Spring中去获取ManagerSettingListener
//解决方案:告诉流程引擎从Spring中获取监听器,而不要自己创建了.
@Component //还需要设置扫描路径
public class ManagerSettingListener implements TaskListener {

	@Autowired
	private IEmployeeService employeeService;

	@Override
	public void notify(DelegateTask delegateTask) {
		//获取审批人员  获取营销人员---部门----部门经理
	/*	String sellerNickName = delegateTask.getVariable("seller", String.class);*/
		/*System.out.println(sellerNickName);
		System.out.println(employeeService);*/
		// Employee employee = employeeService.findBYNickName();
		// Department dept= employee.getDept();
		// Employee manager = dept.getManager();
		
		//写死"超级管理员"-超级管理员就可以获取审批任务
		delegateTask.setAssignee("超级管理员");
	}

}
