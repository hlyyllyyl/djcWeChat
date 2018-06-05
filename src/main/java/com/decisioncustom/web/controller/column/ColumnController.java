package com.decisioncustom.web.controller.column;

import com.decisioncustom.domain.*;
import com.decisioncustom.domain.vo.ArticleVO;
import com.decisioncustom.domain.vo.VideoVO;
import com.decisioncustom.pojo.CustomerColumnPojo;
import com.decisioncustom.pojo.CustomerPojo;
import com.decisioncustom.query.ArticleQuery;
import com.decisioncustom.query.JiePanQuery;
import com.decisioncustom.service.*;
import com.decisioncustom.utils.APIResult;
import com.decisioncustom.utils.page.PageHelper;
import com.decisioncustom.utils.page.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/column")
public class ColumnController {
    @Autowired
    private IAdvertisingService advertisingService;

    @Autowired
    private IColumnService columnService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ICustomerColumnService customerColumnService;

    @Autowired
    private ILeaveWordsService leaveWordsService;

    @Autowired
    private IVideoService videoService;

    @Autowired
    Mapper mapper;


    @RequestMapping("/djc")
    @ResponseBody
    public APIResult columns(@RequestParam(required = true, defaultValue = "1") Integer page, JiePanQuery jiePanQuery,
                             HttpServletRequest request, Model model) {
        List<TColumn> columnList = columnService.selectAllColumn();
        System.out.println(columnList);
        return APIResult.success().setData(columnList);
    }

    /*获取父栏目包含列表内容*/
    @RequestMapping(value = "/v/main/{columnName}")
    @ResponseBody
    public APIResult vColumn(@RequestParam(required = true, defaultValue = "1") Integer page,
                         @PathVariable("columnName") String columnName,
                         HttpServletRequest request, Model model) {


        List<TAdvertising> advertisingList = advertisingService.selectAdByName(columnName);

        Map map = new HashMap<>();


        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer user = (TCustomer) currenUser.getPrincipal();


        if (columnName.equals("我的")) {

            Long id = user.getId();
            List<TLeaveWords> leaveWordsList = leaveWordsService.selectByCustomerId(id);
            Long num = 0L;
            for (TLeaveWords l : leaveWordsList) {
                Long customerState = l.getState();
                if (customerState == 4) {
                    num++;
                }
            }
            TAdvertising advertising = advertisingService.findOne(37L);
            TCustomer tCustomer = customerService.findOne(id);
            List<TColumn> columns = tCustomer.getColumns();
            CustomerPojo customerPojo = new CustomerPojo();
            customerPojo.setId(id);

            if (columns != null && columns.size() != 0) {
                customerPojo.setState(0L);
            }
            TCustomer customer = customerService.getCustomerById(customerPojo);

            map.put("num", num);
            map.put("customer", customer);
            map.put("advertising", advertising);
            return  APIResult.success().setData(map);
        }
        if (columnName.equals("")) {
            return  APIResult.success().setData(map);
        }
        Long    columnId = columnService.selectTopColumnByName(columnName).getId();
        Long    parentId = columnService.selectTopColumnByName(columnName).getParentId();
        List<TColumn> columnList = columnService.selectChildrenColumn(parentId);
        String templateName = columnService.selectTopColumnByName(columnName).getTemplateName();

        map.put("columnId", columnId);
        map.put("columnName", columnName);
        map.put("childrenColumn", columnList);
        map.put("templateName", templateName);
        map.put("advertisingList", advertisingList);
        return  APIResult.success().setData(map);
    }


