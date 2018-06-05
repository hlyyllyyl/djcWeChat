package com.decisioncustom.activiti.listener;

import com.decisioncustom.domain.TCustomer;
import com.decisioncustom.service.ICustomerService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 绑定到结束节点用来修改业务对象的状态(把客户的状态改为报备完成)
 * @author Administrator
 *
 */
@Component //生成一个名为endListener的bean
public class EndListener implements ExecutionListener {

	@Autowired
	private ICustomerService customerService;

	@Override
	public void notify(DelegateExecution execution) throws Exception {

		//获取业务对象-客户
		Long id = execution.getVariable("businessObjId", Long.class);
		TCustomer customer = customerService.findOne(id);
		//修改状态
		customer.setAge(2);
		//更新回去
		customerService.update(customer);
	}
}
