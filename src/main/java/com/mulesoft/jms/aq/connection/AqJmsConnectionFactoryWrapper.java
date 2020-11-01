package com.mulesoft.jms.aq.connection;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;

public class AqJmsConnectionFactoryWrapper implements ConnectionFactory {
	private ConnectionFactory connectionFactory;
	
	public AqJmsConnectionFactoryWrapper(ConnectionFactory connectionFactory) {
		System.out.println("!!! MyAqJmsConnectionFactory(" + connectionFactory.getClass().getName() + ")");
		this.connectionFactory = connectionFactory;
	}

	@Override
	public Connection createConnection() throws JMSException {
		return new AQConnectionWrapper(connectionFactory.createConnection());
	}

	@Override
	public Connection createConnection(String arg0, String arg1) throws JMSException {
		return new AQConnectionWrapper(connectionFactory.createConnection(arg0, arg1));
	}

	@Override
	public JMSContext createContext() {
		return connectionFactory.createContext();
	}

	@Override
	public JMSContext createContext(int arg0) {
		return connectionFactory.createContext(arg0);
	}

	@Override
	public JMSContext createContext(String arg0, String arg1) {
		return connectionFactory.createContext(arg0, arg1);
	}

	@Override
	public JMSContext createContext(String arg0, String arg1, int arg2) {
		return connectionFactory.createContext(arg0, arg1, arg2);
	}
}
