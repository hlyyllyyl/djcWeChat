
package com.decisioncustom;

import com.decisioncustom.wexin.WeixinConstants;
import org.junit.Test;

public class EmployeeServiceTest extends BaseServiceTest {


  // 错误的,必须使用注解
  // public void setEmployeeService(IEmployeeService employeeService) {
  // this.employeeService = employeeService;
  // }


  @Test
  public void update() throws Exception {
      System.out.println(WeixinConstants.getProperty("APPID"));
  }

}

