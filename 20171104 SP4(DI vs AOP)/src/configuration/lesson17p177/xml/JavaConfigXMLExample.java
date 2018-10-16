package configuration.lesson17p177.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import configuration.lesson17p177.MessageRenderer;

public class JavaConfigXMLExample {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/configuration/lesson17/app-context-xml.xml");
		MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		renderer.render();
	}

}
