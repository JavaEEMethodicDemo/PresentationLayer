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
		//ModelAndView(viewName):ͨ����ͼ�������Ľ������Զ���viewNameǰ�����ǰ׺��������Ϻ�׺
		//ע�⣺viewName����jsp�����ֶ�����ͼ��������ǰ׺�ͺ�׺֮���һ��·��
		return new ModelAndView("jsp1/index");
	}

}
