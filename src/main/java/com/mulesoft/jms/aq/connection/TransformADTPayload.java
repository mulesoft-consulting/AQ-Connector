package com.mulesoft.jms.aq.connection;

import java.sql.SQLException;

import oracle.xdb.XMLType;

public class TransformADTPayload {
	public static String format_string(XMLType payload) {
		try {
			return payload.getStringVal();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	/*-
	public static byte[] format_byte(XMLType payload) {
	        try {
	                return payload.toBytes();
	        } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	        }
	        return null;
	}
	public static java.io.InputStream format_stream (XMLType payload) {
	        try {
	                return payload.getInputStream();
	        } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	        }
	        return null;
	}
	*/
}
