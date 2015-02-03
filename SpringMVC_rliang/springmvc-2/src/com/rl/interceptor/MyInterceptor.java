package com.rl.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	/**
	 * 执行时机：视图解析器解析页面完成，完成项目运行期的数据监控作用，来记录错误信息， try catch中的finally
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception ex)
			throws Exception {
		System.out.println("执行最终拦截...");
		System.out.println("------------------------------------------");
		if(ex!=null){
			ex.printStackTrace();
		}
		System.out.println("------------------------------------------");
	}

	/**
	 * 执行时机：在Controller执行完毕，在视图解析器解析之前执行
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView mv) throws Exception {
		Map<String, Object> map = mv.getModel();
		map.put("postHandlerTest", "appending something...");
		System.out.println("执行后置拦截...");
	}

	/**
	 * 执行时机：在Controller执行之前
	 * 返回值的类型：Boolean，如果返回true代表放行，如果是false代表拦截请求
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("执行前置拦截...");
		
		return true;
	}

}
