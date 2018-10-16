package jpa.lesson02p426;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringJpaSample {
	private static ContactService contactService;

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/jpa/lesson02/app-context-annotation.xml");
		System.out.println("-------------before ctx.refresh();");
		ctx.refresh();
		System.out.println("-------------after ctx.refresh();");
		contactService = ctx.getBean("springJpaContactService", ContactService.class);
		System.out.println("-------------after ctx.getBean(jpaContactService, ContactService.class);");
		listContacts("Find all: ", contactService.findAll());
		listContacts("Find all by first name: ", contactService.findByFirstName("Chris"));
		listContacts("Find all by first name and last name: ", contactService.findByFirstNameAndLastName("Chris", "Schaefer"));

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
