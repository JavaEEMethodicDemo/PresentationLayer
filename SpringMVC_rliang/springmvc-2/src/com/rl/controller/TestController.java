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

@Controller//标识当前的类是控制层的类
@RequestMapping("/test")//相当于命名空间防止不同Controller之中的方法名重复
public class TestController {
	
	public TestController(){
		System.out.println("controller 被初始化");
	}
	
	/**
	 * 
	 * desc：返回值类型String是ModelAndView中的viewName
	 * @RequestMapping：用于做请求的映射，按规范映射的名字和方法名一致前面加/后面加.do
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
	 */
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello springmvc ann");
		return "index";
	}
	
	/**
	 * 
	 * desc：在参数列表中可以直接定义HttpServletRequest对象
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
	 */
	@RequestMapping("/toPerson.do")
	public String toPerson(HttpServletRequest request){
		String name = request.getParameter("name");
		System.out.println(name);
		return "index";
	}
	
	/**
	 * 
	 * desc：直接在参数列表中定义要接收的参数，参数类型可以根据传入的参数值和业务来定义，
	 * 前提是能相互转换，请求参数的实参明和参数列表中的名字一定要匹配
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
	 */
	@RequestMapping("/toPerson1.do")
	public String toPerson1(String name, Integer id, Integer gender, String address, Date birthday){
		System.out.println("姓名： "+name + " id: "+id + " 性别： "+ gender + " 地址："+address+" 生日："+birthday);
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
	 * desc：多选情况可以在参数列表中直接定义一个数组，来接收，注意请求参数的名字要和所定义的参数列表中的名字匹配
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
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
	 * desc：实体类型的参数的接收，在参数列表中直接定义实体类型，注意请求的参数名和接收的实体类中的set方法要匹配
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
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
	 * desc：通过ModelAndView把数据和视图做返回
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
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
		//相当于request.setAttribute("person", p)
		map.put("person", p);
		return new ModelAndView("index", map);
	}
	/**
	 * 
	 * desc：在参数列表中定义Map<String, Object> map， 这个map不是用于接收参数，而是ModeAndView中的map，用于返回结果集
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
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
	 * desc：在参数列表中定义Model类，返回数据结果集使用model.addAttribute("person", p);, 
	 * 相当于request.setAttritute("person",p)
	 * 建议使用
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
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
	 * desc：使用ajax方式调用springmvc的方法，在参数列表中定义HttpServletResponse
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
	 */
	@RequestMapping("/ajax.do")
	public void ajax(String name, HttpServletResponse response) throws Exception{
		String result = name + " hello";
		response.getWriter().write(result);
		
	}
	
	/**
	 * 
	 * desc：使用ajax方式调用springmvc的方法，在参数列表中定义PrintWriter
	 * 建议使用
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
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
	 * desc：在同一个Controller之中重定向，
	 * redirect:后面加上同一个Controller中的requestMapping的值即可，不需要指定命名空间
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
	 */
	@RequestMapping("/redirectToAjax.do")
	public String redirectToAjax() throws Exception{
		return "redirect:toAjax.do";
	}
	
	/**
	 * 
	 * desc：@RequestMapping中的method可以指定请求方式，如果指定是post请求就不能用其他的请求方式必须要使用post，否则会报405错误
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
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
	 * desc：不同Controller之间的重定向：
	 * redirect:/+"命名空间"/+"requestMapping的值"
	 * author:任亮
	 * mail:renliangjava@163.com
	 * 班级：黑马8期
	 */
	@RequestMapping("/redirectToAjax1.do")
	public String redirectToAjax1() throws Exception{
		return "redirect:/test1/toAjax.do";
	}
	
	
	
	

	
	@InitBinder//标识当前方法时用转换数据类型的
	public void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
}
