package com.yzh.study.DesignPattern.factory;

/**
 * @program: data-analysis
 * @description: Oracle连接器
 * @author: HeroYang
 * @create: 2019-08-02 17:28
 **/
public class OracleConnector implements Connector{

	public String getConnectorName() {
		return "Oralce连接器";
	}
}
