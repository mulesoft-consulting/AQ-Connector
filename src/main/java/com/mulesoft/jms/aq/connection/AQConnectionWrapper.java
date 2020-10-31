package com.mulesoft.jms.aq.connection;

import javax.jms.Connection;
import javax.jms.ConnectionConsumer;
import javax.jms.ConnectionMetaData;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.ServerSessionPool;
import javax.jms.Session;
import javax.jms.Topic;

public class AQConnectionWrapper implements Connection {
	private Connection connection;

	public AQConnectionWrapper(Connection connection) {
		System.out.println("!!! AQConnectionWrapper(" + connection.getClass().getName() + ")");
		this.connection = connection;
	}

	@Override
	public Session createSession(boolean transacted, int acknowledgeMode) throws JMSException {
		return new AQSessionWrapper(connection.createSession(transacted, acknowledgeMode));
		//return connection.createSession(transacted, acknowledgeMode);
	}

	@Override
	public Session createSession(int sessionMode) throws JMSException {
		return new AQSessionWrapper(connection.createSession(sessionMode));
		//return connection.createSession(sessionMode);
	}

	@Override
	public Session createSession() throws JMSException {
		return new AQSessionWrapper(connection.createSession());
		//return connection.createSession();
	}

	@Override
	public String getClientID() throws JMSException {
		return connection.getClientID();
	}

	@Override
	public void setClientID(String clientID) throws JMSException {
		connection.setClientID(clientID);
	}

	@Override
	public ConnectionMetaData getMetaData() throws JMSException {
		return connection.getMetaData();
	}

	@Override
	public ExceptionListener getExceptionListener() throws JMSException {
		return connection.getExceptionListener();
	}

	@Override
	public void setExceptionListener(ExceptionListener listener) throws JMSException {
		connection.setExceptionListener(listener);
	}

	@Override
	public void start() throws JMSException {
		connection.start();
	}

	@Override
	public void stop() throws JMSException {
		connection.stop();
	}

	@Override
	public void close() throws JMSException {
		connection.close();
	}

	@Override
	public ConnectionConsumer createConnectionConsumer(Destination destination, String messageSelector,
			ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		return connection.createConnectionConsumer(destination, messageSelector, sessionPool, maxMessages);
	}

	@Override
	public ConnectionConsumer createSharedConnectionConsumer(Topic topic, String subscriptionName,
			String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		return connection.createSharedConnectionConsumer(topic, subscriptionName, messageSelector, sessionPool,
				maxMessages);
	}

	@Override
	public ConnectionConsumer createDurableConnectionConsumer(Topic topic, String subscriptionName,
			String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		return connection.createDurableConnectionConsumer(topic, subscriptionName, messageSelector, sessionPool,
				maxMessages);
	}

	@Override
	public ConnectionConsumer createSharedDurableConnectionConsumer(Topic topic, String subscriptionName,
			String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		return connection.createSharedDurableConnectionConsumer(topic, subscriptionName, messageSelector, sessionPool,
				maxMessages);
	}
}
