package remoteprocessing.lesson03p546;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleMessageListener implements MessageListener {
	private static final Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			logger.info("Message received: " + textMessage.getText());
		} catch (JMSException e) {
			logger.error("JMS error", e);
		}
	}

}
