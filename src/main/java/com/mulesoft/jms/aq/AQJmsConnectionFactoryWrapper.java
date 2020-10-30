package com.mulesoft.jms.aq;

//import org.mule.jms.commons.internal.connection.provider.JmsConnectionProvider;

//import java.io.Serializable;
//import java.sql.SQLException;

//import javax.jms.BytesMessage;
import javax.jms.Connection;
//import javax.jms.ConnectionConsumer;
//import javax.jms.ConnectionMetaData;
//import javax.jms.Destination;
//import javax.jms.ExceptionListener;
import javax.jms.JMSException;
//import javax.jms.MapMessage;
//import javax.jms.Message;
//import javax.jms.MessageConsumer;
//import javax.jms.MessageListener;
//import javax.jms.MessageProducer;
//import javax.jms.ObjectMessage;
//import javax.jms.Queue;
//import javax.jms.QueueBrowser;
//import javax.jms.ServerSessionPool;
//import javax.jms.Session;
//import javax.jms.StreamMessage;
//import javax.jms.TemporaryQueue;
//import javax.jms.TemporaryTopic;
//import javax.jms.TextMessage;
//import javax.jms.Topic;
//import javax.jms.TopicSubscriber;

//import oracle.AQ.AQSession;
//import oracle.jms.AQjmsConnection;
import oracle.jms.AQjmsConnectionFactory;
//import oracle.jms.AQjmsSession;
//import oracle.sql.Datum;
//import oracle.sql.ORAData;
//import oracle.sql.ORADataFactory;

@SuppressWarnings("serial")
public class AQJmsConnectionFactoryWrapper extends AQjmsConnectionFactory {

    public AQJmsConnectionFactoryWrapper(String jdbcUrl, String username, String password) throws JMSException {
        super();
        this.setJdbcURL(jdbcUrl);
        this.setUsername(username);
        this.setPassword(password);
    }

    @Override
    public Connection createConnection() throws JMSException {
        return new AQConnectionWrapper(super.createConnection());
    }

    @Override
    public Connection createConnection(String s, String s1) throws JMSException {
        return super.createConnection(s, s1);
    }


}
