package jpa.lesson04p440;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringJpaSample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/jpa/lesson04/app-context-annotation.xml");
		System.out.println("-------------before ctx.refresh();");
		ctx.refresh();
		System.out.println("-------------after ctx.refresh();");
		ContactAuditService contactAuditService = ctx.getBean("contactAuditService", ContactAuditService.class);
		System.out.println("-------------after ctx.getBean(jpaContactService, ContactService.class);");

		
		
		ContactAudit contactAudit = new ContactAudit();
		contactAudit.setFirstName("Victor");
		contactAudit.setLastName("K.");
		contactAudit.setBirthDate(new Date());
		contactAuditService.save(contactAudit);
		listContacts("Add new contact: ", contactAuditService.findAll());
		
		contactAudit.setFirstName("Victor2");
		contactAuditService.save(contactAudit);
		listContacts("Updated new contact: ", contactAuditService.findAll());

		ContactAudit oldContactAudit = contactAuditService.findById(1L);
		System.out.println("Old contact with id=1 and rev. 1: " + System.lineSeparator() + oldContactAudit);
		oldContactAudit = contactAuditService.findAuditByRevision(1L, 1); //may be .findAuditByRevision(1L, 2)
		System.out.println("Old contact with id=1 and rev. 2: " + System.lineSeparator() + oldContactAudit);

	}

	private static void listContacts(String message, List<ContactAudit> contacts) {
		System.out.println("");
		System.out.println(message);
		for (ContactAudit contact : contacts) {
			System.out.println(contact);
			System.out.println();

		}

	}
}
