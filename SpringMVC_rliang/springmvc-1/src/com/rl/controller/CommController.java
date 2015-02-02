package com.rl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.rl.model.Person;

public class CommController extends AbstractCommandController {

	/**
	 * 通过Object的参数类接收所配置commClass的数据类型的实体，根据传递的参数的名字和实体类中的属性名来进行配置，
	 * 如果一致就会把请求的参数注入到实体对象中，如果不匹配不会注入
	 */
	@Override
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object obj, BindException arg3)
			throws Exception {
		Person person = (Person) obj;
		System.out.println(person);
		return new ModelAndView("index");
	}
	
	

}
