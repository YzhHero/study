package com.yzh.study.designPattern.factory.AbstractFactory;

import com.yzh.study.designPattern.factory.DB2Connector;
import com.yzh.study.designPattern.factory.MysqlConnector;
import com.yzh.study.designPattern.factory.OracleConnector;

/**
 * @program: data-analysis
 * @description: 抽象工厂实现类
 * @author: HeroYang
 * @create: 2019-08-02 18:32
 **/
public class ConnectorFactory extends AbstractConnectorFactory {
	@Override
	public DB2Connector getDB2Connector() {
		return new DB2Connector();
	}

	@Override
	public MysqlConnector getMysqlConnector() {
		return new MysqlConnector();
	}

	@Override
	public OracleConnector getOracleConnector() {
		return new OracleConnector();
	}
}
