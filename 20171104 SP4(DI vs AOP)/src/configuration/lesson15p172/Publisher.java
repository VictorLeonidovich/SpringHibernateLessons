package configuration.lesson15p172;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Publisher implements ApplicationContextAware {

	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}

	public void publish(String message) {
		ctx.publishEvent(new MessageEvent(this, message));
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/configuration/lesson15/app-context-xml.xml");
		Publisher pub = (Publisher) ctx.getBean("publisher");
		pub.publish("Hello, World!");
		pub.publish("The quick brown fox jumped over the lazy dog");
	}
}
