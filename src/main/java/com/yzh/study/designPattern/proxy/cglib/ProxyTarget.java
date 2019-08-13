package com.yzh.study.designPattern.proxy.cglib;

/**
 * @program: data-analysis
 * @description: CGlib动态代理的被代理对象
 * @author: HeroYang
 * @create: 2019-08-13 09:55
 **/
public class ProxyTarget {
	public void sayHello(){
		System.out.println("Hello,我准备被Cglib动态代理了！");
	}
}
