package com.yzh.study.DesignPattern.factory.FactoryMethod;

import com.yzh.study.DesignPattern.factory.Connector;
import com.yzh.study.DesignPattern.factory.DB2Connector;

/**
 * @program: data-analysis
 * @description: DB2连接器工厂
 * @author: HeroYang
 * @create: 2019-08-02 18:19
 **/
public class DB2ConnectorFactory implements ConnectorFactory {
	@Override
	public Connector getConnector() {
		return new DB2Connector();
	}
}
