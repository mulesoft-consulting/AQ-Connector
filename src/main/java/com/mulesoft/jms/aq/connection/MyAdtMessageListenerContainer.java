package com.mulesoft.jms.aq.connection;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.mulesoft.jms.aq.adt.CustomEventObject;

import oracle.jms.AQjmsSession;

public class MyAdtMessageListenerContainer extends DefaultMessageListenerContainer {	
	protected MessageConsumer createConsumer(Session session, Destination destination) throws JMSException {
		System.out.println("!!! MyAdtMessageListenerContainer::createConsumer ");
		return ((AQjmsSession) session).createConsumer(destination, null, new CustomEventObject(), null, false);
	}

	protected void doShutdown() throws JMSException {
		super.doShutdown();
		logger.info("Shut down complete."); 
	}
}
