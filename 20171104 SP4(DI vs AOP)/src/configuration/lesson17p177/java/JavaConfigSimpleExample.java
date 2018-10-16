package configuration.lesson17p177.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.lesson17p177.MessageRenderer;

public class JavaConfigSimpleExample {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfig.class);
		MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		renderer.render();
	}

}
