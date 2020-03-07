package com.boke.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.boke.bean.BokeInfo;
import com.boke.bean.UserInfo;
import com.boke.service.IBokeInfoService;

@RestController
@RequestMapping("/boke")
@ResponseBody
public class BokeInfoController {
	
	@Autowired
	private IBokeInfoService service;
	
	//保存路径
	private String savePath = "pics";
	
	
	@RequestMapping("/upload")
	public Map<String, Object> upload(@RequestParam("upload")MultipartFile pic, HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		if (!pic.isEmpty()){
			try {
				String path = request.getServletContext().getRealPath("");
				String temp = request.getServletContext().getInitParameter("uploadPath");
				if (temp != null){
					savePath = temp;
				}
				
				String tempPath = "";
				
				tempPath += savePath + "/" + new Date().getTime() + "_" + pic.getOriginalFilename();  //为了避免重名，在上传文件名的前面加上一个时间戳
				File dest = new File(new File(path).getParentFile(),tempPath);
				pic.transferTo(dest);  //将图片保存到服务器
				
				map.put("fileName", pic.getOriginalFilename());
				map.put("uploaded", 1);
				map.put("url", "../" + tempPath);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return map;
	}
	
	@RequestMapping("/addboke")
	public int add(@RequestParam("pic")MultipartFile[] pics, HttpServletRequest request, HttpSession session, BokeInfo bf){
		if (pics != null && pics.length > 0 && !pics[0].isEmpty()){
			try {
				String basePath = request.getServletContext().getRealPath("");
				String temp = request.getServletContext().getInitParameter("uploadPath");
				if (temp != null){
					savePath = temp;
				}
				String picStr = "";
				File dest = null;
				String path = null;
				for (MultipartFile f1 : pics){
					path = savePath + "/" + new Date().getTime() + "_" + f1.getOriginalFilename();
					dest = new File(new File(basePath).getParentFile(),path);
					f1.transferTo(dest);  //将图片保存到服务器
					picStr += path + ";";
				}
				if (!"".equals(picStr)){
					picStr = picStr.substring(0, picStr.lastIndexOf(";"));
				}
				bf.setPics(picStr);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return service.add(bf);
		
	}
	
	@RequestMapping("/findAll")
	public List<BokeInfo> findAll() {
		return service.findAll();
	}
	
	@RequestMapping("/findByType")
	public List<BokeInfo> findByType (Integer userid, int page, int rows, HttpSession session){
		UserInfo userinfo = (UserInfo) session.getAttribute("loginUser");
		if (userinfo == null){
			return null;
		}else {
			return service.findByType(userinfo.getUserid(), page, rows);
		}
	}
	
	@RequestMapping("/findByFirst")
	public Map<String, Object> findByFirst(HttpSession session, int page, int rows){
		UserInfo userinfo = (UserInfo) session.getAttribute("loginUser");
		if (userinfo == null){
			return null;
		}else {
			return service.findByFirst(userinfo.getUserid(), page, rows);
		}
	}

	@RequestMapping("/finds")
	public Map<String, Object> finds(Integer  bokeid){
		return service.finds(bokeid);
	}
	
	@RequestMapping("isLogin")
	public int isLogin(HttpSession session){
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
		if (userInfo == null){
			return -1;
		}
		return 1;
	}
	
	
	@RequestMapping("addread")
	public int addread(int bokeid){
		return service.addread(bokeid);
	}


}
