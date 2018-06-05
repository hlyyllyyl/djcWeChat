package com.decisioncustom.utils.log;

import com.decisioncustom.domain.TSystemFrontLog;
import com.decisioncustom.service.ISystemFrontLogService;
import com.decisioncustom.service.impl.SystemFrontLogServiceImpl;
import com.decisioncustom.utils.UserContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class SystemLogUntil {
	/**
	 private Long id;
	 //操作人员
	 private Employee openUser;
	 //进行操作的时间
	 private Date openTiem;
	 //操作的ip
	 private String openIp;
	 //操作的信息
	 private String function;

	 封装上面的信息
	 */


	@Autowired
	private ISystemFrontLogService systemLogService;



	public void writeLog(JoinPoint joinPoint){

//		if(joinPoint.getTarget() instanceof PermissionServiceImpl){
//
//		}else{
		//只要条用service方法就会被切
		TSystemFrontLog log = new TSystemFrontLog();
		//设置访问时间和访问对象
		log.setOpenDate(new Date());
			if(UserContext.getUser() != null){
				log.setOpenUser(UserContext.getUser().getRealName());
			}
		//设置 ip地址
		String ip = UserContext.getUserIp();

		log.setOpenIp(ip);
		//设置调用的方法
		String string1 = joinPoint.getSignature().getDeclaringTypeName();
		String string2 = joinPoint.getSignature().getName();

		log.setFunction(string1+"----"+string2);

		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		System. out.println("====调用" +methodName+"方法-开始！");
		Object[] arguments = joinPoint.getArgs();   //获得参数列表



		StringBuilder parameter= new StringBuilder();
		if(arguments.length<=0){
			System.out.println("=== "+methodName+" 方法没有参数");
		}else{
			for(int i=0;i<arguments.length;i++){
				System.out.println("==== 参数   "+(i+1)+" : "+arguments[i]);
				parameter.append(arguments[i]);
			}
		}

		try {
			Class targetClass = Class.forName(targetName);
			Method[] method = targetClass.getMethods();
			String methode = "";
			for (Method m : method) {
				if (m.getName().equals(methodName)) {
					Class[] tmpCs = m.getParameterTypes();
					if (tmpCs.length == arguments.length) {
						BussAnnotation methodCache = m.getAnnotation(BussAnnotation.class);
						if(methodCache!=null && !methodCache.equals("")){
							methode = methodCache.moduleName();
						}
						break;
					}
				}
			}
			if(methode.equals("文章管理")){
				/*Long s = (Long) arguments[0];
				TAllText researchResult= allTextService.findOne(s);*/
				/*articleService.*/
			}
			System.out.print(methode);
			if(!methode.equals("")){
				methode = methode+"：";
			}
			log.setParameter(methode+parameter.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (joinPoint.getTarget() instanceof SystemFrontLogServiceImpl) {
			//是这个类不进行任何操作
		}else{
			//不是这个类，就是将数据写进去
			if(arguments.length>0){
				systemLogService.createSelective(log);
			}
		}
	}
}




