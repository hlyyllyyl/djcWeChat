package com.decisioncustom.web.controller.video;

import com.decisioncustom.domain.*;
import com.decisioncustom.domain.vo.EmployeeVO;
import com.decisioncustom.domain.vo.VideoInfoVO;
import com.decisioncustom.pojo.CustomerColumnPojo;
import com.decisioncustom.query.ArticleQuery;
import com.decisioncustom.service.*;
import com.decisioncustom.utils.APIResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private IColumnService columnService;

    @Autowired
    private IVideoService videoService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IAdvertisingService advertisingService;

    @Autowired
    private ICustomerColumnService customerColumnService;

    @Autowired
    Mapper mapper;

    @RequestMapping("/video")
    public String toIndex0(Long id,
                           HttpServletRequest request, Model model) {
        TVideo video = videoService.findOne(id);
        Long columnId = video.getColumnId();
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

        /*修改视频播放量*/
        request.setAttribute("video",video);
        Long readingQuantity = video.getPlayQuantity();
        video.setPlayQuantity(readingQuantity+1);
        video.setId(id);
        videoService.updateSelective(video);

        /*修改老师浏览量*/
        Long teacherId = video.getTeacherId();
        TEmployee tEmployee = employeeService.findOne(teacherId);
        tEmployee.setReadingQuantity(tEmployee.getReadingQuantity()+1);
        tEmployee.setId(tEmployee.getId());
        employeeService.updateEmployee(tEmployee);

        String tag = video.getTag();
        if(tag!=null && !tag.equals("")){

            String[] tags = tag.split(",");
            ArticleQuery articleQuery = new ArticleQuery();
            articleQuery.setTags(tags);
            List<TVideo> videoList = videoService.getVideoByQuery(articleQuery);
            request.setAttribute("videoList",videoList);
        }


        String nameRemark = video.getColumn().getNameRemark();
        List<TAdvertising> advertising = advertisingService.selectAdByName(nameRemark);
        List<TColumn> columnList = columnService.selectAllColumn();
        request.setAttribute("columnList",columnList);
        if(advertising.size()>0){
         request.setAttribute("advertising",advertising.get(0));
        }
        return "video/video";
    }

    @RequestMapping("/v/video")
    @ResponseBody
    public APIResult vtoIndex0(Long id,
                           HttpServletRequest request, Model model) {
        TVideo video = videoService.findOne(id);
        Long columnId = video.getColumnId();
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
        /*修改视频播放量*/
        Long readingQuantity = video.getPlayQuantity();
        video.setPlayQuantity(readingQuantity+1);
        video.setId(id);
        videoService.updateSelective(video);

        /*修改老师浏览量*/
        Long teacherId = video.getTeacherId();
        TEmployee tEmployee = employeeService.findOne(teacherId);
        tEmployee.setReadingQuantity(tEmployee.getReadingQuantity()+1);
        tEmployee.setId(tEmployee.getId());
        employeeService.updateEmployee(tEmployee);

        List<VideoInfoVO> videoInfoVOList = new ArrayList<>();
        String tag = video.getTag();
        if(tag!=null && !tag.equals("")){

            String[] tags = tag.split(",");
            ArticleQuery articleQuery = new ArticleQuery();
            articleQuery.setTags(tags);
            List<TVideo> videoList = videoService.getVideoByQuery(articleQuery);
            for (TVideo tVideo : videoList){
                VideoInfoVO videoInfoVO;
                videoInfoVO = mapper.map(tVideo, VideoInfoVO.class);
                videoInfoVOList.add(videoInfoVO);
            }
            map.put("videoList",videoInfoVOList);
        }

        VideoInfoVO videoInfoVO= mapper.map(video, VideoInfoVO.class);
        EmployeeVO employeeVO = mapper.map(video.getEmployee(), EmployeeVO.class);
        videoInfoVO.setEmployeeVO(employeeVO);
        map.put("video",videoInfoVO);

        return APIResult.success().setData(map);
    }
}
