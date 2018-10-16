package validation.lesson01p489;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PropEditorExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/validation/lesson01/app-context.xml");
		ctx.refresh();
		Contact chris = ctx.getBean("chris", Contact.class);
		System.out.println("Chris info: " + chris);

		Contact myContact = ctx.getBean("myContact", Contact.class);
		System.out.println("MyContact info: " + myContact);

	}

}
