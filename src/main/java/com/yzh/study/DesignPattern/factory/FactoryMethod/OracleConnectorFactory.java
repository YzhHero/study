package com.yzh.study.DesignPattern.factory.FactoryMethod;

import com.yzh.study.DesignPattern.factory.Connector;
import com.yzh.study.DesignPattern.factory.OracleConnector;

/**
 * @program: data-analysis
 * @description: Oracle连接器工厂
 * @author: HeroYang
 * @create: 2019-08-02 18:19
 **/
public class OracleConnectorFactory implements ConnectorFactory {
	@Override
	public Connector getConnector() {
		return new OracleConnector();
	}
}
