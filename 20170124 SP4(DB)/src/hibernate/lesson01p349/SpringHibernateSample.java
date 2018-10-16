package hibernate.lesson01p349;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringHibernateSample {

	private static ContactDao contactDao;

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/hibernate/app-context-annotation.xml");
		System.out.println("-------------before ctx.refresh();");
		ctx.refresh();
		System.out.println("-------------after ctx.refresh();");
		contactDao = ctx.getBean("contactDao", ContactDao.class);
		System.out.println("-------------after ctx.getBean(contactDao, ContactDao.class);");
		// listContacts(contactDao.findAll());
		// listContacts(contactDao.findAllWithDetail());
		// listContactsById(contactDao.findById(1L));
		// saveContact(new Contact());
		// updateContact(contactDao.findById(1L));
		deleteContact(contactDao.findById(1L));
	}

	private static void deleteContact(Contact contact) {
		contactDao.delete(contact);
		listContacts(contactDao.findAllWithDetail());
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
		contactDao.save(contact);
		listContacts(contactDao.findAllWithDetail());
	}

	private static void saveContact(Contact contact) {
		contact.setFirstName("Vic");
		contact.setLastName("K");
		contact.setBirthDate(new Date());
		contact.addContactTelDetail(new ContactTelDetail("Mob", "111"));
		contact.addContactTelDetail(new ContactTelDetail("Home", "222"));
		contactDao.save(contact);
		listContacts(contactDao.findAllWithDetail());
	}

	private static void listContactsById(Contact contact) {
		System.out.println();
		System.out.println("Contact with id = 1: " + contact);
		System.out.println();
	}

	private static void listContacts(List<Contact> contacts) {
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
