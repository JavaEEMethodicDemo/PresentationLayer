package com.rl.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	/**
	 * ִ��ʱ������ͼ����������ҳ����ɣ������Ŀ�����ڵ����ݼ�����ã�����¼������Ϣ�� try catch�е�finally
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception ex)
			throws Exception {
		System.out.println("ִ����������...");
		System.out.println("------------------------------------------");
		if(ex!=null){
			ex.printStackTrace();
		}
		System.out.println("------------------------------------------");
	}

	/**
	 * ִ��ʱ������Controllerִ����ϣ�����ͼ����������֮ǰִ��
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView mv) throws Exception {
		Map<String, Object> map = mv.getModel();
		map.put("postHandlerTest", "appending something...");
		System.out.println("ִ�к�������...");
	}

	/**
	 * ִ��ʱ������Controllerִ��֮ǰ
	 * ����ֵ�����ͣ�Boolean���������true������У������false������������
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("ִ��ǰ������...");
		
		return true;
	}

}