    @RequestMapping(value = "/main/{columnName}")
    public String column(@RequestParam(required = true, defaultValue = "1") Integer page,
                         @PathVariable("columnName") String columnName,
                         HttpServletRequest request, Model model) {
        List<TColumn> columnList = columnService.selectAllColumn();

        List<TAdvertising> advertisingList = advertisingService.selectAdByName(columnName);

        request.setAttribute("columnName", columnName);
        request.setAttribute("columnList", columnList);
        request.setAttribute("advertisingList", advertisingList);

        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer user = (TCustomer) currenUser.getPrincipal();
        if (user == null) {
            return "redirect:/main/index";
        }

        if (columnName.equals("我的")) {

            Long id = user.getId();
            List<TLeaveWords> leaveWordsList = leaveWordsService.selectByCustomerId(id);
            Long num = 0L;
            for (TLeaveWords l : leaveWordsList) {
                Long customerState = l.getState();
                if (customerState == 4) {
                    num++;
                }
            }
            TAdvertising advertising = advertisingService.findOne(37L);
            TCustomer tCustomer = customerService.findOne(id);
            List<TColumn> columns = tCustomer.getColumns();
            CustomerPojo customerPojo = new CustomerPojo();
            customerPojo.setId(id);

            if (columns != null && columns.size() != 0) {
                customerPojo.setState(0L);
            }
            TCustomer customer = customerService.getCustomerById(customerPojo);

            request.setAttribute("num", num);
            request.setAttribute("customer", customer);
            request.setAttribute("advertising", advertising);

            return "column/personal";
        }
        if (columnName.equals("")) {

            return "column/generalize";
        }

        Long    columnId = columnService.selectTopColumnByName(columnName).getId();
        String templateName = columnService.selectTopColumnByName(columnName).getTemplateName();
        request.setAttribute("columnId", columnId);
        request.setAttribute("templateName", templateName);
        return "column/main-column";
    }

    @RequestMapping(value = "/main")
    public String c(HttpServletRequest request, Model model) {
        List<TColumn> columnList = columnService.selectAllColumn();
        request.setAttribute("columnList", columnList);
        return "column/generalize";
    }

    @RequestMapping(value = "/suggest")
    public String suggest(@RequestParam(required = true, defaultValue = "1") Integer page,
                          HttpServletRequest request, Model model) {
        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer user = (TCustomer) currenUser.getPrincipal();
        List<TLeaveWords> leaveWordsList = leaveWordsService.selectByCustomerId(user.getId());
        for (TLeaveWords l : leaveWordsList) {
            Long customerState = l.getState();
            if (customerState == 4) {
                l.setState(3L);
                leaveWordsService.updateSelective(l);
            }
        }
        PageInfo<TLeaveWords> p = new PageInfo<>(leaveWordsList);
        request.setAttribute("page", p);
        request.setAttribute("customerId", user.getId());

        model.addAttribute("leaveWords", new TLeaveWords());
        request.setAttribute("leaveWordsList", leaveWordsList);
        return "column/suggest";
    }


    @RequestMapping(value = "/article/{columnId}")
    public String toIndexa(@RequestParam(required = true, defaultValue = "1") Integer page,
                           @RequestParam(required = true, defaultValue = "6") Integer pageSize,
                           @PathVariable("columnId") Long columnId, HttpServletRequest request, Model model) {

        String columnName = columnService.findOne(columnId).getParentColumn().getName();
        String currentName = columnService.findOne(columnId).getName();

        request.setAttribute("currentName", currentName);
        request.setAttribute("columnName", columnName);

        //===========================判断是否在当前栏目服务期间===================================
        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer user = (TCustomer) currenUser.getPrincipal();
        if (user == null) {
            return "redirect:/main/index";
        }
        Long userId = user.getId();
        /*获取客户所购买的服务*/
        TCustomerColumn customerColumn = customerColumnService.
                selectAllByCustomer(new CustomerColumnPojo(userId, columnId));
        if (customerColumn == null) {
            return "common/notColumn";
        }
        /*判断是否在有效时期内*/
        Date startTime = customerColumn.getStartTime();
        Date endTime = customerColumn.getEndTime();
        Long startTimeTime = startTime.getTime();
        Long endTimeTime = endTime.getTime();
        Long time = new Date().getTime();
        if (time < startTimeTime || time > endTimeTime) {
            return "common/notTime";
        }
        //===========================判断是否在当前栏目服务期间===================================


        List<TColumn> columnList = columnService.selectAllColumn();
        request.setAttribute("columnId", columnId);
        request.setAttribute("columnList", columnList);
        TColumn column = columnService.findOne(columnId);
        String templateName = column.getTemplateName();

        if (templateName.equals("text")) {
            request.setAttribute("date",new Date());
            return "article/list_text_article";
        }
        if (templateName.equals("smallImg")) {
            return "article/list_small_article";
        }
        if (templateName.equals("bigImg")) {
            return "article/list_big_article";
        }
        if (templateName.equals("mediumImg")) {
            return "article/list_medium_article";
        }
        if (templateName.equals("bigVideo")) {
            return "video/list_big_video";
        }
        if (templateName.equals("smallVideo")) {
            return "video/list_small_video";
        }
        return "article/list_medium_article";
    }

