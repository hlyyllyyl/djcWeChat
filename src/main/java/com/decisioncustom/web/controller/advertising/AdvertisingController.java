package com.decisioncustom.web.controller.advertising;

import com.decisioncustom.domain.TAdvertising;
import com.decisioncustom.domain.TColumn;
import com.decisioncustom.service.IAdvertisingService;
import com.decisioncustom.service.IColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/advertising")
public class AdvertisingController {


    @Autowired
    private IColumnService columnService;


    @Autowired
    private IAdvertisingService advertisingService;


    @RequestMapping("/article{id}")
    public String toIndex0(@PathVariable("id") Long id,
                           HttpServletRequest request, Model model) {
        TAdvertising article = advertisingService.findOne(id);

        List<TColumn> columnList = columnService.selectAllColumn();
        request.setAttribute("article",article);
        request.setAttribute("columnList",columnList);
        return "advertising/ad_article";
    }

}
