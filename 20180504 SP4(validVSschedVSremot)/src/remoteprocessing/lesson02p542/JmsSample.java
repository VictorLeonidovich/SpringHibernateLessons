package remoteprocessing.lesson02p542;

import org.apache.activemq.broker.BrokerService;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JmsSample {

	public static void main(String[] args) {
		BrokerService brokerService = new BrokerService();
		try {
			brokerService.addConnector("tcp://localhost:61616");
			brokerService.start();
		} catch (Exception e) {
			System.out.println("brokerService.start()");

			e.printStackTrace();
		}

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/remoteprocessing/lesson02/jms-listener-app-context.xml",
				"classpath:META-INF/remoteprocessing/lesson02/jms-sender-app-context.xml");
		ctx.refresh();
		MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);
		for (int i = 0; i < 10; i++) {
			messageSender.sendMessage("Test message: " + i);
		}
		/*try {
			brokerService.stop();
		} catch (Exception e) {
			System.out.println("brokerService.stop()");
			e.printStackTrace();
		}*/
	}

}
