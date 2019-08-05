package com.yzh.study.designPattern.factory.FactoryMethod;

import com.yzh.study.designPattern.factory.Connector;
import com.yzh.study.designPattern.factory.MysqlConnector;

/**
 * @program: data-analysis
 * @description: mysql连接工厂
 * @author: HeroYang
 * @create: 2019-08-02 18:17
 **/
public class MysqlConnectorFactory implements ConnectorFactory{
	@Override
	public Connector getConnector() {
		return new MysqlConnector();
	}
}
