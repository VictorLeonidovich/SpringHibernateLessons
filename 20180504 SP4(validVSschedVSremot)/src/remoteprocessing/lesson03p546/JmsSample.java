package remoteprocessing.lesson03p546;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.core.config.Configuration;
import org.hornetq.core.config.impl.ConfigurationImpl;
import org.hornetq.core.remoting.impl.netty.NettyAcceptorFactory;
import org.hornetq.jms.server.config.JMSConfiguration;
import org.hornetq.jms.server.config.JMSQueueConfiguration;
import org.hornetq.jms.server.config.impl.JMSConfigurationImpl;
import org.hornetq.jms.server.config.impl.JMSQueueConfigurationImpl;
import org.hornetq.jms.server.embedded.EmbeddedJMS;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JmsSample {

	public static void main(String[] args) {
		Configuration configuration = new ConfigurationImpl();
		configuration.setPersistenceEnabled(false);
		configuration.setSecurityEnabled(false);
		configuration.getAcceptorConfigurations().add(new TransportConfiguration(NettyAcceptorFactory.class.getName()));

		JMSConfiguration jmsConfig = new JMSConfigurationImpl();

		
		JMSQueueConfiguration queueConfig = new JMSQueueConfigurationImpl("prospring4", null, false,
				"/queue/prospring4");
		jmsConfig.getQueueConfigurations().add(queueConfig);
		EmbeddedJMS jmsServer = new EmbeddedJMS();
		jmsServer.setConfiguration(configuration);
		jmsServer.setJmsConfiguration(jmsConfig);

		try {
			jmsServer.start();
		} catch (Exception e) {
			System.out.println("server.start()");
			e.printStackTrace();
		}

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/remoteprocessing/lesson03/jms-listener-app-context.xml",
				"classpath:META-INF/remoteprocessing/lesson03/jms-sender-app-context.xml");
		ctx.refresh();
		MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);
		for (int i = 0; i < 10; i++) {
			messageSender.sendMessage("Test message: " + i);
		}

	}

}
