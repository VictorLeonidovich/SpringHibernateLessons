package configuration.lesson10p152;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/configuration/lesson10/app-context-xml.xml");
		ctx.refresh();
		MessageDigester messageDigester = (MessageDigester) ctx.getBean("digester");
		messageDigester.digest("Hello, World!");
	}

}
