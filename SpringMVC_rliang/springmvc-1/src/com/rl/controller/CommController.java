package com.rl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.rl.model.Person;

public class CommController extends AbstractCommandController {

	/**
	 * ͨ��Object�Ĳ��������������commClass���������͵�ʵ�壬���ݴ��ݵĲ��������ֺ�ʵ�����е����������������ã�
	 * ���һ�¾ͻ������Ĳ���ע�뵽ʵ������У������ƥ�䲻��ע��
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
