package com.mulesoft.jms.aq.notused.blog;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

import oracle.jms.AQjmsSession;

public abstract class AbstractOracleAqFactoryBean {
	private ConnectionFactory connectionFactory;
	private String oracleQueueName = null;
	private String oracleQueueUser = null;

	public void setConnectionFactory(final ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	public String getOracleQueueName() {
		return oracleQueueName;
	}

	public void setOracleQueueName(final String oracleQueueName) {
		this.oracleQueueName = oracleQueueName;
	}

	public String getOracleQueueUser() {
		return oracleQueueUser;
	}

	public void setOracleQueueUser(final String oracleQueueUser) {
		this.oracleQueueUser = oracleQueueUser;
	}

	public boolean isSingleton() {
		return false;
	}

	protected AQjmsSession getSession() throws JMSException {
		final AQjmsSession session = (AQjmsSession) connectionFactory.createConnection().createSession(true,
				Session.SESSION_TRANSACTED);
		return session;
	}
}
