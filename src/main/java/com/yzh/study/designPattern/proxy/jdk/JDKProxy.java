package com.yzh.study.designPattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: JDK动态代理
 * @author: HeroYang
 * @create: 2019-08-12 20:49
 * 缺点：1、只能代理实现了接口的类
 **/
public class JDKProxy implements InvocationHandler {
	//保存被代理对象的引用
	private Object target;

	public Object bind(ProxyTarget proxyTarget) {
		//这里存下源对象，方便等会反射方法的时候调用
		this.target = proxyTarget;
		//返回一个代理类，(1)被代理类的类加载器，(2)被代理类的全部接口，(3)InvocationHandler接口的子类实例
		return Proxy.newProxyInstance(proxyTarget.getClass().getClassLoader(),
				proxyTarget.getClass().getInterfaces(),this);
		//反射构建代理类 [com.sun.proxy.$Proxy0] ，这个类实现了Proxy，动态实现接口，所以jdk动态代理必须要有接口
		//字节码重组
		/**
		 * jdk动态代理原理：
		 * 1、反射获取 真实对象(被代理对象) 的所有接口
		 * 2、Proxy类生成代理类，如[com.sun.proxy.$Proxy0]等，该类实现Proxy，并真实对象所有接口，并将所有的相应的方法
		 * 	  映射到invoke上来
		 * 3、具体可以看test中保存到文件中的$Proxy0.class
		 */
	}

	/**
	 * 代理类调用方法时，进入此方法
	 * @param proxy  被代理对象
	 * @param method  调用的方法
	 * @param args	调用方法的参数
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object res;
		System.out.println("代理前");
		//反射调用 被代理类的方法
		res = method.invoke(target,args);
		System.out.println("代理后");
		return res;
	}
}
