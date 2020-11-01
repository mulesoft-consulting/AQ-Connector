package com.mulesoft.jms.aq.notused.blog;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.mulesoft.jms.aq.notused.mihael.AQCustomPayloadDataFactory;

import oracle.jms.AQjmsSession;

public class AQCustomPayloadMessageListenerContainer extends DefaultMessageListenerContainer {
	@Override
	protected MessageConsumer createConsumer(Session session, Destination destination) throws JMSException {
		return ((AQjmsSession) session).createConsumer(destination, getMessageSelector(),
				AQCustomPayloadDataFactory.getORADataFactory(), null, isPubSubNoLocal());
	}
}
