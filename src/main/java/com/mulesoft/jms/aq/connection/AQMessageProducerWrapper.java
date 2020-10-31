package com.mulesoft.jms.aq.connection;

import javax.jms.CompletionListener;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;

public class AQMessageProducerWrapper implements MessageProducer {
	private MessageProducer producer;
	
	public AQMessageProducerWrapper(MessageProducer producer) {
		this.producer = producer;
	}
	
	@Override
	public void close() throws JMSException {
		producer.close();
	}

	@Override
	public long getDeliveryDelay() throws JMSException {
		return producer.getDeliveryDelay();
	}

	@Override
	public int getDeliveryMode() throws JMSException {
		return producer.getDeliveryMode();
	}

	@Override
	public Destination getDestination() throws JMSException {
		return producer.getDestination();
	}

	@Override
	public boolean getDisableMessageID() throws JMSException {
		return producer.getDisableMessageID();
	}

	@Override
	public boolean getDisableMessageTimestamp() throws JMSException {
		return producer.getDisableMessageTimestamp();
	}

	@Override
	public int getPriority() throws JMSException {
		return producer.getPriority();
	}

	@Override
	public long getTimeToLive() throws JMSException {
		return producer.getTimeToLive();
	}

	@Override
	public void send(Message arg0) throws JMSException {
		producer.send(arg0);
	}

	@Override
	public void send(Destination arg0, Message arg1) throws JMSException {
		producer.send(arg0, arg1);
	}

	@Override
	public void send(Message arg0, CompletionListener arg1) throws JMSException {
		producer.send(arg0, arg1);
	}

	@Override
	public void send(Destination arg0, Message arg1, CompletionListener arg2) throws JMSException {
		producer.send(arg0, arg1, arg2);
	}

	@Override
	public void send(Message arg0, int arg1, int arg2, long arg3) throws JMSException {
		producer.send(arg0, arg1, arg2, arg3);
	}

	@Override
	public void send(Destination arg0, Message arg1, int arg2, int arg3, long arg4) throws JMSException {
		producer.send(arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public void send(Message arg0, int arg1, int arg2, long arg3, CompletionListener arg4) throws JMSException {
		producer.send(arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public void send(Destination arg0, Message arg1, int arg2, int arg3, long arg4, CompletionListener arg5)
			throws JMSException {
		producer.send(arg0, arg1, arg2, arg3, arg4, arg5);
	}

	@Override
	public void setDeliveryDelay(long arg0) throws JMSException {
		producer.setDeliveryDelay(arg0);
	}

	@Override
	public void setDeliveryMode(int arg0) throws JMSException {
		producer.setDeliveryMode(arg0);
	}

	@Override
	public void setDisableMessageID(boolean arg0) throws JMSException {
		producer.setDisableMessageID(arg0);
	}

	@Override
	public void setDisableMessageTimestamp(boolean arg0) throws JMSException {
		producer.setDisableMessageTimestamp(arg0);
	}

	@Override
	public void setPriority(int arg0) throws JMSException {
		producer.setPriority(arg0);
	}

	@Override
	public void setTimeToLive(long arg0) throws JMSException {
		producer.setTimeToLive(arg0);
	}

}
