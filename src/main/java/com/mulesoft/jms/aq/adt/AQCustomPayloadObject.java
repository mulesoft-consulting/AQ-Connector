package com.mulesoft.jms.aq.adt;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import oracle.jdbc.OracleTypes;
import oracle.jpub.runtime.MutableStruct;
import oracle.sql.Datum;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.STRUCT;

public class AQCustomPayloadObject implements ORAData, ORADataFactory {

	public static final String _SQL_NAME = "AQ_EVENT_OBJ";
	public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

	protected MutableStruct _struct;

	protected static int[] _sqlType = { 91, 12, 12 };
	protected static ORADataFactory[] _factory = new ORADataFactory[3];
	protected static final AQCustomPayloadObject _AqEventObjFactory = new AQCustomPayloadObject();

	public static ORADataFactory getORADataFactory() {
		return _AqEventObjFactory;
	}

	/* constructors */
	protected void _init_struct(boolean init) {
		if (init) {
			_struct = new MutableStruct(new Object[3], _sqlType, _factory);
		}
	}

	public AQCustomPayloadObject() {
		_init_struct(true);
	}

	public AQCustomPayloadObject(Timestamp datetime, String id, String payload) throws SQLException {
		_init_struct(true);
		setDatetime(datetime);
		setId(id);
		setPayload(payload);
	}

	/* ORAData interface */
	public Datum toDatum(Connection c) throws SQLException {
		return _struct.toDatum(c, _SQL_NAME);
	}

	/* ORADataFactory interface */
	public ORAData create(Datum d, int sqlType) throws SQLException {
		return create(null, d, sqlType);
	}

	protected ORAData create(AQCustomPayloadObject o, Datum d, int sqlType) throws SQLException {
		if (d == null) {
			return null;
		}
		
		if (o == null) {
			o = new AQCustomPayloadObject();
		}
		
		o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
		
		return o;
	}

	/* Accessor methods */
	public Timestamp getDatetime() throws SQLException {
		return (Timestamp) _struct.getAttribute(0);
	}

	public void setDatetime(Timestamp datetime) throws SQLException {
		_struct.setAttribute(0, datetime);
	}

	public String getId() throws SQLException {
		return (String) _struct.getAttribute(1);
	}

	public void setId(String id) throws SQLException {
		_struct.setAttribute(1, id);
	}

	public String getPayload() throws SQLException {
		return (String) _struct.getAttribute(2);
	}

	public void setPayload(String payload) throws SQLException {
		_struct.setAttribute(2, payload);
	}
}
