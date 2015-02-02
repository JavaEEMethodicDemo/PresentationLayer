package com.rl.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rl.model.Person;

@Controller//标识当前的类是控制层的类
@RequestMapping("/upload")//相当于命名空间防止不同Controller之中的方法名重复
public class UploadController {
	
	@RequestMapping("/uploadPic.do")
	public String uploadPic(Person person, HttpServletRequest request) throws Exception{
		System.out.println(person);
		//把request做强制转换
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
		//获得文件
		MultipartFile mf = mr.getFile("pic");
		//得到文件的字节数组
		byte[] mbyte = mf.getBytes();
		String fileName = "";
		//获得当前时间的最小精度，精确到三位毫秒数
		fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		//给文件名加三位随机数
		Random random = new Random();
		for(int i = 0; i < 3; i++){
			fileName = fileName + random.nextInt(10);
		}
		//获得原始文件名
		String oriFileName = mf.getOriginalFilename();
		//xxxx.jpg
		String suffix = oriFileName.substring(oriFileName.lastIndexOf("."));
		//获得项目在服务器中的根目录
		String realPath = request.getSession().getServletContext().getRealPath("/");
		//创建文件的输出流
		OutputStream out = new FileOutputStream(new File(realPath+"/upload/"+fileName+suffix));
		out.write(mbyte);
		out.flush();
		out.close();
		return "success";
	}
	
	@InitBinder//标识当前方法时用转换数据类型的
	public void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
