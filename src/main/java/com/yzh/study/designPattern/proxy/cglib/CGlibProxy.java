package com.yzh.study.designPattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: data-analysis
 * @description:
 * @author: HeroYang
 * @create: 2019-08-13 10:00
 * 原理：对指定的目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理
 * TODO https://www.jianshu.com/p/20203286ccd9 深入
 **/
public class CGlibProxy implements MethodInterceptor {

	/**
	 * 创建代理对象
	 * @return
	 */
	public Object getInstance(Object target){
		Enhancer enhancer = new Enhancer();
		//指定父类,创建子类，即定义代理类
		enhancer.setSuperclass(target.getClass());
		//指定回调类（代理的方法）
		enhancer.setCallback(this);
		//通过字节码技术动态创建子类实例
		return enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("代理前");
		//调用父类，即被代理类的方法
		Object res = methodProxy.invokeSuper(o,objects);
		System.out.println("代理后");
		return res;
	}
}
