package jpa.lesson03p431;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import jpa.lesson02p426.Contact;

public class SpringJpaSample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/jpa/lesson03/app-context-annotation.xml");
		System.out.println("-------------before ctx.refresh();");
		ctx.refresh();
		System.out.println("-------------after ctx.refresh();");
		ContactAuditService contactAuditService = ctx.getBean("contactAuditService", ContactAuditService.class);
		System.out.println("-------------after ctx.getBean(jpaContactService, ContactService.class);");

		
		listContacts("Find all: ", contactAuditService.findAll());
		ContactAudit contactAudit = new ContactAudit();
		contactAudit.setFirstName("Victor");
		contactAudit.setLastName("K.");
		contactAudit.setBirthDate(new Date());
		contactAuditService.save(contactAudit);
		listContacts("Add new contact: ", contactAuditService.findAll());
		contactAudit = contactAuditService.findById(1L);
		System.out.println("Contact with id = 1: " + contactAudit);
		contactAudit.setFirstName("Victor2");
		contactAudit.setLastName("K2.");
		contactAudit.setBirthDate(new Date());
		listContacts("Updated contact with id = 1: ", contactAuditService.findAll());

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
