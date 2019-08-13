package com.yzh.study.designPattern.proxy.jdk;

/**
 * @program: data-analysis
 * @description:被代理的对象
 * @author: HeroYang
 * @create: 2019-08-12 21:09
 **/
public class ProxyTarget implements ProxyInterface {
	@Override
	public void sayHello() {
		System.out.println("你好，我是准备被JDK代理的类");
	}
}
