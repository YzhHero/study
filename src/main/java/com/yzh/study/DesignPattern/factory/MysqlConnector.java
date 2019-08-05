package com.yzh.study.DesignPattern.factory;

/**
 * @program: data-analysis
 * @description: Mysql连接器
 * @author: HeroYang
 * @create: 2019-08-02 17:19
 **/
public class MysqlConnector implements Connector{
	public String getConnectorName() {
		return "Mysql数据库";
	}
}
