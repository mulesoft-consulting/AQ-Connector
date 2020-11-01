package com.mulesoft.jms.aq.connection;

import java.nio.charset.StandardCharsets;
import java.sql.Date;

import javax.jms.CompletionListener;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;

import com.mulesoft.jms.aq.adt.CustomEventObject;

import oracle.jms.AQjmsProducer;
import oracle.jms.AQjmsSession;
import oracle.jms.AdtMessage;
import oracle.sql.CHAR;
import oracle.sql.CharacterSet;

public class AQMessageProducerWrapper implements MessageProducer {
	private AQjmsProducer producer;
	private AQjmsSession session;

	public AQMessageProducerWrapper(MessageProducer producer, AQjmsSession session) {
		System.out.println("!!! producer class: " + producer.getClass().getName());
		this.producer = (AQjmsProducer) producer;
		this.session = session;
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
		AdtMessage adt_message = session.createAdtMessage();
		// TODO Detect the message type and actually convert the message payload...
		adt_message.setAdtPayload(new CustomEventObject(new Date(2020, 10, 10), "Id", "Payload"));
		
		adt_message.setJMSCorrelationID(message.getJMSCorrelationID());
		adt_message.setJMSDeliveryMode(message.getJMSDeliveryMode());
		adt_message.setJMSDestination(message.getJMSDestination());
		adt_message.setJMSExpiration(message.getJMSExpiration());
		adt_message.setJMSMessageID(message.getJMSMessageID());
		adt_message.setJMSPriority(message.getJMSPriority());
		adt_message.setJMSRedelivered(message.getJMSRedelivered());
		// Feature not supported
		//adt_message.setJMSReplyTo(message.getJMSReplyTo());
		adt_message.setJMSTimestamp(message.getJMSTimestamp());
		
		producer.send(adt_message, deliveryMode, priority, timeToLive);
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
