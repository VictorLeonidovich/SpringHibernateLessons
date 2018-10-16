package di.lesson05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloWorldSpringDI {

	

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/di/lesson05/app-context.xml");

		MessageRenderer messageRenderer = ctx.getBean("renderer", MessageRenderer.class);
		messageRenderer.render();

	}

}
