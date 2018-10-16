package configuration.lesson20p191;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Jsr330Example {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/configuration/lesson20/app-context-xml.xml");
		ctx.refresh();
		MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		renderer.render();
	}

}
