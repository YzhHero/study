package com.yzh.study.designPattern.observer.demo_listener.common;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @description: 工具类
 * @author: HeroYang
 * @create: 2019-08-25 21:31
 **/
public class Util {
	/**
	 * 自定义的根据Method 获取 methodName
	 * @param method
	 * @return
	 */
	public static String getMethodKey(Method method) {
		String parm = "";
		for (Parameter p : method.getParameters()) {
			parm += p.getType().getName();
			parm += ",";
		}
		if (parm.length() > 0) {
			parm = parm.substring(0, parm.length() - 1);
		}
		return method.getName() + "(" + parm + ")";
	}
}
