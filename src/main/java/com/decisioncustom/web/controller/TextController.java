package com.decisioncustom.web.controller;

import com.decisioncustom.domain.MTextType;
import com.decisioncustom.domain.TAllText;
import com.decisioncustom.domain.TTextIntro;
import com.decisioncustom.pojo.Text;
import com.decisioncustom.service.IAllTextService;
import com.decisioncustom.service.ITextIntroService;
import com.decisioncustom.service.MTextTypeService;
import com.decisioncustom.utils.APIResult;
import com.decisioncustom.utils.AjaxResult;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/text")
public class TextController {

    @Autowired
    private MTextTypeService textTypeService;

    @Autowired
    private ITextIntroService iTextIntroService;

    @Autowired
    private IAllTextService allTextService;

    @RequestMapping("/edit")
    public String toIndex(Long id,HttpServletRequest request, Model model) {
        if (id!=null){
            TAllText researchResult= allTextService.findOneById(id);
            TTextIntro tTextIntro = iTextIntroService.findOne(researchResult.getTextId());
            String img = researchResult.getImg();
            String textIntroDetails= tTextIntro.getTextIntroDetails();
            Long textTypeId= tTextIntro.getTextTypeId();
            Text text = new Text();
            List<MTextType> textType= textTypeService.findAll();
            MTextType mTextType= new MTextType();

            if (textTypeId==2){

                int originalInt = researchResult.getOriginal();
                String resultTitle= researchResult.getTitle();
                mTextType.setId(2L);
                mTextType.setTextType("最新研究成果");
                text.setOriginal(originalInt+"");
                text.setTextType(mTextType);
                text.setTitle(resultTitle);
                text.setTitleImg(img);
                text.setEditorValue(textIntroDetails);
                text.setId(id);
                model.addAttribute("text",text);
                model.addAttribute("textType",textType);
                return "text/text_edit";
            }else if (textTypeId==3){
                int topInt = researchResult.getTop();
                String intelligenceTitle= researchResult.getTitle();
                mTextType.setId(3L);
                mTextType.setTextType("机构情报");
                text.setTop(topInt+"");
                text.setTextType(mTextType);
                text.setTitleImg(img);
                text.setTitle(intelligenceTitle);
                text.setEditorValue(textIntroDetails);
                text.setId(id);
                model.addAttribute("text",text);
                model.addAttribute("textType",textType);
                return "text/text_edit";
            }
        }
        Text newText = new Text();
        List<MTextType> textType= textTypeService.findAll();
        model.addAttribute("text",newText);
        model.addAttribute("textType",textType);
        return "text/text_edit";
    }

    @RequestMapping("/edit_modal")
    public String edit_modal(Long id,HttpServletRequest request, Model model) {
        if (id!=null){
            TTextIntro tTextIntro = iTextIntroService.findOne(id);
            String textIntroDetails= tTextIntro.getTextIntroDetails();
            Long textTypeId= tTextIntro.getTextTypeId();
            Text text = new Text();
            List<MTextType> textType= textTypeService.findAll();
            MTextType mTextType= new MTextType();

            if (textTypeId==2){
                TAllText researchResult= allTextService.getAllTextById(id);
                int originalInt = researchResult.getOriginal();
                String resultTitle= researchResult.getTitle();
                mTextType.setId(2L);
                mTextType.setTextType("最新研究成果");
                text.setOriginal(originalInt+"");
                text.setTextType(mTextType);
                text.setTitle(resultTitle);
                text.setEditorValue(textIntroDetails);
                text.setId(id);
                model.addAttribute("text",text);
                model.addAttribute("textType",textType);
                return "text/text_edit_modal";
            }else if (textTypeId==3){
                TAllText tIntelligenceAgencies= allTextService.getAllTextById(id);
                String intelligenceTitle= tIntelligenceAgencies.getTitle();
                mTextType.setId(3L);
                mTextType.setTextType("机构情报");
                text.setTextType(mTextType);
                text.setTitle(intelligenceTitle);
                text.setEditorValue(textIntroDetails);
                text.setId(id);
                model.addAttribute("text",text);
                model.addAttribute("textType",textType);
                return "text/text_edit_modal";
            }
        }
        boolean isNew = true;
        Text newText = new Text();
        List<MTextType> textType= textTypeService.findAll();
        model.addAttribute("text",newText);
        model.addAttribute("textType",textType);
        return "text/text_edit_modal";
    }



