package com.mulesoft.jms.aq.connection;

import javax.jms.CompletionListener;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;

import oracle.jms.AQjmsProducer;

public class AQMessageProducerWrapper implements MessageProducer {
	private AQjmsProducer producer;

	public AQMessageProducerWrapper(MessageProducer producer) {
		System.out.println("!!! producer class: " + producer.getClass().getName());
		this.producer = (AQjmsProducer) producer;
	}

	@Override
	public void close() throws JMSException {
		producer.close();
	}

	@Override
	public Destination getDestination() throws JMSException {
		return producer.getDestination();
	}

	@Override
	public long getDeliveryDelay() throws JMSException {
		//return producer.getDeliveryDelay();
		throw new UnsupportedOperationException("Oracle AQ JMS implementation is 1.1, not 2.0");
	}

	@Override
	public void setDeliveryDelay(long deliveryDelay) throws JMSException {
		//producer.setDeliveryDelay(deliveryDelay);
		throw new UnsupportedOperationException("Oracle AQ JMS implementation is 1.1, not 2.0");
	}

	@Override
	public int getDeliveryMode() throws JMSException {
		return producer.getDeliveryMode();
	}

	@Override
	public void setDeliveryMode(int deliveryMode) throws JMSException {
		producer.setDeliveryMode(deliveryMode);
	}

	@Override
	public boolean getDisableMessageID() throws JMSException {
		return producer.getDisableMessageID();
	}

	@Override
	public void setDisableMessageID(boolean value) throws JMSException {
		producer.setDisableMessageID(value);
	}

	@Override
	public boolean getDisableMessageTimestamp() throws JMSException {
		return producer.getDisableMessageTimestamp();
	}

	@Override
	public void setDisableMessageTimestamp(boolean value) throws JMSException {
		producer.setDisableMessageTimestamp(value);
	}

	@Override
	public int getPriority() throws JMSException {
		return producer.getPriority();
	}

	@Override
	public void setPriority(int priority) throws JMSException {
		producer.setPriority(priority);
	}

	@Override
	public long getTimeToLive() throws JMSException {
		return producer.getTimeToLive();
	}

	@Override
	public void setTimeToLive(long timeToLive) throws JMSException {
		producer.setTimeToLive(timeToLive);
	}

	@Override
	public void send(Message message) throws JMSException {
		System.out.println("!!! send1");
		producer.send(message);
	}

	@Override
	public void send(Destination destination, Message message) throws JMSException {
		System.out.println("!!! send2");
		producer.send(destination, message);
	}

	@Override
	public void send(Message message, CompletionListener listener) throws JMSException {
		System.out.println("!!! send3");
		//producer.send(message, listener);
		throw new UnsupportedOperationException("Oracle AQ JMS implementation is 1.1, not 2.0");
	}

	@Override
	public void send(Destination destination, Message message, CompletionListener listener) throws JMSException {
		System.out.println("!!! send4");
		//producer.send(destination, message, listener);
		throw new UnsupportedOperationException("Oracle AQ JMS implementation is 1.1, not 2.0");
	}

	@Override
	public void send(Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
		System.out.println("!!! send5");
		// Convert the message using the CustomEventObject ???
		producer.send(message, deliveryMode, priority, timeToLive);
	}

	@Override
	public void send(Destination destination, Message message, int deliveryMode, int priority, long timeToLive)
			throws JMSException {
		System.out.println("!!! send6");
		producer.send(destination, message, deliveryMode, priority, timeToLive);
	}

	@Override
	public void send(Message message, int deliveryMode, int priority, long timeToLive, CompletionListener listener)
			throws JMSException {
		System.out.println("!!! send7");
		//producer.send(message, deliveryMode, priority, timeToLive, listener);
		throw new UnsupportedOperationException("Oracle AQ JMS implementation is 1.1, not 2.0");
	}

	@Override
	public void send(Destination destination, Message message, int deliveryMode, int priority, long timeToLive,
			CompletionListener listener) throws JMSException {
		System.out.println("!!! send8");
		//producer.send(destination, message, deliveryMode, priority, timeToLive, listener);
		throw new UnsupportedOperationException("Oracle AQ JMS implementation is 1.1, not 2.0");
	}
}
