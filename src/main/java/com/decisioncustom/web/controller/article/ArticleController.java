package com.decisioncustom.web.controller.article;

import com.decisioncustom.domain.*;
import com.decisioncustom.pojo.CustomerColumnPojo;
import com.decisioncustom.query.ArticleQuery;
import com.decisioncustom.service.*;
import com.decisioncustom.utils.APIResult;
import com.decisioncustom.utils.page.PageHelper;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IColumnService columnService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IArticleService articleService;

    @Autowired
    private IAdvertisingService advertisingService;

    @Autowired
    private ICustomerColumnService customerColumnService;

    @RequestMapping("/article")
    public String toIndex0(Long id,
                           HttpServletRequest request, Model model) {
        TArticle article = articleService.getArticleById(id);
        Long columnId = article.getColumnId();
        Integer  top = article.getTop();
        String columnName = columnService.findOne(columnId).getParentColumn().getName();
        request.setAttribute("columnName",columnName);
        request.setAttribute("columnId",columnId);
        //===========================判断是否在当前栏目服务期间===================================
        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer user = (TCustomer) currenUser.getPrincipal();
        if(user==null){
            return "redirect:/main/index";
        }
        Long userId = user.getId();
		/*获取客户所购买的服务*/
        TCustomerColumn customerColumn= customerColumnService.
                selectAllByCustomer(new CustomerColumnPojo(userId,columnId));
        if(customerColumn==null) {
            return "common/notColumn";
        }
		/*判断是否在有效时期内*/
        Date startTime = customerColumn.getStartTime();
        Date endTime  = customerColumn.getEndTime();
        Long startTimeTime = startTime.getTime();
        Long endTimeTime = endTime.getTime();
        Long time = new Date().getTime();
        if(time < startTimeTime || time > endTimeTime){
            return "common/notTime";
        }
        //===========================判断是否在当前栏目服务期间===================================
        ArticleQuery topArticleQuery = new ArticleQuery(1,columnId);
       /* topArticleQuery.setTop(1);
        topArticleQuery.setColumnId(columnId);*/
        TArticle topArticle = articleService.getNextByQuery(topArticleQuery);

        ArticleQuery upArticleQuery = new ArticleQuery(top,columnId,startTime);
        ArticleQuery nextArticleQuery = new ArticleQuery(top,columnId,startTime);


        upArticleQuery.setUpId(id);
        nextArticleQuery.setNextId(id);

        TArticle upArticle= articleService.getNextByQuery(upArticleQuery);
        TArticle nextArticle = articleService.getNextByQuery(nextArticleQuery);

        if(upArticle==null && top==0 && topArticle!=null){
            upArticle = topArticle;
        }

        if(top==1){
            ArticleQuery topNextArticleQuery = new ArticleQuery(columnId,startTime);
            TArticle topNextArticle = articleService.getNextByQuery(topNextArticleQuery);
            nextArticle = topNextArticle;
        }
        request.setAttribute("upArticle",upArticle);
        request.setAttribute("nextArticle",nextArticle);
        /*修改文章浏览量*/
        request.setAttribute("article",article);
        Long readingQuantity = article.getReadingQuantity();
        article.setReadingQuantity(readingQuantity+1);
        article.setId(id);
        articleService.updateSelective(article);

        /*修改老师浏览量*/
        Long teacherId = article.getTeacherId();
        TEmployee tEmployee = employeeService.findOne(teacherId);
        tEmployee.setReadingQuantity(tEmployee.getReadingQuantity()+1);
        tEmployee.setId(tEmployee.getId());
        employeeService.updateEmployee(tEmployee);

        String nameRemark = article.getColumn().getNameRemark();
        List<TAdvertising> advertising = advertisingService.selectAdByName(nameRemark);
        if(advertising.size()>0){
          request.setAttribute("advertising",advertising.get(0));
        }
        List<TColumn> columnList = columnService.selectAllColumn();
        request.setAttribute("columnList",columnList);
        return "article/article";
    }
    /*APP文章页内容*/
    @RequestMapping("/v/jsp")
    public String Index0(Long id,
                           HttpServletRequest request, Model model) {
        TArticle article = articleService.getArticleById(id);
        Long columnId = article.getColumnId();
        String columnName = columnService.findOne(columnId).getParentColumn().getName();
        request.setAttribute("columnName",columnName);
        request.setAttribute("columnId",columnId);
        request.setAttribute("article",article);
        return "article/jsp/articleInfo";
        //===========================判断是否在当前栏目服务期间===================================
        //获取当前的subject,就是当前的用户
       /* Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer user = (TCustomer) currenUser.getPrincipal();
        if(user==null){
            return "redirect:/main/index";
        }
        Long userId = user.getId();
		*//*获取客户所购买的服务*//*
        TCustomerColumn customerColumn= customerColumnService.
                selectAllByCustomer(new CustomerColumnPojo(userId,columnId));
        if(customerColumn==null) {
            return "common/notColumn";
        }
		*//*判断是否在有效时期内*//*
        Date startTime = customerColumn.getStartTime();
        Date endTime  = customerColumn.getEndTime();
        Long startTimeTime = startTime.getTime();
        Long endTimeTime = endTime.getTime();
        Long time = new Date().getTime();
        if(time < startTimeTime || time > endTimeTime){
            return "common/notTime";
        }*/
        //===========================判断是否在当前栏目服务期间===================================
    }

    @RequestMapping("/v/article")
    @ResponseBody
    public APIResult vIndex(Long id,
                           HttpServletRequest request, Model model) {
        TArticle article = articleService.getArticleById(id);
        Long columnId = article.getColumnId();
        Integer  top = article.getTop();
        String columnName = columnService.findOne(columnId).getParentColumn().getName();

        Map map= new HashMap<>();
        map.put("columnName",columnName);
        map.put("columnId",columnId);
        //===========================判断是否在当前栏目服务期间===================================
        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer user = (TCustomer) currenUser.getPrincipal();

        Long userId = user.getId();
		/*获取客户所购买的服务*/
        TCustomerColumn customerColumn= customerColumnService.
                selectAllByCustomer(new CustomerColumnPojo(userId,columnId));
        if(customerColumn==null) {
            map.put("page","noColumn");
            return APIResult.failure().setData(map);
        }
		/*判断是否在有效时期内*/
        Date startTime = customerColumn.getStartTime();
        Date endTime  = customerColumn.getEndTime();
        Long startTimeTime = startTime.getTime();
        Long endTimeTime = endTime.getTime();
        Long time = new Date().getTime();
        if(time < startTimeTime || time > endTimeTime){
            map.put("page","notTime");
            return APIResult.failure().setData(map);
        }
        //===========================判断是否在当前栏目服务期间===================================
        ArticleQuery topArticleQuery = new ArticleQuery(1,columnId);
       /* topArticleQuery.setTop(1);
        topArticleQuery.setColumnId(columnId);*/
        TArticle topArticle = articleService.getNextByQuery(topArticleQuery);

        ArticleQuery upArticleQuery = new ArticleQuery(top,columnId,startTime);
        ArticleQuery nextArticleQuery = new ArticleQuery(top,columnId,startTime);


        upArticleQuery.setUpId(id);
        nextArticleQuery.setNextId(id);

        TArticle upArticle= articleService.getNextByQuery(upArticleQuery);
        TArticle nextArticle = articleService.getNextByQuery(nextArticleQuery);

        if(upArticle==null && top==0 && topArticle!=null){
            upArticle = topArticle;
        }

        if(top==1){
            ArticleQuery topNextArticleQuery = new ArticleQuery(columnId,startTime);
            TArticle topNextArticle = articleService.getNextByQuery(topNextArticleQuery);
            nextArticle = topNextArticle;
        }
        /*修改文章浏览量*/
        map.put("upArticle",upArticle);
        map.put("nextArticle",nextArticle);
        map.put("article",article);
        Long readingQuantity = article.getReadingQuantity();
        article.setReadingQuantity(readingQuantity+1);
        article.setId(id);
        articleService.updateSelective(article);

        /*修改老师浏览量*/
        Long teacherId = article.getTeacherId();
        TEmployee tEmployee = employeeService.findOne(teacherId);
        tEmployee.setReadingQuantity(tEmployee.getReadingQuantity()+1);
        tEmployee.setId(tEmployee.getId());
        employeeService.updateEmployee(tEmployee);

        String nameRemark = article.getColumn().getNameRemark();
        List<TAdvertising> advertising = advertisingService.selectAdByName(nameRemark);
        TAdvertising tAdvertising = null ;
        if(advertising.size()>0){
            tAdvertising  = advertising.get(0);
        }
        map.put("advertising",tAdvertising);

        return APIResult.success().setData(map);
    }

    @RequestMapping("/v/query")
    @ResponseBody
    public APIResult toIndexList(String q,
                                 @RequestParam(required=true,defaultValue="1") Integer page,
                                 @RequestParam(required=true,defaultValue="1") Integer pageSize,
                                 HttpServletRequest request, Model model) {
        PageHelper.startPage(page, pageSize);
        ArticleQuery articleQuery = new ArticleQuery();
        if(!q.equals("股票、标题、作者")){
             articleQuery.setQ(q);
        }
        List<TArticle> articleList = articleService.getArticleByQuery(articleQuery);

        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(TArticle a :articleList){
            Date creationTime  = a.getCreationTime();
            String c = bf.format(creationTime);
            a.setCreateTimeStr(c);
        }
        request.getSession().setAttribute("q",q);
        Map map = new HashMap<>();
        map.put("articleList",articleList);
        return  APIResult.success().setData(map);
    }
    @RequestMapping("/thumbUp")
    @ResponseBody
    public APIResult upd(Long id,
                         HttpServletRequest request, Model model) {
        TArticle article = articleService.getArticleById(id);
        /*修改文章点赞量*/
        Long thumbUpQuantity = article.getThumbUpQuantity();
        article.setThumbUpQuantity(thumbUpQuantity+1);
        article.setId(id);
        articleService.updateSelective(article);

        /*修改老师点赞量*/
        Long teacherId = article.getTeacherId();
        TEmployee tEmployee = employeeService.findOne(teacherId);
        tEmployee.setThumbUpQuantity(tEmployee.getThumbUpQuantity()+1);
        tEmployee.setId(tEmployee.getId());
        employeeService.updateEmployee(tEmployee);

        return APIResult.success();
    }

    @RequestMapping("/queryArticle")
    public String queryArticle(Long id,String q,
                           HttpServletRequest request, Model model) {
        TArticle article = articleService.getArticleById(id);
        Long columnId = article.getColumnId();
        request.setAttribute("columnId",columnId);
        //===========================判断是否在当前栏目服务期间===================================
        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer user = (TCustomer) currenUser.getPrincipal();
        if(user==null){
            return "redirect:/main/index";
        }
        Long userId = user.getId();
		/*获取客户所购买的服务*/
        TCustomerColumn customerColumn= customerColumnService.
                selectAllByCustomer(new CustomerColumnPojo(userId,columnId));
        if(customerColumn==null) {
            return "common/notColumn";
        }
		/*判断是否在有效时期内*/
        Date startTime = customerColumn.getStartTime();
        Date endTime  = customerColumn.getEndTime();
        Long startTimeTime = startTime.getTime();
        Long endTimeTime = endTime.getTime();
        Long time = new Date().getTime();
        if(time < startTimeTime || time > endTimeTime){
            return "common/notTime";
        }
        //===========================判断是否在当前栏目服务期间===================================


        ArticleQuery upArticleQuery = new ArticleQuery();
        ArticleQuery nextArticleQuery = new ArticleQuery();

        upArticleQuery.setQ(q);
        nextArticleQuery.setQ(q);

        upArticleQuery.setUpId(id);
        nextArticleQuery.setNextId(id);

        TArticle upArticle= articleService.getNextByQuery(upArticleQuery);
        TArticle nextArticle = articleService.getNextByQuery(nextArticleQuery);

        request.setAttribute("upArticle",upArticle);
        request.setAttribute("nextArticle",nextArticle);

        /*修改文章浏览量*/
        request.setAttribute("article",article);
        Long readingQuantity = article.getReadingQuantity();
        article.setReadingQuantity(readingQuantity+1);
        article.setId(id);
        articleService.updateSelective(article);

        /*修改老师浏览量*/
        Long teacherId = article.getTeacherId();
        TEmployee tEmployee = employeeService.findOne(teacherId);
        tEmployee.setReadingQuantity(tEmployee.getReadingQuantity()+1);
        tEmployee.setId(tEmployee.getId());
        employeeService.updateEmployee(tEmployee);

        request.setAttribute("q",q);
        List<TColumn> columnList = columnService.selectAllColumn();

        request.setAttribute("columnList",columnList);
        return "article/article";
    }

    @RequestMapping("/query")
    public String query(ArticleQuery articleQuery,
                        @RequestParam(required=true,defaultValue="1") Integer page,
                        @RequestParam(required=true,defaultValue="1") Integer pageSize,
                           HttpServletRequest request, Model model) {
        List<TColumn> columnList = columnService.selectAllColumn();

        PageHelper.startPage(page, 6);
        List<TArticle> articleList = articleService.getArticleByQuery(articleQuery);
        String q = articleQuery.getQ();
        System.out.print(articleList.size());
        request.getSession().setAttribute("q",q);
        request.setAttribute("articleList",articleList);
        request.setAttribute("columnList",columnList);
        request.setAttribute("date",new Date());
        return "article/list_query_medium_column";
    }
}
