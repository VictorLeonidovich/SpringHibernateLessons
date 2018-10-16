package di.lesson10p75;

import org.springframework.context.support.GenericXmlApplicationContext;

import di.lesson10p75.annotation2.MessageProvider;

public class DeclareSpringComponents {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		// ctx.load("classpath:META-INF/spring/di/lesson10/c-constr-xml-style.xml");
		// ctx.load("classpath:META-INF/spring/di/lesson10/constr-xml-style.xml");
		 ctx.load("classpath:META-INF/spring/di/lesson10/outofcodeinjection-annot-style.xml");
		// ctx.load("classpath:META-INF/spring/di/lesson10/annot-style.xml");
		ctx.refresh();
		MessageProvider messageProvider = ctx.getBean("provider", MessageProvider.class);
		System.out.println(messageProvider.getMessage());

	}

}
