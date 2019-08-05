package com.yzh.study.designPattern.factory.AbstractFactory;

import com.yzh.study.designPattern.factory.DB2Connector;
import com.yzh.study.designPattern.factory.MysqlConnector;
import com.yzh.study.designPattern.factory.OracleConnector;

/**
 * @program: data-analysis
 * @description:  抽象工厂
 * @author: HeroYang
 * @create: 2019-08-02 18:27
 **/
public abstract class AbstractConnectorFactory {

	public void common(){
		System.out.println("公共建立连接方法");
	}

	public abstract DB2Connector getDB2Connector();

	public abstract MysqlConnector getMysqlConnector();

	public abstract OracleConnector getOracleConnector();
}
