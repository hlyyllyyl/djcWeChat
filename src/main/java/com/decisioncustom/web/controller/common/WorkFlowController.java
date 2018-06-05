package com.decisioncustom.web.controller.common;

import com.decisioncustom.pojo.ActivitiPojo;
import com.decisioncustom.service.IWorkFlowService;
import com.decisioncustom.utils.AjaxResult;
import com.decisioncustom.utils.UserContext;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


/**
 * 工作流相关Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/workFlow")
public class WorkFlowController {

	@Autowired
	private IWorkFlowService workFlowService;
	
	//跳转到流程定义管理页面
	@RequestMapping("/processDefinition/index")
	public String processDefiniton(HttpServletRequest request) {

		List processDefinitions = workFlowService.listProcessDefinitions();
		request.setAttribute("processDefinitions",processDefinitions);
		//流程定义管理界面路径,默认加上前缀和后缀
		return "workFlow/processDefinition";
	}
	//跳转到流程定义管理页面
	@RequestMapping("/edit")
	public String process(HttpServletRequest request) {
		request.setAttribute("activitiPojo",new ActivitiPojo());
		//流程定义管理界面路径,默认加上前缀和后缀
		return "workFlow/edit_Task";
	}
	/**
	 * 参数:
	 *    name:部署名称
	 *    processFile:类型是MultipartFile,是SPringmvc用于文件上传接收的专用类
	 * 返回值:
	 *    AJaxResult转换结果
	 * @return
	 */
	@RequestMapping("/newDeploy")
	@ResponseBody
	public AjaxResult newDeploy(String name, MultipartFile processFile) {
		System.out.println(name);
		System.out.println(processFile);
		//1 不要直接注入RepositoryService来完成部署,应该交给对应Service去做
		//2 MultipartFile就是web层api,如果我们直接传入,Service层就强依赖于web层API.也就是咱们这个Service必须在web才能运行,不能强依赖.
		try {
			workFlowService.newDeploy(name,processFile.getInputStream());
			return new AjaxResult();
		} catch (IOException e) {
			e.printStackTrace();
			return new AjaxResult("部署失败!"+e.getMessage(),-1);
		}
	}
	//参数:无
	//返回值:流程定义的list json格式
	@RequestMapping("/listProcessDefinitions")
	@ResponseBody
	public List<Map<String, Object>> listProcessDefinitions() {
		
		return workFlowService.listProcessDefinitions();
	}
	
	//<img src="/workFlow/viewDiagram?deploymentId=1&diagarmResoruceName=test.png"/>
	/**
	 * 参数:
	 *    deploymentId:部署id
	 *    diagarmResoruceName:流程图资源名称
	 * 返回值:
	 *   不需要返回值(页面,ajax数据),只是把获取的流直接拷贝到responses中完成响应
	 * @return
	 */
	@RequestMapping("/viewDiagram")
	public void viewDiagram(String deploymentId,String diagarmResoruceName,HttpServletResponse response) {
		InputStream is = null;
		ServletOutputStream os = null;
		try {
			 is = workFlowService.viewDiagram(deploymentId,diagarmResoruceName);
			 os = response.getOutputStream();
			IOUtils.copy(is, os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//跳转到待办任务的管理界面
	///workFlow/personalTask/index
	@RequestMapping("/personalTask/index")
	public String personalTask(HttpServletRequest request)
	{
		//把Session里面用户传入Service,降低Service与web层耦合
		String assignee = UserContext.getUser().getRealName();
		List personalTasks = workFlowService.listPersonalTasks(assignee);
		request.setAttribute("personalTasks",personalTasks);
		return "workFlow/personalTask";
	}
	
	//列表待办任务
	//workFlow/listPersonalTasks
	/**
	 * 当前登录用户的待办任务
	 * 参数:
	 *  当前登录用户,Session已经存放,不要传递
	 * 返回值:
	 *    原来返回值:List<Task>和原来流程定义一样要用Map
	 * @return
	 */
	@RequestMapping("/listPersonalTasks")
	@ResponseBody
	public List<Map<String,Object>> listPersonalTasks() {
		
		//把Session里面用户传入Service,降低Service与web层耦合
		String assignee = UserContext.getUser().getRealName();
		return workFlowService.listPersonalTasks(assignee);
	}
	
	
	@RequestMapping("/completeTask")
	@ResponseBody
	public AjaxResult completeTask(String taskId) {
		try {
			workFlowService.completeTask(taskId);
			return new AjaxResult();
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult("办理任务失败!", -1);
		}
		
	}
	
}
