package validation.lesson02p493;

import org.springframework.context.support.GenericXmlApplicationContext;


public class ConvServExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/validation/lesson02/app-context.xml");
		ctx.refresh();
		Contact chris = ctx.getBean("chris", Contact.class);
		System.out.println("Chris info: " + chris);
	}

}
