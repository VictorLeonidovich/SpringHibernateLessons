package di.lesson06p55;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.lesson05.MessageRenderer;

public class DependencyPull {
	public static void main (String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/di/lesson05/app-context.xml");
		MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
		mr.render();
	}

}
