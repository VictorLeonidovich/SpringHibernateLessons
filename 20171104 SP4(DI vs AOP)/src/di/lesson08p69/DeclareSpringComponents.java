package di.lesson08p69;

import org.springframework.context.support.GenericXmlApplicationContext;

//import di.lesson08p69.xml.MessageProvider;
import di.lesson08p69.annotation.MessageProvider;

public class DeclareSpringComponents {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		// ctx.load("classpath:META-INF/spring/lesson08/app-context-xml.xml");
		ctx.load("classpath:META-INF/spring/di/lesson08/app-context-annotation.xml");
		ctx.refresh();
		MessageProvider messageProvider = ctx.getBean("provider", MessageProvider.class);
		System.out.println(messageProvider.getMessage());

	}

}
