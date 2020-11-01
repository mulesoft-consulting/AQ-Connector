package com.mulesoft.jms.aq.notused.mihael;

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

import com.mulesoft.jms.aq.connection.AQMessageProducerWrapper;

//import oracle.jms.AQjmsDestination;
import oracle.jms.AQjmsSession;
//import oracle.sql.Datum;
//import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;

public class AQSessionWrapper implements Session {
	private AQjmsSession aqJmsSession;

	private static ORADataFactory createADTPayloadFactory(Destination destination) {
		System.out.println("!!! createADTPayloadFactory(" + destination + " !!!");
		return AQCustomPayloadDataFactory.getORADataFactory();
	}

	public AQSessionWrapper(Session session) {
		System.out.println("!!! AQSessionWrapper(" + session.getClass().getName() + ")");
		this.aqJmsSession = (AQjmsSession) session;
	}

	@Override
	public BytesMessage createBytesMessage() throws JMSException {
		return aqJmsSession.createBytesMessage();
	}

	@Override
	public MapMessage createMapMessage() throws JMSException {
		return aqJmsSession.createMapMessage();
	}

	@Override
	public Message createMessage() throws JMSException {
		return aqJmsSession.createMessage();
	}

	@Override
	public ObjectMessage createObjectMessage() throws JMSException {
		return aqJmsSession.createObjectMessage();
	}

	@Override
	public ObjectMessage createObjectMessage(Serializable object) throws JMSException {
		return aqJmsSession.createObjectMessage(object);
	}

	@Override
	public StreamMessage createStreamMessage() throws JMSException {
		return aqJmsSession.createStreamMessage();
	}

	@Override
	public TextMessage createTextMessage() throws JMSException {
		return aqJmsSession.createTextMessage();
	}

	@Override
	public TextMessage createTextMessage(String text) throws JMSException {
		return aqJmsSession.createTextMessage(text);
	}

	@Override
	public boolean getTransacted() throws JMSException {
		return aqJmsSession.getTransacted();
	}

	@Override
	public int getAcknowledgeMode() throws JMSException {
		return aqJmsSession.getAcknowledgeMode();
	}

	@Override
	public void commit() throws JMSException {
		aqJmsSession.commit();
	}

	@Override
	public void rollback() throws JMSException {
		aqJmsSession.rollback();
	}

	@Override
	public void close() throws JMSException {
		aqJmsSession.close();
	}

	@Override
	public void recover() throws JMSException {
		aqJmsSession.recover();
	}

	@Override
	public MessageListener getMessageListener() throws JMSException {
		MessageListener ml = aqJmsSession.getMessageListener();
		System.out.println("!!! getMessageListener() will return: " + ml);
		return ml;
	}

	@Override
	public void setMessageListener(MessageListener listener) throws JMSException {
		System.out.println("!!! setMessageListener(" + listener + ")");
		aqJmsSession.setMessageListener(listener);
	}

	@Override
	public void run() {
		aqJmsSession.run();
	}

	@Override
	public MessageProducer createProducer(Destination destination) throws JMSException {
		System.out.println("!!! createProducer(" + destination + ")");
		return new AQMessageProducerWrapper(aqJmsSession.createProducer(destination));
	}

	@Override
	public MessageConsumer createConsumer(Destination destination) throws JMSException {
		System.out.println("!!! createConsumer(" + destination + ")");
		return aqJmsSession.createConsumer(destination);
	}

	@Override
	public MessageConsumer createConsumer(Destination destination, String messageSelector) throws JMSException {
		System.out.println("!!! createConsumer(" + destination + ", " + messageSelector + ")");

		return aqJmsSession.createConsumer(destination, messageSelector, createADTPayloadFactory(destination), null,
				false);
	}

	@Override
	public MessageConsumer createConsumer(Destination destination, String messageSelector, boolean noLocal)
			throws JMSException {
		System.out.println("!!! createConsumer(" + destination + ", " + messageSelector + ", " + noLocal + ")");
		return aqJmsSession.createConsumer(destination, messageSelector, noLocal);
	}

