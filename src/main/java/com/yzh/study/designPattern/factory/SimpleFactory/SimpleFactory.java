package com.yzh.study.designPattern.factory.SimpleFactory;

import com.yzh.study.designPattern.factory.Connector;
import com.yzh.study.designPattern.factory.DB2Connector;
import com.yzh.study.designPattern.factory.MysqlConnector;
import com.yzh.study.designPattern.factory.OracleConnector;

/**
 * @program: data-analysis
 * @description: 简单工厂
 * @author: HeroYang
 * @create: 2019-08-02 17:12
 **/

public class SimpleFactory {
	public Connector getConncector(String conncectorName){
		Connector connector = null;
		switch (conncectorName){
			case "mysql":
				connector =  new MysqlConnector();
				break;
			case "oracle":
				connector =  new OracleConnector();
				break;
			case "DB2":
				connector =  new DB2Connector();
				break;
			//*******************拓展的时候需要修改代码
			default:
				System.out.println("没有这种类型的连接器");
		}
		return connector;
	}
}
