package com.rl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//��ʶ��ǰ�����ǿ��Ʋ����
@RequestMapping("/test1")//�൱�������ռ��ֹ��ͬController֮�еķ������ظ�
public class TestController1 {
	
	@RequestMapping("/toAjax.do")
	public String toAjax() throws Exception{
		return "ajax";
	}
}
