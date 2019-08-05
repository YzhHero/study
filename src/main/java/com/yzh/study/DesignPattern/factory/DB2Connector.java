package com.yzh.study.DesignPattern.factory;

/**
 * @program: data-analysis
 * @description: DB2连接器
 * @author: HeroYang
 * @create: 2019-08-02 17:34
 **/
public class DB2Connector implements Connector{
	public String getConnectorName() {
		return "DB2连接器";
	}
}
