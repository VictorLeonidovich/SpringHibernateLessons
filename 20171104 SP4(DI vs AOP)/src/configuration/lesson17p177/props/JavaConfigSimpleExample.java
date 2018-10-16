package configuration.lesson17p177.props;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.lesson17p177.MessageRenderer;

public class JavaConfigSimpleExample {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				configuration.lesson17p177.props.AppConfig.class);
		MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		renderer.render();
	}

}
