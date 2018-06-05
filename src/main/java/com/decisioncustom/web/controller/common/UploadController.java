package com.decisioncustom.web.controller.common;

import com.decisioncustom.utils.SaveFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@Controller
public class UploadController {

	/*图片上传*/
	@RequestMapping(value = "/text/img/upload", method = RequestMethod.POST)
	@ResponseBody
	public String uploadImgFile(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {
		try {
			// 获取图片的文件名
			String productFigurepath =request.getSession().getServletContext().getRealPath("/upload/image/image");
			System.out.println(productFigurepath);
			String productFigureFileUUID = UUID.randomUUID().toString();
               /* String productFigureRealPath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();*/
			String productFigurePath = "";
			productFigurePath = "/upload/image/image" + "/" + productFigureFileUUID + file.getOriginalFilename();
			SaveFile.saveFile(productFigurepath, productFigureFileUUID, file);
			/*request.setAttribute("titleImg",productFigurePath);
			model.addAttribute("img",productFigurePath);*/
			return productFigurePath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*图片上传*/
	@RequestMapping(value = "/text/video/upload", method = RequestMethod.POST)
	@ResponseBody
	public String uploadVideoFile(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {
		try {
			// 获取图片的文件名
			String productFigurepath =request.getSession().getServletContext().getRealPath("/upload/video/video");
			System.out.println(productFigurepath);
			String productFigureFileUUID = UUID.randomUUID().toString();
               /* String productFigureRealPath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();*/
			String productFigurePath = "";
			productFigurePath = "/upload/video/video/" + "/" + productFigureFileUUID + file.getOriginalFilename();
			SaveFile.saveFile(productFigurepath, productFigureFileUUID, file);
			/*request.setAttribute("titleImg",productFigurePath);
			model.addAttribute("img",productFigurePath);*/
			return productFigurePath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}