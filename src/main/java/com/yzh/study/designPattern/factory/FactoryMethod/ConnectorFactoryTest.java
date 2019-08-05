package com.yzh.study.designPattern.factory.FactoryMethod;

/**
 * @program: data-analysis
 * @description: 工厂方法使用Test
 * @author: HeroYang
 * @create: 2019-08-02 18:20
 **/
public class ConnectorFactoryTest {
	public static void main(String[] args) {
		//此处需要用户去管理工厂的创建
		ConnectorFactory connectorFactory = new DB2ConnectorFactory();
		System.out.println(connectorFactory.getConnector().getConnectorName());
	}

}
