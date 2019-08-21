package com.yzh.study.designPattern.delegate.imitateSpringMVC;

import com.yzh.study.designPattern.delegate.imitateSpringMVC.controller.Controller;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Method;

/**
 * @description: 模拟springMVC里的handler
 * @author: HeroYang
 * @create: 2019-08-21 10:21
 **/
@Getter
@Setter
@ToString
public class CustomHandler {

	private String url;

	private Method method;

	private Controller controller;

	public CustomHandler(String url, Method method,
			Controller controller) {
		this.url = url;
		this.method = method;
		this.controller = controller;
	}

}
