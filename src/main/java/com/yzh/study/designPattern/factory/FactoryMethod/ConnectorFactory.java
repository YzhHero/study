package com.yzh.study.designPattern.factory.FactoryMethod;

import com.yzh.study.designPattern.factory.Connector;

//拓展无需修改代码，直接新建类就OK
public interface ConnectorFactory {
	public Connector getConnector();
}
