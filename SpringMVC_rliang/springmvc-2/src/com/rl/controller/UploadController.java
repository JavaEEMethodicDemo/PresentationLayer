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

@Controller//��ʶ��ǰ�����ǿ��Ʋ����
@RequestMapping("/upload")//�൱�������ռ��ֹ��ͬController֮�еķ������ظ�
public class UploadController {
	
	@RequestMapping("/uploadPic.do")
	public String uploadPic(Person person, HttpServletRequest request) throws Exception{
		System.out.println(person);
		//��request��ǿ��ת��
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
		//����ļ�
		MultipartFile mf = mr.getFile("pic");
		//�õ��ļ����ֽ�����
		byte[] mbyte = mf.getBytes();
		String fileName = "";
		//��õ�ǰʱ�����С���ȣ���ȷ����λ������
		fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		//���ļ�������λ�����
		Random random = new Random();
		for(int i = 0; i < 3; i++){
			fileName = fileName + random.nextInt(10);
		}
		//���ԭʼ�ļ���
		String oriFileName = mf.getOriginalFilename();
		//xxxx.jpg
		String suffix = oriFileName.substring(oriFileName.lastIndexOf("."));
		//�����Ŀ�ڷ������еĸ�Ŀ¼
		String realPath = request.getSession().getServletContext().getRealPath("/");
		//�����ļ��������
		OutputStream out = new FileOutputStream(new File(realPath+"/upload/"+fileName+suffix));
		out.write(mbyte);
		out.flush();
		out.close();
		return "success";
	}
	
	@InitBinder//��ʶ��ǰ����ʱ��ת���������͵�
	public void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
