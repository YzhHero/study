package com.yzh.study.designPattern.proxy.cglib;

/**
 * @program: data-analysis
 * @description:
 * @author: HeroYang
 * @create: 2019-08-13 10:58
 **/
public class Test {

	public static void main(String[] args) {
		ProxyTarget proxyTarget = new ProxyTarget();
		CGlibProxy cGlibProxy = new CGlibProxy();
		Object proxyObj = cGlibProxy.getInstance(proxyTarget);
		System.out.println(proxyObj.getClass());
		ProxyTarget proxy = (ProxyTarget) proxyObj;
		System.out.println(proxy.getClass());
		proxy.sayHello();
	}
}
