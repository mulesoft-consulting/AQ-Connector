package com.mulesoft.jms.aq;

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
        this.connection = connection;
    }

    public Session createSession(boolean transacted, int acknowledgeMode) throws JMSException {
        return new AQSessionWrapper(connection.createSession(transacted, acknowledgeMode));
    }

    public Session createSession(int sessionMode) throws JMSException {
        return new AQSessionWrapper(connection.createSession(sessionMode));
    }

    public Session createSession() throws JMSException {
        return new AQSessionWrapper(connection.createSession());
    }

    public String getClientID() throws JMSException {
        return connection.getClientID();
    }

    public void setClientID(String clientID) throws JMSException {
        connection.setClientID(clientID);
    }

    public ConnectionMetaData getMetaData() throws JMSException {
        return connection.getMetaData();
    }

    public ExceptionListener getExceptionListener() throws JMSException {
        return connection.getExceptionListener();
    }

    public void setExceptionListener(ExceptionListener listener) throws JMSException {
        connection.setExceptionListener(listener);
    }

    public void start() throws JMSException {
        connection.start();
    }

    public void stop() throws JMSException {
        connection.stop();
    }

    public void close() throws JMSException {
        connection.close();
    }

    public ConnectionConsumer createConnectionConsumer(Destination destination, String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
        return connection.createConnectionConsumer(destination, messageSelector, sessionPool, maxMessages);
    }

    public ConnectionConsumer createSharedConnectionConsumer(Topic topic, String subscriptionName, String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
        return connection.createSharedConnectionConsumer(topic, subscriptionName, messageSelector, sessionPool, maxMessages);
    }

    public ConnectionConsumer createDurableConnectionConsumer(Topic topic, String subscriptionName, String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
        return connection.createDurableConnectionConsumer(topic, subscriptionName, messageSelector, sessionPool, maxMessages);
    }

    public ConnectionConsumer createSharedDurableConnectionConsumer(Topic topic, String subscriptionName, String messageSelector, ServerSessionPool sessionPool, int maxMessages) throws JMSException {
        return connection.createSharedDurableConnectionConsumer(topic, subscriptionName, messageSelector, sessionPool, maxMessages);
    }
};