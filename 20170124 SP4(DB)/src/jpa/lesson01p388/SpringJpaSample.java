package jpa.lesson01p388;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringJpaSample {

	private static ContactService contactService;

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/jpa/app-context-annotation.xml");
		System.out.println("-------------before ctx.refresh();");
		ctx.refresh();
		System.out.println("-------------after ctx.refresh();");
		contactService = ctx.getBean("jpaContactService", ContactService.class);
		System.out.println("-------------after ctx.getBean(jpaContactService, ContactService.class);");
		 //listContactsWithoutDetail(contactService.findAll());
		 //listContactsWithDetail(contactService.findAllWithDetail());
		 //listContactsById(contactService.findById(1L));
		//ctx.getBean("contactSummaryUntype", ContactSummaryUntypeImpl.class).displayAllContactSummary();
		//listContactSummaryService(ctx.getBean("contactSummaryService", ContactSummaryService.class));
		 //saveContact(new Contact());
		 //updateContact(contactService.findById(1L));
		 //deleteContact(contactService.findById(1L));
		//listContactsWithoutDetail(contactService.findAllByNativeQuery());
		listContactsWithDetail(contactService.findByCriteriaQuery("John", "Smith"));
	}

	private static void listContactSummaryService(ContactSummaryService contactSummaryService) {
		for (ContactSummary contactSummary : contactSummaryService.findAll()) {
			System.out.println(contactSummary);
		}
		
	}

	private static void listContactsWithoutDetail(List<Contact> contacts) {
		System.out.println();
		System.out.println("Listing contacts without details:");
		for (Contact contact : contacts) {
			System.out.println(contact);
			
			System.out.println();
		}
	}

	private static void deleteContact(Contact contact) {
		contactService.delete(contact);
		listContactsWithDetail(contactService.findAllWithDetail());
	}

	private static void updateContact(Contact contact) {
		contact.setFirstName("ABBA");
		Set<ContactTelDetail> contactTelDetails = contact.getContactTelDetails();
		ContactTelDetail toDeletecontactTelDetail = null;
		for (ContactTelDetail contactTelDetail : contactTelDetails) {
			if (contactTelDetail.getTelType().equals("Home")) {
				toDeletecontactTelDetail = contactTelDetail;
			}
		}
		contact.removeContactTelDetail(toDeletecontactTelDetail);
		contactService.save(contact);
		listContactsWithDetail(contactService.findAllWithDetail());
	}

	private static void saveContact(Contact contact) {
		contact.setFirstName("Vic");
		contact.setLastName("K");
		contact.setBirthDate(new Date());
		contact.addContactTelDetail(new ContactTelDetail("Mob", "111"));
		contact.addContactTelDetail(new ContactTelDetail("Home", "222"));
		contactService.save(contact);
		listContactsWithDetail(contactService.findAllWithDetail());
	}

	private static void listContactsById(Contact contact) {
		System.out.println();
		System.out.println("Contact with id = 1: " + contact);
		System.out.println();
	}

	private static void listContactsWithDetail(List<Contact> contacts) {
		System.out.println();
		System.out.println("Listing contacts with details:");
		for (Contact contact : contacts) {
			System.out.println(contact);
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
					System.out.println(contactTelDetail);
				}
			}
			if (contact.getHobbies() != null) {
				for (Hobby hobby : contact.getHobbies()) {
					System.out.println(hobby);
				}
			}
			System.out.println();
		}
	}

}
