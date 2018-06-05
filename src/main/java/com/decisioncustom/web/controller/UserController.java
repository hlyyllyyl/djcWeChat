package com.decisioncustom.web.controller;

import com.decisioncustom.domain.TUser;
import com.decisioncustom.service.IUserService;
import com.decisioncustom.utils.APIResult;
import com.decisioncustom.utils.SaveFile;
import com.decisioncustom.utils.page.PageHelper;
import com.decisioncustom.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

   @RequestMapping("/list")
    public String toIndex(@RequestParam(required=true,defaultValue="1") Integer page,
                          HttpServletRequest request, Model model) {
        PageHelper.startPage(page, 5);
       List<TUser> userList = userService.getAllUser();
       System.out.print(userList);
        PageInfo<TUser> p= new PageInfo<>(userList);
       request.setAttribute("page", p);
       request.setAttribute("APP_PATH", "http://127.0.0.1:8080/user/list");
       request.setAttribute("userList",userList);
        return "user/list_user";
    }
    @RequestMapping("/save")
    @ResponseBody
    public APIResult save(@RequestParam(required=true,defaultValue="1") Integer page,TUser user,
                          @RequestParam("userHeadImg") MultipartFile userHeadImg,
                          HttpServletRequest request, Model model) {
        try {
              /*保存商品图片*/
            if (userHeadImg != null && !userHeadImg.isEmpty()) {
                // 获取图片的文件名
                String productFigurepath = request.getServletContext().getRealPath("/upload/image");
                String productFigureFileUUID = UUID.randomUUID().toString();
                String productFigureRealPath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
                String productFigurePath = "";
                productFigurePath = productFigureRealPath + "/upload/image" + "/" + productFigureFileUUID + userHeadImg.getOriginalFilename();
                SaveFile.saveFile(productFigurepath, productFigureFileUUID, userHeadImg);
                //将上传文件保存到一个目标文件当中
                user.setHeadimg(productFigurePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        userService.createSelective(user);
        return new APIResult();
    }
    @RequestMapping("/getTeachers")
    public String getTeachers(@RequestParam(required=true,defaultValue="1") Integer page,
                          HttpServletRequest request, Model model) {
        PageHelper.startPage(page, 5);
       List<TUser> teachersList = userService.getAllTeachers();
        System.out.print(teachersList);
        PageInfo<TUser> p= new PageInfo<>(teachersList);
        request.setAttribute("page", p);
        request.setAttribute("APP_PATH", "http://localhost/user/getTeachers");
        request.setAttribute("teachersList",teachersList);
        return "employee/list_teacher";
    }


    @RequestMapping("/getUser")
    @ResponseBody
    public APIResult USER (@RequestParam(required = true, defaultValue = "1") Integer page,
                           HttpServletRequest request, Model model) {
       PageHelper.startPage(page, 5);
        List<TUser> userList = userService.getAllUser();
        System.out.println(userList);
        PageInfo<TUser> p = new PageInfo<>(userList);
        System.out.println(p);
        request.setAttribute("page", p);
        request.setAttribute("userList",userList);
        return APIResult.success().setData(userList);
    }
    @RequestMapping("/user_edit")
    public String list(Long id,HttpServletRequest request, Model model) {
        boolean isNew = true;
        boolean headImgExist = false;
       if(id!=null){
        TUser  user = userService.findOne(id);
        if(user.getHeadimg()!=null){
            headImgExist = true;
            model.addAttribute("headImg",user.getHeadimg());
        }
        model.addAttribute("user",user);
        model.addAttribute("headImgExist",headImgExist);
           return "user/edit_user";
       }
      TUser newUser= new TUser();
       model.addAttribute("isNew",isNew);
      model.addAttribute("user",newUser);
      return "user/edit_user";
    }
    @RequestMapping("/teacher_edit")
    public String teacherEdit(Long id,HttpServletRequest request, Model model) {
        boolean isNew = true;
        boolean headImgExist = false;
        if(id!=null){
            TUser  teacher = userService.findOne(id);
            if(teacher.getHeadimg()!=null){
                headImgExist = true;
                model.addAttribute("headImg",teacher.getHeadimg());
            }
            model.addAttribute("teacher",teacher);
            model.addAttribute("headImgExist",headImgExist);
            return "employee/edit_teacher";
        }
        TUser newTeacher= new TUser();
        model.addAttribute("isNew",isNew);
        model.addAttribute("teacher",newTeacher);
        return "employee/edit_teacher";
    }
}
