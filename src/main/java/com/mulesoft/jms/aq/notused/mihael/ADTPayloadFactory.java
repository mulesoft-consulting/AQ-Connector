package com.mulesoft.jms.aq.notused.mihael;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.sql.Datum;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;

public class ADTPayloadFactory implements ORAData, ORADataFactory {
	@Override
    public ORAData create(Datum datum, int i) throws SQLException {
    	System.out.println("!!! create(" + datum + ", " + i + ")");
        // Implement logic
        return null;
    }

	@Override
	public Datum toDatum(Connection connection) throws SQLException {
    	System.out.println("!!! toDatum(" + connection + ")");
		return null;
	}
}
