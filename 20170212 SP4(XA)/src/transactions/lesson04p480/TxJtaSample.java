package transactions.lesson04p480;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TxJtaSample {
	private static ContactService contactService;

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/transactions/lesson04/app-context-annotation.xml");
		System.out.println("-------------before ctx.refresh();");
		ctx.refresh();
		System.out.println("-------------after ctx.refresh();");
		contactService = ctx.getBean("contactService", ContactService.class);
		System.out.println("-------------after ctx.getBean(ContactService, ContactService.class);");
		
		
		Contact contact = new Contact();
		contact.setFirstName("Vic");
		contact.setLastName("K");
		contactService.save(contact);
		System.out.println("Contact saved successfully: " + contact);
	}

	

}
