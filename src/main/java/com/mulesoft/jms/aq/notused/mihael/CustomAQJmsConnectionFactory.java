package com.mulesoft.jms.aq.notused.mihael;

import javax.jms.Connection;
import javax.jms.JMSException;

import com.mulesoft.jms.aq.connection.AQConnectionWrapper;

import oracle.jms.AQjmsConnectionFactory;

public class CustomAQJmsConnectionFactory extends AQjmsConnectionFactory {
	private static final long serialVersionUID = 9049172625984719014L;

	public CustomAQJmsConnectionFactory(String jdbcUrl, String username, String password) throws JMSException {
        this.setJdbcURL(jdbcUrl);
        this.setUsername(username);
        this.setPassword(password);
    }

    @Override
    public Connection createConnection() throws JMSException {
        return new AQConnectionWrapper(super.createConnection());
    }

    @Override
    public Connection createConnection(String s, String s1) throws JMSException {
        return new AQConnectionWrapper(super.createConnection(s, s1));
    }
}
