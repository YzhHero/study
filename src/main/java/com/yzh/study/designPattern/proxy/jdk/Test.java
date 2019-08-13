package com.yzh.study.designPattern.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description: jdk动态代理
 * @author: HeroYang
 * @create: 2019-08-12 21:35
 **/
public class Test {
	public static void main(String[] args) {
		ProxyTarget proxyTarget = new ProxyTarget();
		JDKProxy jdkProxy = new JDKProxy();
		Object proxyObj = jdkProxy.bind(proxyTarget);
		//返回出来的类型是 com.sun.proxy.$Proxy0
		ProxyInterface proxySource = (ProxyInterface) proxyObj;
		System.out.println("proxySource:" + proxySource.getClass());
		//将$Proxy0保存，反编译
		String proxy0FilePath = "./Proxy0.class";
		//生成proxyClass的字节码，并将其写入文件
		byte[] proxyClassBytes = ProxyGenerator.generateProxyClass(proxySource.getClass().getName(), ProxyTarget.class.getInterfaces());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(proxy0FilePath));
			fos.write(proxyClassBytes);
			fos.flush();
		} catch (IOException e) {
			try {
				fos.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}

		proxySource.sayHello();
	}
}
