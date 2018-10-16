package transactions.lesson01p459;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TxAnnotationSample {
	private static ContactService contactService;

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/transactions/lesson01/app-context-annotation.xml");
		System.out.println("-------------before ctx.refresh();");
		ctx.refresh();
		System.out.println("-------------after ctx.refresh();");
		contactService = ctx.getBean("contactService", ContactService.class);
		System.out.println("-------------after ctx.getBean(jpaContactService, ContactService.class);");
		
		
		listContacts("Find all: ", contactService.findAll());
		Contact contact = contactService.findById(1L);
		contact.setFirstName("Vic");
		contactService.save(contact);
		System.out.println("Contact saved successfully: " + contact);
		System.out.println("Contact count: " + contactService.countAll());
	}

	private static void listContacts(String message, List<Contact> contacts) {
		System.out.println("");
		System.out.println(message);
		for (Contact contact : contacts) {
			System.out.println(contact);
			System.out.println();

		}

	}

}
