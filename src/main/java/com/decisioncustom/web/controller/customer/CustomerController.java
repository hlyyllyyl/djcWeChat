package com.decisioncustom.web.controller.customer;

import com.decisioncustom.domain.Role;
import com.decisioncustom.domain.TCustomer;
import com.decisioncustom.domain.TEmployee;
import com.decisioncustom.pojo.CustomerPojo;
import com.decisioncustom.query.CustomerQuery;
import com.decisioncustom.service.ICustomerService;
import com.decisioncustom.service.IEmployeeService;
import com.decisioncustom.service.IRoleService;
import com.decisioncustom.service.ISystemDictionaryItemService;
import com.decisioncustom.utils.APIResult;
import com.decisioncustom.utils.AjaxResult;
import com.decisioncustom.utils.MD5Until;
import com.decisioncustom.utils.globalVariable.GlobalVariable;
import com.decisioncustom.utils.page.PageHelper;
import com.decisioncustom.utils.page.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;

    @RequestMapping("/list")
    public String toIndex(@RequestParam(required=true,defaultValue="1") Integer page,CustomerQuery customerQuery,
                          HttpServletRequest request, Model model) {
        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TEmployee user = (TEmployee) currenUser.getPrincipal();
        Long id= user.getId();
        List<Role> roles = roleService.getRoleByLoginId(id);
        List<TEmployee> serviceManList = employeeService.findAll();
        PageHelper.startPage(page, 10);
        for(Role r :roles){
            String sn = r.getSn();
			/*判断是否有客服经理的权限*/
            if (sn.equals("service_dept_manager")){
                List<TCustomer> customerList = customerService.getAllTCustomerByQuery(customerQuery);
                PageInfo<TCustomer> p= new PageInfo<>(customerList);
                request.setAttribute("page", p);
                request.setAttribute("APP_PATH", "/customer/list");
                request.setAttribute("command",customerQuery);
                request.setAttribute("customerList",customerList);
                model.addAttribute("serviceManList",serviceManList);
                return "customer/list_customer";
            }
        }
       /* Long team = user.getTeam();
        Long isTeamLeader = user.getIsTeamLeader();
		*//*根据是否组长查询个人数据或者小组数据*//*
        if(isTeamLeader!=null && isTeamLeader==1){
            customerQuery.setTeam(team);
            List<TCustomer> customerList = customerService.getAllTCustomerByQuery(customerQuery);
            PageInfo<TCustomer> p= new PageInfo<>(customerList);
            request.setAttribute("page", p);
            request.setAttribute("APP_PATH", "/customer/list");
            request.setAttribute("command",customerQuery);
            request.setAttribute("customerList",customerList);
        }else{
            List<TCustomer> customerList = customerService.getAllTCustomerById(id);
            PageInfo<TCustomer> p= new PageInfo<>(customerList);
            request.setAttribute("page", p);
            request.setAttribute("APP_PATH", "/customer/list");
            request.setAttribute("command",customerQuery);
            request.setAttribute("customerList",customerList);
        }*/
        List<TCustomer> customerList = customerService.getAllTCustomerById(id);
        PageInfo<TCustomer> p = new PageInfo<>(customerList);
        request.setAttribute("page", p);
        request.setAttribute("APP_PATH", "/customer/list");
        request.setAttribute("command",customerQuery);
        request.setAttribute("customerList",customerList);
        return "customer/list_customer";
    }

    /*客户信息编辑*/
    @RequestMapping("/customer_edit")
    public String customer_edit(Long id,HttpServletRequest request, Model model) {
        boolean isNew = true;
        List<TEmployee> serviceManList = employeeService.findAll();
        model.addAttribute("serviceManList",serviceManList);
        if(id!=null){
            TCustomer customer = customerService.findOne(id);
            model.addAttribute("customer",customer);
            return "customer/customer_edit";
        }
        TCustomer newCustomer = new TCustomer();
        model.addAttribute("isNew",isNew);
        model.addAttribute("customer",newCustomer);
        return "customer/customer_edit";
    }

    /*客户信息保存*/
    @RequestMapping("/customer_save")
    @ResponseBody
    public AjaxResult customer_save(TCustomer customer, HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        String turnOnTimeStr= request.getParameter("turnOnTimeStr");
        String endTimeStr= request.getParameter("endTimeStr");
     /*   String investTypeStr = customer.getInvestTypeStr();
        String operatingStyleStr= customer.getOperatingStyleStr();*/
        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer user = (TCustomer) currenUser.getPrincipal();
        Long serviceManId= user.getId();

        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            customer.setTurnOnTime(bf.parse(turnOnTimeStr));
            customer.setEndTime(bf.parse(endTimeStr));
           /* customer.setInvestTypeId(Long.valueOf(investTypeStr));
            customer.setOperatingStyleId(Long.valueOf(operatingStyleStr));*/
            customer.setRegisterTime(new Date());
            if(id!=null && !id.equals("")){
                customerService.updateSelective(customer);
            }else {
                customerService.createSelective(customer);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new AjaxResult();
    }



    /* 跳转到密码修改页面*/
    @RequestMapping("/updatePassword")
    public String update(HttpServletRequest request, Model model){
        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer customer = (TCustomer) currenUser.getPrincipal();
        CustomerPojo customerPojo = new CustomerPojo();
        customerPojo.setId(customer.getId());
        TCustomer tCustomer= customerService.getCustomerById(customerPojo);
        System.out.print(customer);
        model.addAttribute("customer",tCustomer);
        return "column/update-password";
    }

    /* 密码修改保存*/
    @RequestMapping("/savePassword")
    @ResponseBody
    public APIResult password(TCustomer customer, Model model){
        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer tCustomer = (TCustomer) currenUser.getPrincipal();
        String oldPassword = tCustomer.getPassword();
        String newPassword = customer.getNewPassword();
        String password = customer.getPassword();
        String soltPassword= MD5Until.encrypt(password);
        System.out.print(password+"====="+oldPassword);
        System.out.print(password+"====="+soltPassword);
        if (oldPassword.equals(soltPassword)){
            customer.setId(tCustomer.getId());
            customer.setPassword(MD5Until.encrypt(newPassword));
            customerService.updateSelective(customer);
            return new APIResult().setMessage("修改成功");
        }else{
            return new APIResult().setMessage("用户名密码不匹配！");
        }
    }



    //===================流程相关方法==========================================
    @RequestMapping("/startProcess")
    @ResponseBody
    public AjaxResult startProcess(Long businessObjId) {
        System.out.println(businessObjId);
        try {
            //不要在这儿直接写方法,没有事务支持,要放入service实现
            customerService.startProcess(businessObjId);
            return new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("启动报备流程失败!", -1);
        }

    }

    //一forward方式跳转到formKey所对应的表单结构页面
    @RequestMapping("/loadForm")
    public String loadForm(String formKey) {
        ///WEB-INF/views/customer/taskForm.jsp
        //formKey就有前缀和后缀了,不要加前缀和后缀
        return "forward:"+formKey;
    }

    /**
     * 参数:业务对象Id
     * 返回值:本来获取到的是Customer,直接放回Map<String,String>
     * @param businessObjId
     * @return
     */
    @RequestMapping("/loadFormData")
    @ResponseBody
    public Map<String, String> loadFormData(Long businessObjId) {
        return customerService.loadFormData(businessObjId);
    }
    //===================流程相关方法==========================================

}
