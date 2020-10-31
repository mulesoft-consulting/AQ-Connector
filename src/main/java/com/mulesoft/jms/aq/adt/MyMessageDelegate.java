package com.mulesoft.jms.aq.adt;

import org.w3c.dom.Document;

import com.mulesoft.jms.aq.domain.AqEvent;

public class MyMessageDelegate {
	public MyMessageDelegate() {
		System.out.println("!!! MyMessageDelegate");
	}
	
	public void handleXmlMessage(Document xmlDoc) {
		System.out.println("!!!! MyMessageDelegate::handleXmlMessage() !!!!");
	}
	
	public void handleAqEventMessage(AqEvent event) {
		System.out.println("!!!! MyMessageDelegate::handleAqEventMessage() !!!!");
	}
}
