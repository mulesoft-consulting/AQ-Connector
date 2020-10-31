package com.mulesoft.jms.aq.connection.blog;

import javax.jms.JMSException;
import javax.jms.Queue;

import org.springframework.beans.factory.FactoryBean;

import oracle.jms.AQjmsSession;

public class OracleAqQueueFactoryBean extends AbstractOracleAqFactoryBean implements FactoryBean<Queue> {
	public Class<Queue> getObjectType() {
		return Queue.class;
	}

	public Queue getObject() throws JMSException {
		final AQjmsSession session = getSession();
		return session.getQueue(getOracleQueueUser(), getOracleQueueName());
	}
}
