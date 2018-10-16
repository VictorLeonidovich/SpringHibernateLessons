package configuration.lesson11p157;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactoryExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/configuration/lesson11/app-context-xml.xml");
		ctx.refresh();
		MessageDigester messageDigester = (MessageDigester) ctx.getBean("digester");
		messageDigester.digest("Hello, World!");
	}

}
