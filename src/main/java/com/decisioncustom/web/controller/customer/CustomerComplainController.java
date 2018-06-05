package com.decisioncustom.web.controller.customer;

import com.decisioncustom.domain.*;
import com.decisioncustom.pojo.CustomerCompanyPojo;
import com.decisioncustom.query.ComplainDateQuery;
import com.decisioncustom.query.CustomerComplainQuery;
import com.decisioncustom.service.*;
import com.decisioncustom.utils.AjaxResult;
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
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/complain")
public class CustomerComplainController {

    @Autowired
    private ICustomerComplainService customerComplainService;

    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerComplainTextService customerComplainTextService;

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/list")
    public String toIndex(@RequestParam(required=true,defaultValue="1") Integer page,CustomerComplainQuery complainQuery,
                          HttpServletRequest request, Model model) {
        PageHelper.startPage(page, 10);
        List<TCustomerComplain> customerComplainList = customerComplainService.getAllComplainByQuery(complainQuery);
        List<TSystemDictionaryItem> companyList = systemDictionaryItemService.listOne(5L);
        List<TSystemDictionaryItem> complainTypeList = systemDictionaryItemService.listOne(4L);
        List<TSystemDictionaryItem> complainReasonList = systemDictionaryItemService.listOne(6L);
        List<TSystemDictionaryItem> processingResultsList = systemDictionaryItemService.listOne(7L);
        List<TSystemDictionaryItem> complainSourceList = systemDictionaryItemService.listOne(8L);
        PageInfo<TCustomerComplain> p= new PageInfo<>(customerComplainList);
        request.setAttribute("page", p);
        request.setAttribute("command", complainQuery);
        request.setAttribute("companyList", companyList);
        request.setAttribute("complainTypeList", complainTypeList);
        request.setAttribute("complainReasonList", complainReasonList);
        request.setAttribute("complainSourceList", complainSourceList);
        request.setAttribute("processingResultsList", processingResultsList);
        request.setAttribute("APP_PATH", "/complain/list");
        request.setAttribute("customerComplainList",customerComplainList);
        return "customer/complain/list_customer_complain";
    }

    @RequestMapping("/day_count")
    public String complainCount(@RequestParam(required=true,defaultValue="1") Integer page,ComplainDateQuery complainDateQuery,
                          HttpServletRequest request, Model model) {
        PageHelper.startPage(page, 10);
        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
        String dayStr = request.getParameter("dayStr");
        String monthStr = request.getParameter("monthStr");
        String ct="";
        String mt="";
        /*默认查询当日*/
        if(dayStr!=null && !dayStr.equals("")){
            ct=dayStr;
        }else {
          Date date = new Date();
          ct = bf.format(date);
        }
        if(monthStr!=null && !monthStr.equals("")){
            mt=monthStr;
        }
        List<CustomerCompanyPojo> customerComplainList;
        if ( mt!=null && !mt.equals("")){
            customerComplainList = customerComplainService.selectCountByMonth(mt);
        }else{
            customerComplainList = customerComplainService.selectCountByDay(ct);
        }

        PageInfo<CustomerCompanyPojo> p= new PageInfo<>(customerComplainList);
        request.setAttribute("page", p);
        request.setAttribute("command", complainDateQuery);
        request.setAttribute("APP_PATH", "/complain/day_count");

        request.setAttribute("customerComplainList",customerComplainList);
        return "customer/complain/day_customer_complain";
    }

