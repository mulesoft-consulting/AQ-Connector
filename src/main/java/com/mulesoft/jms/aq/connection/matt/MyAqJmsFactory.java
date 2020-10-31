package com.mulesoft.jms.aq.connection.matt;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import oracle.jms.AQjmsFactory;

public class MyAqJmsFactory {
	public static ConnectionFactory getQueueConnectionFactory(String jdbcUrl, Properties props) throws JMSException {
		return new MyAqJmsConnectionFactory(AQjmsFactory.getConnectionFactory(jdbcUrl, props));
	}
}
