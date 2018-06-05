package com.decisioncustom.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 工作流相关Service接口
 * @author Administrator
 *
 */
public interface IWorkFlowService {

	/**
	 * 通过部署名称,和部署文件zip压缩包的流程部署流程
	 * @param name
	 * @param inputStream
	 */
	void newDeploy(String name, InputStream inputStream);

	/**
	 * 列表流程定义
	 * @return
	 */
	List<Map<String, Object>> listProcessDefinitions();

	/**
	 * 通过部署Id和流程图资源名获取流程图所对应的流
	 * @param deploymentId
	 * @param diagarmResoruceName
	 * @return
	 */
	InputStream viewDiagram(String deploymentId, String diagarmResoruceName);

	/**
	 * 通过流程定义key和流程变量启动流程
	 * @param processDefinitionKey
	 * @param variables
	 */
	void startProcess(String processDefinitionKey, Map<String, Object> variables);

	/**
	 * 列表待办任务
	 * @param assignee
	 * @return
	 */
	List<Map<String, Object>> listPersonalTasks(String assignee);

	/**
	 * 办理任务
	 * @param taskId
	 */
	void completeTask(String taskId);

}
