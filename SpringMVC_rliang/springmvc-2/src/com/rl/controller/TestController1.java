package com.rl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//标识当前的类是控制层的类
@RequestMapping("/test1")//相当于命名空间防止不同Controller之中的方法名重复
public class TestController1 {
	
	@RequestMapping("/toAjax.do")
	public String toAjax() throws Exception{
		return "ajax";
	}
}