    /*获取子栏目文章列表*/
    @RequestMapping(value = "/v/article/{columnId}")
    @ResponseBody
    public APIResult toIndexList(@RequestParam(required = true, defaultValue = "1") Integer page,
                                 @RequestParam(required = true, defaultValue = "1") Integer pageSize,
                                 @PathVariable("columnId") Long columnId, HttpServletRequest request, Model model) {

        Map map = new HashMap<>();
        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer user = (TCustomer) currenUser.getPrincipal();
		/*获取客户所购买的服务*/
        TCustomerColumn customerColumn = customerColumnService.
                selectAllByCustomer(new CustomerColumnPojo(user.getId(), columnId));

        ArticleQuery articleQuery = new ArticleQuery();
        articleQuery.setColumnId(columnId);
        /*if (customerColumn != null) {
            articleQuery.setCreationTime(customerColumn.getStartTime());
        }*/

        /*如果为文章模板  当天日期不显示*/
        TColumn column = columnService.findOne(columnId);
        if(column.getTemplateName().equals("smallImg")){
            articleQuery.setParentId(0L);
        }


        PageHelper.startPage(page, pageSize);
		/*获取查询数据*/
        List<TArticle> articleList = articleService.getArticleByQuery(articleQuery);


            DateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date today = new Date();
            String todayStr = dateFormat.format(today);



            List<ArticleVO> articleVOList = new ArrayList<>();

            /*将查询数据日期格式化*/
            for (TArticle a : articleList) {
                String c ="";
                ArticleVO articleVO;
                Date creationTime = a.getCreationTime();
                String creationTimeStr = dateFormat.format(creationTime);

                List<TArticle> children = a.getChildren();
                for (TArticle child : children){
                    Date childCreationTime = child.getCreationTime();
                    if(childCreationTime!=null){
                        String childCreationTimeStr = dateFormat.format(childCreationTime);
                        if(todayStr.equals(childCreationTimeStr) && column.getTemplateName().equals("text")){
                            c = timeFormat.format(childCreationTime);
                        }else {
                            c = bf.format(childCreationTime);
                        }
                    }
                    child.setCreateTimeStr(c);
                }

                if(todayStr.equals(creationTimeStr) && column.getTemplateName().equals("text")){
                    c = timeFormat.format(creationTime);
                }else {
                     c = bf.format(creationTime);
                }
                a.setCreateTimeStr(c);
                articleVO = mapper.map(a, ArticleVO.class);
                articleVOList.add(articleVO);
            }

        /*PageInfo<TArticle> p = new PageInfo<>(articleList);*/

       /* request.getSession().setAttribute("c", columnId);
        request.getSession().setAttribute("s", pageSize);
        request.getSession().setAttribute("e", page);*/


       /* map.put("page",p);
        map.put("columnList",columnList);*/
        map.put("articleList",articleVOList);
        map.put("templateName",column.getTemplateName());

        return  APIResult.success().setData(map);
    }

    /*获取子栏目视频列表*/
    @RequestMapping(value = "/v/video/{columnId}")
    @ResponseBody
    public APIResult videoData(@RequestParam(required = true, defaultValue = "1") Integer page,
                               @RequestParam(required = true, defaultValue = "1") Integer pageSize,
                               @PathVariable("columnId") Long columnId, HttpServletRequest request, Model model) {

        TColumn column = columnService.findOne(columnId);

        //获取当前的subject,就是当前的用户
        Subject currenUser = SecurityUtils.getSubject();
        //获取当前用户的信息
        TCustomer user = (TCustomer) currenUser.getPrincipal();
		/*获取客户所购买的服务*/
        TCustomerColumn customerColumn = customerColumnService.
                selectAllByCustomer(new CustomerColumnPojo(user.getId(), columnId));
        if (customerColumn == null) {
            return null;
        }
        ArticleQuery articleQuery = new ArticleQuery();
        articleQuery.setColumnId(columnId);
        articleQuery.setCreationTime(customerColumn.getStartTime());


        PageHelper.startPage(page, pageSize);

		/*获取查询数据*/
        List<TVideo> videoList = videoService.getVideoByQuery(articleQuery);

        List<VideoVO> videoVOList = new ArrayList<>();



		/*将查询数据日期格式化*/
        for (TVideo a : videoList) {
            VideoVO videoVO;
            videoVO = mapper.map(a, VideoVO.class);
            videoVOList.add(videoVO);
        }

        Map map = new HashMap<>();
        map.put("videoList",videoVOList);
        map.put("templateName",column.getTemplateName());
        return  APIResult.success().setData(map);
    }
}
