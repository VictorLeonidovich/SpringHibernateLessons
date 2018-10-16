package aop.lesson25p282;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/lesson25/app-context.xml");
		ctx.refresh();
		MessageWriter writer = new MessageWriter();
		writer.writeMessage();
		writer.foo();
	}

}
