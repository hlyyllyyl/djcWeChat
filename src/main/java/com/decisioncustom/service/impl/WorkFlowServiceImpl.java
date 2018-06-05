package com.decisioncustom.service.impl;

import com.decisioncustom.service.IWorkFlowService;
import com.decisioncustom.utils.CommUtil;
import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

@Service
public class WorkFlowServiceImpl implements IWorkFlowService {

	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private FormService formService;
	
	@Override
	public void newDeploy(String name, InputStream inputStream) {
		//完成真正部署
		//1获取引擎对象
		//2获取服务
		//3做事情
		ZipInputStream zis = null;
		try {
			zis = new ZipInputStream(inputStream);
			//创建配置对象
			DeploymentBuilder builder = repositoryService.createDeployment();
			//进行配置
			builder.name(name)//部署名称
			       .addZipInputStream(zis);  //bpmn和png
			//部署
			builder.deploy();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		finally{
			if (zis != null) {
				try {
					zis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Map<String, Object>> listProcessDefinitions() {
		//创建查询对象
		ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
		//设置查询条件
		query.orderByProcessDefinitionKey().desc();//相同的流程不同的版本放到一起
		query.orderByProcessDefinitionVersion().desc();//版本安倒序排
		//做查询
		List<ProcessDefinition> list = query.list();
		
		//申明要返回的类型
		List<Map<String, Object>>  result = new ArrayList<>();
		//进行转换
		for (ProcessDefinition processDefinition : list) {
			//把一个processDefinition转换为一个Map
			result.add(processDefinition2map(processDefinition));
		}
		//返回
		return result;
	}

	private Map<String, Object> processDefinition2map(ProcessDefinition processDefinition) {
		//申明要返回的类型
//		Map<String, Object> result = new HashMap<>();
		//进行转换
//		result.put("id", processDefinition.getId());
		//返回
//		return result;
          return CommUtil.obj2map(processDefinition, new String[]{
        		 "id","name","key",
        		 "version","deploymentId","resourceName",
        		 "diagramResourceName","description"
          });
	}

	@Override
	public InputStream viewDiagram(String deploymentId, String diagarmResoruceName) {
		return repositoryService.getResourceAsStream(deploymentId, diagarmResoruceName);
	}

	@Override
	public void startProcess(String processDefinitionKey, Map<String, Object> variables) {

		runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);
		
	}

	@Override
	public List<Map<String, Object>> listPersonalTasks(String assignee) {
		
		//创建查询对象
		TaskQuery query = taskService.createTaskQuery();
		//设置查询条件
		query.taskAssignee(assignee);
		query.orderByProcessInstanceId().desc();//相同规则放到一起
		query.orderByTaskCreateTime().desc();//按时间倒序
		//做查询-List<Task>
		List<Task> list = query.list();
		   //声明要返回类型
			List<Map<String, Object>> result = new ArrayList<>();
		   //转换
			for (Task task : list) {
				//一个task就是一个map
				result.add(task2map(task));
			}
		   //返回
		return result;
	}

	private Map<String, Object> task2map(Task task) {
		// Map<String, Object> result = new HashMap<>();
		// result.put("id", task.getId());
		Map<String, Object> obj2map = CommUtil
				.obj2map(task, new String[] { "id", "name", "assignee", "createTime", "description" });
		//为了构造动态表单,需要将formKey businessObjType businessObjId这三个参数和task属性一起返回 
		obj2map.put("businessObjType", getBusinessObjType(task));
		obj2map.put("businessObjId", getBusinessObjId(task));
		obj2map.put("formKey", getFormKey(task));
		return obj2map;
	}

	private String getFormKey(Task task) {
		//方式1:通过task直接获取-有兼容性问题,老版本中不能直接获取
		String formKey = task.getFormKey();
		//方式2:通过FormService的getTaskFormKey方法获取
		/*
		String processDefinitionId = task.getProcessDefinitionId();
		String taskDefinitionKey = task.getTaskDefinitionKey();
		formKey = formService.getTaskFormKey(processDefinitionId, taskDefinitionKey);*/
	     //方式3:通过FormService获取TaskFormData,在TaskFormData中获取formKey
	     //这一种方式不仅可以获取formKey还能获取表单属性
		/*
	     formKey = formService.getTaskFormData(task.getId()).getFormKey();
	     System.out.println(formKey);*/
		return formKey;
	}

	private Long getBusinessObjId(Task task) {
		return taskService.getVariable(task.getId(), "businessObjId", Long.class);
	}

	private String getBusinessObjType(Task task) {
		//Customer LeaveBill
		String businessObjType = taskService.getVariable(task.getId(), "businessObjType", String.class);
		businessObjType = businessObjType.substring(0, 1).toLowerCase()+businessObjType.substring(1);
		return businessObjType;
	}

	@Override
	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}

}
