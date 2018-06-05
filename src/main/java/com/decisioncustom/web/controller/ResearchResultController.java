package com.decisioncustom.web.controller;

import com.decisioncustom.domain.TAllText;
import com.decisioncustom.query.TextQuery;
import com.decisioncustom.service.IAllTextService;
import com.decisioncustom.utils.page.PageHelper;
import com.decisioncustom.utils.page.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/researchResult")
public class ResearchResultController {

    @Autowired
    private IAllTextService allTextService;



    @RequestMapping("/list")
    public String toIndex(@RequestParam(required=true,defaultValue="1") Integer page, TextQuery textQuery,
                          HttpServletRequest request, Model model) {
        PageHelper.startPage(page, 5);
        textQuery.setTextTypeId(2L);
        List<TAllText> allTextText = allTextService.getAllTextText(textQuery);
        System.out.print(allTextText);
        PageInfo<TAllText> p= new PageInfo<>(allTextText);
        request.setAttribute("page", p);
        request.setAttribute("command", textQuery);
        request.setAttribute("researchResultList",allTextText);
        return "researchResult/list_research_result";
    }

}
