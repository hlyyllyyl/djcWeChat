package com.decisioncustom.web.controller.leavewords;

import com.decisioncustom.domain.Role;
import com.decisioncustom.domain.TCustomer;
import com.decisioncustom.domain.TEmployee;
import com.decisioncustom.domain.TLeaveWords;
import com.decisioncustom.query.LeaveWordsQuery;
import com.decisioncustom.service.ILeaveWordsService;
import com.decisioncustom.service.IRoleService;
import com.decisioncustom.utils.AjaxResult;
import com.decisioncustom.utils.page.PageHelper;
import com.decisioncustom.utils.page.PageInfo;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/leave_words")
public class LeaveWordsController {

    @Autowired
    private ILeaveWordsService leaveWordsService;

    @Autowired
    private IRoleService roleService;

    /*客户留言列表*/
    @RequestMapping("/list")
    public String toIndex(@RequestParam(required=true,defaultValue="1") Integer page,LeaveWordsQuery leaveWordsQuery,
                          HttpServletRequest request, Model model) {
        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TEmployee user = (TEmployee) currenUser.getPrincipal();
        Long id= user.getId();

        List<Role> roles = roleService.getRoleByLoginId(id);
        PageHelper.startPage(page, 10);
        for(Role r :roles){
            String sn = r.getSn();
			/*判断是否有经理的权限*/
            if (!sn.equals("service_dept_manager")){
                leaveWordsQuery.setTeacherId(id);
            }
                List<TLeaveWords> leaveWordsList  = leaveWordsService.getAllLeaveWordsByQuery(leaveWordsQuery);
                PageInfo<TLeaveWords> p= new PageInfo<>(leaveWordsList);
                request.setAttribute("page", p);
                request.setAttribute("APP_PATH", "/leave_words/list");
                request.setAttribute("command", leaveWordsQuery);
                request.setAttribute("leaveWordsList", leaveWordsList);
                return "leave/list_leave_words";
        }
       return null;
    }

    /*客户留言删除*/
    @RequestMapping("/del")
    @ResponseBody
    public AjaxResult del(HttpServletRequest request, Model model) {
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
                        leaveWordsService.delete(Long.valueOf(id));
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

    /*客户留言保存*/
    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult save(TLeaveWords leaveWords, HttpServletRequest request, Model model) {
        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer user = (TCustomer) currenUser.getPrincipal();
        leaveWords.setCustomerId(user.getId());
        leaveWords.setLeaveDate(new Date());
        leaveWordsService.createSelective(leaveWords);
        return new AjaxResult();
    }
}
