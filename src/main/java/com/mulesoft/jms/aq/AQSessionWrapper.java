package com.mulesoft.jms.aq;

import java.io.Serializable;
//import java.sql.SQLException;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TemporaryQueue;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

//import oracle.jms.AQjmsDestination;
import oracle.jms.AQjmsSession;
//import oracle.sql.Datum;
//import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;

public class AQSessionWrapper implements Session {

    public AQSessionWrapper(Session session) {
        this.session = session;
    }

    public BytesMessage createBytesMessage() throws JMSException {
        return session.createBytesMessage();
    }

    public MapMessage createMapMessage() throws JMSException {
        return session.createMapMessage();
    }

    public Message createMessage() throws JMSException {
        return session.createMessage();
    }

    public ObjectMessage createObjectMessage() throws JMSException {
        return session.createObjectMessage();
    }

    public ObjectMessage createObjectMessage(Serializable object) throws JMSException {
        return session.createObjectMessage(object);
    }

    public StreamMessage createStreamMessage() throws JMSException {
        return session.createStreamMessage();
    }

    public TextMessage createTextMessage() throws JMSException {
        return session.createTextMessage();
    }

    public TextMessage createTextMessage(String text) throws JMSException {
        return session.createTextMessage(text);
    }

    public boolean getTransacted() throws JMSException {
        return session.getTransacted();
    }

    public int getAcknowledgeMode() throws JMSException {
        return session.getAcknowledgeMode();
    }

    public void commit() throws JMSException {
        session.commit();
    }

    public void rollback() throws JMSException {
        session.rollback();
    }

    public void close() throws JMSException {
        session.close();
    }

    public void recover() throws JMSException {
        session.recover();
    }

    public MessageListener getMessageListener() throws JMSException {
        return session.getMessageListener();
    }

    public void setMessageListener(MessageListener listener) throws JMSException {
        session.setMessageListener(listener);
    }

    public void run() {
        session.run();
    }

    public MessageProducer createProducer(Destination destination) throws JMSException {
        return session.createProducer(destination);
    }

    public MessageConsumer createConsumer(Destination destination) throws JMSException {
        return session.createConsumer(destination);
    }

    public MessageConsumer createConsumer(Destination destination, String messageSelector) throws JMSException {
        return ((AQjmsSession) session).createConsumer(destination, messageSelector, createADTPayloadFactory(destination), null, false);
    }

	public MessageConsumer createConsumer(Destination destination, String messageSelector, boolean noLocal) throws JMSException {
        return session.createConsumer(destination, messageSelector, noLocal);
    }

    public MessageConsumer createSharedConsumer(Topic topic, String sharedSubscriptionName) throws JMSException {
        return session.createSharedConsumer(topic, sharedSubscriptionName);
    }

    public MessageConsumer createSharedConsumer(Topic topic, String sharedSubscriptionName, String messageSelector) throws JMSException {
        return session.createSharedConsumer(topic, sharedSubscriptionName, messageSelector);
    }

    public Queue createQueue(String queueName) throws JMSException {
        return session.createQueue(queueName);
    }

    public Topic createTopic(String topicName) throws JMSException {
        return session.createTopic(topicName);
    }

    public TopicSubscriber createDurableSubscriber(Topic topic, String name) throws JMSException {
        return session.createDurableSubscriber(topic, name);
    }

    public TopicSubscriber createDurableSubscriber(Topic topic, String name, String messageSelector, boolean noLocal) throws JMSException {
        return session.createDurableSubscriber(topic, name, messageSelector, noLocal);
    }

    public MessageConsumer createDurableConsumer(Topic topic, String name) throws JMSException {
        return session.createDurableConsumer(topic, name);
    }

    public MessageConsumer createDurableConsumer(Topic topic, String name, String messageSelector, boolean noLocal) throws JMSException {
        return session.createDurableConsumer(topic, name, messageSelector, noLocal);
    }

    public MessageConsumer createSharedDurableConsumer(Topic topic, String name) throws JMSException {
        return session.createSharedDurableConsumer(topic, name);
    }

    public MessageConsumer createSharedDurableConsumer(Topic topic, String name, String messageSelector) throws JMSException {
        return session.createSharedDurableConsumer(topic, name, messageSelector);
    }

    public QueueBrowser createBrowser(Queue queue) throws JMSException {
        return session.createBrowser(queue);
    }

    public QueueBrowser createBrowser(Queue queue, String messageSelector) throws JMSException {
        return session.createBrowser(queue, messageSelector);
    }

    public TemporaryQueue createTemporaryQueue() throws JMSException {
        return session.createTemporaryQueue();
    }

    public TemporaryTopic createTemporaryTopic() throws JMSException {
        return session.createTemporaryTopic();
    }

    public void unsubscribe(String name) throws JMSException {
        session.unsubscribe(name);
    }

    private Session session;

    private ORADataFactory createADTPayloadFactory(Destination destination) {
		// TODO return ADTPayloadFactory based on destination
		return new ADTPayloadFactory();
    }
}