	@Override
	public MessageConsumer createSharedConsumer(Topic topic, String sharedSubscriptionName) throws JMSException {
		System.out.println("!!! createSharedConsumer(" + topic + ", " + sharedSubscriptionName + ")");
		// return session.createSharedConsumer(topic, sharedSubscriptionName);
		throw new UnsupportedOperationException("Oracle AQ JMS implementation is 1.1, not 2.0");
	}

	@Override
	public MessageConsumer createSharedConsumer(Topic topic, String sharedSubscriptionName, String messageSelector)
			throws JMSException {
		System.out.println(
				"!!! createSharedConsumer(" + topic + ", " + sharedSubscriptionName + ", " + messageSelector + ")");
		// return session.createSharedConsumer(topic, sharedSubscriptionName,
		// messageSelector);
		throw new UnsupportedOperationException("Oracle AQ JMS implementation is 1.1, not 2.0");
	}

	@Override
	public Queue createQueue(String queueName) throws JMSException {
		return aqJmsSession.createQueue(queueName);
	}

	@Override
	public Topic createTopic(String topicName) throws JMSException {
		return aqJmsSession.createTopic(topicName);
	}

	@Override
	public TopicSubscriber createDurableSubscriber(Topic topic, String name) throws JMSException {
		return aqJmsSession.createDurableSubscriber(topic, name);
	}

	@Override
	public TopicSubscriber createDurableSubscriber(Topic topic, String name, String messageSelector, boolean noLocal)
			throws JMSException {
		return aqJmsSession.createDurableSubscriber(topic, name, messageSelector, noLocal);
	}

	@Override
	public MessageConsumer createDurableConsumer(Topic topic, String name) throws JMSException {
		System.out.println("!!! createDurableConsumer(" + topic + ", " + name + ")");
		// return session.createDurableConsumer(topic, name);
		throw new UnsupportedOperationException("Oracle AQ JMS implementation is 1.1, not 2.0");
	}

	@Override
	public MessageConsumer createDurableConsumer(Topic topic, String name, String messageSelector, boolean noLocal)
			throws JMSException {
		System.out.println(
				"!!! createDurableConsumer(" + topic + ", " + name + ", " + messageSelector + ", " + noLocal + ")");
		// return session.createDurableConsumer(topic, name, messageSelector, noLocal);
		throw new UnsupportedOperationException("Oracle AQ JMS implementation is 1.1, not 2.0");
	}

	@Override
	public MessageConsumer createSharedDurableConsumer(Topic topic, String name) throws JMSException {
		System.out.println("!!! createSharedDurableConsumer(" + topic + ", " + name + ")");
		// return session.createSharedDurableConsumer(topic, name);
		throw new UnsupportedOperationException("Oracle AQ JMS implementation is 1.1, not 2.0");
	}

	@Override
	public MessageConsumer createSharedDurableConsumer(Topic topic, String name, String messageSelector)
			throws JMSException {
		System.out.println("!!! createSharedDurableConsumer(" + topic + ", " + name + ", " + messageSelector + ")");
		// return session.createSharedDurableConsumer(topic, name, messageSelector);
		throw new UnsupportedOperationException("Oracle AQ JMS implementation is 1.1, not 2.0");
	}

	@Override
	public QueueBrowser createBrowser(Queue queue) throws JMSException {
		return aqJmsSession.createBrowser(queue);
	}

	@Override
	public QueueBrowser createBrowser(Queue queue, String messageSelector) throws JMSException {
		return aqJmsSession.createBrowser(queue, messageSelector);
	}

	@Override
	public TemporaryQueue createTemporaryQueue() throws JMSException {
		return aqJmsSession.createTemporaryQueue();
	}

	@Override
	public TemporaryTopic createTemporaryTopic() throws JMSException {
		return aqJmsSession.createTemporaryTopic();
	}

	@Override
	public void unsubscribe(String name) throws JMSException {
		aqJmsSession.unsubscribe(name);
	}
}
