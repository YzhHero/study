package com.yzh.study.DesignPattern.factory.SimpleFactory;

/**
 * @program: data-analysis
 * @description: 简单工厂测试
 * @author: HeroYang
 * @create: 2019-08-02 18:00
 **/
public class SimpleFactoryTest {

	public static void main(String[] args) {
		SimpleFactory simpleFactory = new SimpleFactory();
		//不用管里面具体的实现，但是用户需要明确知道自己所需的Key
		System.out.println(simpleFactory.getConncector("mysql").getConnectorName());
		System.out.println(simpleFactory.getConncector("oracle").getConnectorName());
	}
}
