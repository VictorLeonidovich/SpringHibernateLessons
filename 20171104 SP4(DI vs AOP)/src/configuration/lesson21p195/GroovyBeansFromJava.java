package configuration.lesson21p195;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyBeansFromJava {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericGroovyApplicationContext(
				// "classpath:META-INF/spring/configuration/lesson21/beans.groovy");
				"classpath:META-INF/spring/configuration/lesson21/GroovyConfig.groovy");
		//Contact contact = ctx.getBean("contact", Contact.class);
		//System.out.println(contact);
	}

}