    /*回访记录编辑*/
    @RequestMapping("/edit")
    public String track_add(Long id,HttpServletRequest request, Model model) {
        boolean isNew = true;
        List<TSystemDictionaryItem> complainTypeList = systemDictionaryItemService.listOne(4L);
        List<TSystemDictionaryItem> complainReasonList = systemDictionaryItemService.listOne(6L);
        List<TSystemDictionaryItem> processingResultsList = systemDictionaryItemService.listOne(7L);
        List<TSystemDictionaryItem> complainSourceList = systemDictionaryItemService.listOne(8L);
        List<TCustomer> customerList = customerService.findAll();
        List<TEmployee> transferList = employeeService.findAll();
        if(id!=null){
            TCustomerComplain customerComplain = customerComplainService.findOne(id);
            Long complainReasonDetailId =customerComplain.getComplainReasonDetailId();
            TCustomerComplainText customerComplainText = customerComplainTextService.findOne(complainReasonDetailId);
            if(customerComplainText!=null && !customerComplainText.equals("")){
                String complainReasonDetail= customerComplainText.getComplainReasonDetail();
                customerComplain.setComplainReasonDetailStr(complainReasonDetail);
            }
            Date createTime = customerComplain.getCreateTime();
            Date handleTime = customerComplain.getHandleTime();
            DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");

            String createTimeStr = bf.format(createTime);
            String handleTimeStr = bf.format(handleTime);
            customerComplain.setCreateTimeStr(createTimeStr);
            customerComplain.setHandleTimeStr(handleTimeStr);
            model.addAttribute("customerList",customerList);
            model.addAttribute("transferList",transferList);
            model.addAttribute("customerComplain",customerComplain);
            model.addAttribute("complainTypeList",complainTypeList);
            model.addAttribute("complainSourceList",complainSourceList);
            model.addAttribute("complainReasonList",complainReasonList);
            model.addAttribute("processingResultsList",processingResultsList);
            return "customer/complain/edit_customer_complain";
        }
        TCustomerComplain newCustomerComplain = new TCustomerComplain();
        model.addAttribute("isNew",isNew);
        model.addAttribute("customerList",customerList);
        model.addAttribute("transferList",transferList);
        model.addAttribute("customerComplain",newCustomerComplain);
        model.addAttribute("complainTypeList",complainTypeList);
        model.addAttribute("complainSourceList",complainSourceList);
        model.addAttribute("complainReasonList",complainReasonList);
        model.addAttribute("processingResultsList",processingResultsList);
        return "customer/complain/edit_customer_complain";
    }

    /*客户删除*/
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
                        TCustomerComplain customerComplain= customerComplainService.findOne(Long.valueOf(id));
                        Long complainReasonDetailId= customerComplain.getComplainReasonDetailId();
                        TCustomerComplainText customerComplainText= customerComplainTextService.findOne(complainReasonDetailId);
                        if(customerComplainText!=null && !customerComplainText.equals("")){
                            customerComplainTextService.delete(customerComplainText.getId());
                        }
                        customerComplainService.delete(Long.valueOf(id));
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

    /*客户信息保存*/
    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult customer_save(TCustomerComplain customerComplain, HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        String createTimeStr= request.getParameter("createTimeStr");
        String handleTimeStr= request.getParameter("handleTimeStr");
        String customerStr  = customerComplain.getCustomerStr();
        String transferStr  = customerComplain.getTransferStr();
        String complainTypeStr = customerComplain.getComplainTypeStr();
        String complainReasonStr = customerComplain.getComplainReasonStr();
        String processingResultsStr = customerComplain.getProcessingResultsStr();
        String complainSourceStr= customerComplain.getComplainSourceStr();
        String complainReasonDetailStr= customerComplain.getComplainReasonDetailStr();
        String remarks = customerComplain.getRemarks();
        String trackingProcess= customerComplain.getTrackingProcess();

        TCustomerComplainText customerComplainText =  new TCustomerComplainText();
        customerComplainText.setComplainReasonDetail(complainReasonDetailStr);
        customerComplainTextService.createSelective(customerComplainText);
        Long customerComplainTextId = customerComplainText.getId();

        DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            customerComplain.setRemarks(remarks);
            customerComplain.setTrackingProcess(trackingProcess);
            customerComplain.setCreateTime(bf.parse(createTimeStr));
            customerComplain.setHandleTime(bf.parse(handleTimeStr));
            customerComplain.setCustomerId(Long.valueOf(customerStr));
            customerComplain.setTransferId(Long.valueOf(transferStr));
            customerComplain.setComplainTypeId(Long.valueOf(complainTypeStr));
            customerComplain.setComplainReasonId(Long.valueOf(complainReasonStr));
            customerComplain.setProcessingResultsId(Long.valueOf(processingResultsStr));
            customerComplain.setComplainSourceId(Long.valueOf(complainSourceStr));
            customerComplain.setComplainReasonDetailId(customerComplainTextId);
            if(id!=null && !id.equals("")){
                customerComplainService.updateSelective(customerComplain);
            }else {
                customerComplainService.createSelective(customerComplain);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new AjaxResult();
    }
}
