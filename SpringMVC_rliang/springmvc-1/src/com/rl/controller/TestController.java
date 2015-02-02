package com.rl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class TestController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println("hello springmvc");
		//ModelAndView(viewName):通过视图解析器的解析会自动在viewName前面加上前缀，后面加上后缀
		//注意：viewName不是jsp的名字而是视图解析器的前缀和后缀之间的一段路径
		return new ModelAndView("jsp1/index");
	}

}