    @RequestMapping("/save")
    @ResponseBody
    public APIResult saveText(HttpServletRequest request, Model model) {
        String title  = request.getParameter("title");
        String textType  = request.getParameter("textType");
        String editorValue  = request.getParameter("editorValue");
        String original = request.getParameter("original");
        String titleImg  = request.getParameter("titleImg");
        String top = request.getParameter("top");
        String id = request.getParameter("id");
        System.out.print(id);
        System.out.print(title);
        System.out.print("-textType-"+textType+"-textType-");
        System.out.print(editorValue);
        Long textIntroId;

                if (id!=null && !id.equals("")){
                    TAllText researchResult= allTextService.findOne(Long.valueOf(id));
                    TTextIntro tTextIntro = iTextIntroService.findOne(researchResult.getTextId());
                    tTextIntro.setTextTypeId(Long.valueOf(textType));
                    tTextIntro.setTextIntroDetails(editorValue);
                    iTextIntroService.updateSelective(tTextIntro);
                    textIntroId = tTextIntro.getId();
                    if (researchResult!=null){
                        /*修改后将原图删除*/
                        String img = researchResult.getImg();
                        // 获取图片的文件名
                        String oldPath =request.getSession().getServletContext().getRealPath("/");
                        File file = new File(oldPath+img);
                        if(file.exists()){
                            file.delete();
                        }
                        researchResult.setTitle(title);
                        researchResult.setTextId(textIntroId);
                        researchResult.setTeacherId(1L);
                        researchResult.setUpdateTime(new Date());
                        researchResult.setTextTypeId(Long.valueOf(textType));
                        if(original!=null && !original.equals("")){
                            int originalInt= Integer.valueOf(original);
                            researchResult.setOriginal(originalInt);
                        }
                        if(top!=null && !top.equals("")){
                            int topInt= Integer.valueOf(top);
                            researchResult.setTop(topInt);
                        }
                        researchResult.setImg(titleImg);
                        allTextService.updateSelective(researchResult);
                    }else {
                        TAllText newResearchResult = new TAllText();
                        newResearchResult.setTitle(title);
                        newResearchResult.setTextId(textIntroId);
                        newResearchResult.setTeacherId(1L);
                        newResearchResult.setCreationTime(new Date());
                        newResearchResult.setUpdateTime(new Date());
                        newResearchResult.setTextTypeId(Long.valueOf(textType));
                        if(original!=null && !original.equals("")){
                            int originalInt= Integer.valueOf(original);
                             newResearchResult.setOriginal(originalInt);
                        }
                        if(top!=null && !top.equals("")){
                            int topInt= Integer.valueOf(top);
                            newResearchResult.setTop(topInt);
                        }
                        newResearchResult.setImg(titleImg);
                        allTextService.createSelective(newResearchResult);
                    }
                }else{
                    TTextIntro tTextIntro = new TTextIntro();
                    tTextIntro.setTextTypeId(Long.valueOf(textType));
                    tTextIntro.setTextIntroDetails(editorValue);
                    iTextIntroService.createSelective(tTextIntro);
                    textIntroId = tTextIntro.getId();

                    TAllText newResearchResult = new TAllText();
                    newResearchResult.setTitle(title);
                    newResearchResult.setTextId(textIntroId);
                    newResearchResult.setCreationTime(new Date());
                    newResearchResult.setUpdateTime(new Date());
                    newResearchResult.setTeacherId(1L);
                    newResearchResult.setTextTypeId(Long.valueOf(textType));
                    newResearchResult.setImg(titleImg);
                    if(original!=null && !original.equals("")){
                        int originalInt= Integer.valueOf(original);
                        newResearchResult.setOriginal(originalInt);
                    }
                    if(top!=null && !top.equals("")){
                        int topInt= Integer.valueOf(top);
                        newResearchResult.setTop(topInt);
                    }
                    allTextService.createSelective(newResearchResult);
                }
        Text newText = new Text();
        List<MTextType> textTypes= textTypeService.findAll();
        model.addAttribute("text",newText);
        model.addAttribute("textTypes",textTypes);
        return new APIResult().setStatus(0).setMessage(textType);
    }

    /*删除文章*/
    @RequestMapping("/text_del")
    @ResponseBody
    public AjaxResult delText(Long id, HttpServletRequest request, Model model) {
        try {
            allTextService.deleteByTextId(id);
            iTextIntroService.delete(id);
            return  new AjaxResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("操作失败："+e.getMessage());
        }
    }

    /*批量置顶文章*/
    @RequestMapping("/text_select_top")
    @ResponseBody
    public AjaxResult selectTopBooks(HttpServletRequest request, Model model) {
        AjaxResult ajaxResult = new AjaxResult();
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
                        TAllText allText= allTextService.findOne(Long.valueOf(id));
                        int top= allText.getTop();
                        if (top==0){
                            allText.setTop(1);
                            ajaxResult.setMessage("置顶成功");
                        }else if(top==1){
                            allText.setTop(0);
                            ajaxResult.setMessage("取消置顶成功");
                        }
                        allTextService.updateSelective(allText);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return new AjaxResult("操作失败："+e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /*批量删除文章*/
    @RequestMapping("/text_select_del")
    @ResponseBody
    public AjaxResult selectdelbooks(HttpServletRequest request, Model model) {
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
                        TAllText allText= allTextService.findOne(Long.valueOf(id));
                        String img = allText.getImg();
                        // 获取图片的文件名
                        String productFigurepath =request.getSession().getServletContext().getRealPath("/");

                        Long textId= allText.getTextId();
                        /*删除原图*/
                        File file = new File(productFigurepath+img);
                        if(file.exists()){
                            file.delete();
                        }
                        allTextService.delete(Long.valueOf(id));
                        iTextIntroService.delete(textId);
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

    /**
     * 百度富文本编辑器：图片上传
     * @param request
     * @param response
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String imgUploadByUeditor(HttpServletRequest request,
                                     @RequestParam("titleImg") MultipartFile titleImg,
                                     HttpServletResponse response) throws IOException {
        String title  = request.getParameter("title");
        String textType  = request.getParameter("textType");
        String editorValue  = request.getParameter("editorValue");
//        try {
//              /*保存商品图片*/
//                if (titleImg != null && !titleImg.isEmpty()) {
//                    // 获取图片的文件名
//                    String productFigurepath = request.getServletContext().getRealPath("/upload/image");
//                    String productFigureFileUUID = UUID.randomUUID().toString();
//                    String productFigureRealPath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
//                    String productFigurePath = "";
//                    productFigurePath = productFigureRealPath + "/upload/image" + "/" + productFigureFileUUID + titleImg.getOriginalFilename();
//                    SaveFile.saveFile(productFigurepath, productFigureFileUUID, titleImg);
//                }
//                    System.out.print(title);
//                    System.out.print(textType);
//                    System.out.print(editorValue);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
        return editorValue ;
    }
}
