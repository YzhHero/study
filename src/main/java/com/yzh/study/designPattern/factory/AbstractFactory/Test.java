package com.yzh.study.designPattern.factory.AbstractFactory;

/**
 * @program: data-analysis
 * @description: 抽象工厂测试
 * @author: HeroYang
 * @create: 2019-08-02 18:35
 **/
public class Test {
	public static void main(String[] args) {
		AbstractConnectorFactory factory = new ConnectorFactory();
		//此处只用做选择
		System.out.println(factory.getDB2Connector().getConnectorName());
	}
}
