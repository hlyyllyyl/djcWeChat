package com.decisioncustom.web.controller.employee;

import com.decisioncustom.domain.Role;
import com.decisioncustom.domain.TEmployee;
import com.decisioncustom.service.IEmployeeService;
import com.decisioncustom.service.IRoleService;
import com.decisioncustom.utils.AjaxResult;
import com.decisioncustom.utils.MD5Until;
import com.decisioncustom.utils.page.PageHelper;
import com.decisioncustom.utils.page.PageInfo;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(@RequestParam(required=true,defaultValue="1") Integer page,TEmployee employee,
                          HttpServletRequest request, Model model) {
        Long id = employee.getId();
        if(id!=null && !id.equals("")){
            employeeService.updateEmployee(employee);
        }else{
            String password = employee.getPassWord();
            System.out.print(MD5Until.encrypt(password));
            employee.setPassWord(MD5Until.encrypt(password));
            employeeService.createSelective(employee);
        }
        return new AjaxResult();
    }
    @RequestMapping("/accredit_save")
    @ResponseBody
    public AjaxResult accreditSave(@RequestParam(required=true,defaultValue="1") Integer page,TEmployee employee,
                           HttpServletRequest request, Model model) {
            String[] roleStrs = employee.getRoleStrs();
            List<Role> roles= new ArrayList<>();
            for (int i = 0; i <roleStrs.length ; i++) {
                System.out.print(i);
                Role role = roleService.getOne(Long.valueOf(roleStrs[i]));
                roles.add(role);
            }
            employee.setRoles(roles);
            employeeService.updateSelective(employee);
        return new AjaxResult();
    }
    @RequestMapping("/list")
    public String getTeachers(@RequestParam(required=true,defaultValue="1") Integer page,
                          HttpServletRequest request, Model model) {
        PageHelper.startPage(page, 10);
       List<TEmployee> teachersList = employeeService.findAll();
        System.out.print(teachersList);
        PageInfo<TEmployee> p= new PageInfo<>(teachersList);
        request.setAttribute("page", p);
        request.setAttribute("APP_PATH", "/employee/list");
        request.setAttribute("teachersList",teachersList);
        return "employee/list_teacher";
    }

    @RequestMapping("/edit")
    public String teacherEdit(Long id,HttpServletRequest request, Model model) {
        boolean isNew = true;
        if(id!=null){
            TEmployee  teacher = employeeService.findOne(id);
            System.out.print(teacher);
            model.addAttribute("teacher",teacher);
            return "employee/edit_teacher";
        }
        TEmployee newTeacher= new TEmployee();
        model.addAttribute("isNew",isNew);
        model.addAttribute("teacher",newTeacher);
        return "employee/edit_teacher";
    }
    /*授权*/
    @RequestMapping("/accredit")
    public String teacherAccredit(Long id,HttpServletRequest request, Model model) {

            TEmployee  teacher = employeeService.getRoleById(id);
            List<Role> roles= teacher.getRoles();
            List<Role> roleList= roleService.getAll();
            StringBuilder roleIds = new StringBuilder();
            for (Role c : roles){
                roleIds.append(c.getId()+",");
            }
            request.setAttribute("roleIds",roleIds);
            model.addAttribute("roleList",roleList);
            model.addAttribute("teacher",teacher);
        return "employee/accredit_role";
    }

    @RequestMapping("/select_del")
    @ResponseBody
    public AjaxResult selectDelBooks(HttpServletRequest request, Model model) {
        try {
            ServletInputStream inputStream = request.getInputStream();
            String mybooksid = IOUtils.toString(inputStream);
            JSONArray jsonarr = new JSONArray(mybooksid);
            List<String> book_id = new ArrayList<>();
            for (int i=0;i<jsonarr.length();i++){
                book_id.add(((JSONObject)jsonarr.get(i)).getString("book_id"));
            }
            for (String id:book_id) {
                try {
                    if (!id.equals("on")){
                        TEmployee employee = employeeService.findOne(Long.valueOf(id));
                        String img = employee.getHeadImg();
                        // 获取图片的文件名
                        String productFigurepath =request.getSession().getServletContext().getRealPath("/");
                        /*删除原图*/
                        File file = new File(productFigurepath+img);
                        if(file.exists()){
                            file.delete();
                        }
                        employeeService.delete(Long.valueOf(id));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return new AjaxResult("操作失败："+e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  new AjaxResult();
    }

}
