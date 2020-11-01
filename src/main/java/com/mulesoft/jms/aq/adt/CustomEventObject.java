package com.mulesoft.jms.aq.adt;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Struct;

import oracle.jdbc.OracleData;
import oracle.jdbc.OracleDataFactory;
import oracle.sql.CHAR;
import oracle.sql.DATE;
import oracle.sql.STRUCT;

/*-
 * https://docs.oracle.com/en/database/oracle/oracle-database/19/jjdbc/Oracle-object-types.html#GUID-5905674A-A045-40B1-96DE-726761517D50
 * OracleData:
 * This is a new interface for encapsulating SQL types into Java types of the user's choice replacing ORAData.
 * Users should use OracleData instead of ORAData. A User's class, which implements the OracleData interface,
 * can present a customised version of the SQL type.
 * A class XXXClass implementing OracleData must also implement the following method :
 *
 * public static XXXClass valueOf( YYYType value) throws SQLException
 *
 * where YYYtype can be one of the specific Java Object types in column 2 of Table B-3 of the JDBC spec.
 *
 * This interface is the replacement of the ORAData interface
 *
 *
 * OracleDataFactory:
 * This interface complements OracleData. It is passed to getObject() to create customised OracleData objects.
 * The following example shows the typical use of this interface:
 * 
 * EmpFactory factory = new EmpFactory();
 * OracleResultSet rs = ... ;
 * Emp m = (Emp) rs.getObject(column, factory);
 * ...
 * 
 * This interface is the replacement of the ORADataFactory
 */
public class CustomEventObject implements OracleData, OracleDataFactory {
	private static final CustomEventObject INSTANCE = new CustomEventObject();

	public static synchronized OracleDataFactory getOracleDataFactory() {
		return INSTANCE;
	}

	private Date datetime;
	private String id;
	private String payload;

	public CustomEventObject() {
	}

	public CustomEventObject(Date datetime, String id, String payload) {
		this.datetime = datetime;
		this.id = id;
		this.payload = payload;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public Object toJDBCObject(Connection c) throws SQLException {
		System.out.println("!!! toJDBCObject ");
		
		Object[] attributes = { datetime, id, payload };
		Struct struct = c.createStruct("AQCONN_USER.AQ_EVENT_OBJ", attributes);
		return struct;
	}

	public OracleData create(Object jdbcValue, int sqlType) throws SQLException {
		System.out.println("!!! create ");
		
		if (jdbcValue == null) {
			return null;
		}
		
		System.out.println("!!! create - jdbcValue class: " + jdbcValue.getClass().getName());
		Object[] attributes = ((STRUCT) jdbcValue).getOracleAttributes();
		DATE d = (DATE)attributes[0];
		CHAR id = (CHAR)attributes[1];
		CHAR payload = (CHAR)attributes[2];
		
		return new CustomEventObject(d.dateValue(), id.getString(), payload.getString());
	}

	@Override
	public String toString() {
		return "CustomEventObject [datetime=" + datetime + ", id=" + id + ", payload=" + payload + "]";
	}
}
