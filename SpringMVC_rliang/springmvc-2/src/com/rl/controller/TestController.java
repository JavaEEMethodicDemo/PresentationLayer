package com.rl.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rl.model.Person;
import com.rl.model.User;

@Controller//��ʶ��ǰ�����ǿ��Ʋ����
@RequestMapping("/test")//�൱�������ռ��ֹ��ͬController֮�еķ������ظ�
public class TestController {
	
	public TestController(){
		System.out.println("controller ����ʼ��");
	}
	
	/**
	 * 
	 * desc������ֵ����String��ModelAndView�е�viewName
	 * @RequestMapping�������������ӳ�䣬���淶ӳ������ֺͷ�����һ��ǰ���/�����.do
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello springmvc ann");
		return "index";
	}
	
	/**
	 * 
	 * desc���ڲ����б��п���ֱ�Ӷ���HttpServletRequest����
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping("/toPerson.do")
	public String toPerson(HttpServletRequest request){
		String name = request.getParameter("name");
		System.out.println(name);
		return "index";
	}
	
	/**
	 * 
	 * desc��ֱ���ڲ����б��ж���Ҫ���յĲ������������Ϳ��Ը��ݴ���Ĳ���ֵ��ҵ�������壬
	 * ǰ�������໥ת�������������ʵ�����Ͳ����б��е�����һ��Ҫƥ��
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping("/toPerson1.do")
	public String toPerson1(String name, Integer id, Integer gender, String address, Date birthday){
		System.out.println("������ "+name + " id: "+id + " �Ա� "+ gender + " ��ַ��"+address+" ���գ�"+birthday);
		return "index";
	}
	
	@RequestMapping("/toPerson2.do")
	public String toPerson2(HttpServletRequest request){
		String [] fav = request.getParameterValues("fav");
		for(String fa : fav){
			System.out.println(fa);
		}
		return "index";
	}
	/**
	 * 
	 * desc����ѡ��������ڲ����б���ֱ�Ӷ���һ�����飬�����գ�ע���������������Ҫ��������Ĳ����б��е�����ƥ��
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping("/toPerson3.do")
	public String toPerson3(Integer [] fav){
		for(Integer fa : fav){
			System.out.println(fa);
		}
		return "index";
	}
	
	/**
	 * 
	 * desc��ʵ�����͵Ĳ����Ľ��գ��ڲ����б���ֱ�Ӷ���ʵ�����ͣ�ע������Ĳ������ͽ��յ�ʵ�����е�set����Ҫƥ��
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping("/toPerson4.do")
	public String toPerson4(Person person, User user, String name){
		System.out.println(person);
		System.out.println(user);
		System.out.println(name);
		return "index";
	}
	
	/**
	 * 
	 * desc��ͨ��ModelAndView�����ݺ���ͼ������
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping("/toPerson5.do")
	public ModelAndView toPerson5() throws Exception{
		Person p = new Person();
		p.setId(1);
		p.setName("lisi");
		p.setAddress("beijing");
		p.setGender(1);
		p.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2012-12-12"));
		Map<String,Object> map = new HashMap<String,Object>();
		//�൱��request.setAttribute("person", p)
		map.put("person", p);
		return new ModelAndView("index", map);
	}
	/**
	 * 
	 * desc���ڲ����б��ж���Map<String, Object> map�� ���map�������ڽ��ղ���������ModeAndView�е�map�����ڷ��ؽ����
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping("/toPerson6.do")
	public String toPerson6(Map<String, Object> map) throws Exception{
		Person p = new Person();
		p.setId(1);
		p.setName("lisi");
		p.setAddress("beijing");
		p.setGender(1);
		p.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2012-12-12"));
		map.put("person", p);
		return "index";
	}
	
	/**
	 * 
	 * desc���ڲ����б��ж���Model�࣬�������ݽ����ʹ��model.addAttribute("person", p);, 
	 * �൱��request.setAttritute("person",p)
	 * ����ʹ��
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping("/toPerson7.do")
	public String toPerson7(Model model) throws Exception{
		Person p = new Person();
		p.setId(1);
		p.setName("lisi");
		p.setAddress("beijing");
		p.setGender(1);
		p.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("2012-12-12"));
		model.addAttribute("person", p);
		return "index";
	}
	
	/**
	 * 
	 * desc��ʹ��ajax��ʽ����springmvc�ķ������ڲ����б��ж���HttpServletResponse
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping("/ajax.do")
	public void ajax(String name, HttpServletResponse response) throws Exception{
		String result = name + " hello";
		response.getWriter().write(result);
		
	}
	
	/**
	 * 
	 * desc��ʹ��ajax��ʽ����springmvc�ķ������ڲ����б��ж���PrintWriter
	 * ����ʹ��
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping("/ajax1.do")
	public void ajax1(String name, PrintWriter out) throws Exception{
		String result = name + " hello";
		out.write(result);
	}
	
	
	
	@RequestMapping("/toAjax.do")
	public String toAjax() throws Exception{
		return "ajax";
	}
	
	/**
	 * 
	 * desc����ͬһ��Controller֮���ض���
	 * redirect:�������ͬһ��Controller�е�requestMapping��ֵ���ɣ�����Ҫָ�������ռ�
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping("/redirectToAjax.do")
	public String redirectToAjax() throws Exception{
		return "redirect:toAjax.do";
	}
	
	/**
	 * 
	 * desc��@RequestMapping�е�method����ָ������ʽ�����ָ����post����Ͳ���������������ʽ����Ҫʹ��post������ᱨ405����
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping(value="/toPerson8.do", method=RequestMethod.POST)
	public String toPerson8(Person person){
		System.out.println(person);
		return "index";
	}
	
	@RequestMapping(value="/toForm.do")
	public String toForm(){
		return "form";
	}
	
	/**
	 * 
	 * desc����ͬController֮����ض���
	 * redirect:/+"�����ռ�"/+"requestMapping��ֵ"
	 * author:����
	 * mail:renliangjava@163.com
	 * �༶������8��
	 */
	@RequestMapping("/redirectToAjax1.do")
	public String redirectToAjax1() throws Exception{
		return "redirect:/test1/toAjax.do";
	}
	
	
	
	

	
	@InitBinder//��ʶ��ǰ����ʱ��ת���������͵�
	public void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
}
