package jdbc.lesson06p317;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AnnotationJdbcDaoSample {

	private static ContactDao contactDao;

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/jdbc/lesson06/app-context-annotation.xml");
		System.out.println("-------------before ctx.refresh();");
		ctx.refresh();
		System.out.println("-------------after ctx.refresh();");
		contactDao = ctx.getBean("contactDao", ContactDao.class);
		System.out.println("-------------after ctx.getBean(...);");

		// List<Contact> contacts = contactDao.findAll();
		// List<Contact> contacts = contactDao.findByFirstName("Chris");
		//updateContact();
		//???insertContact();
		insertContactWithDetail();
		
		List<Contact> contacts = contactDao.findAllWithDetail();

		for (Contact contact : contacts) {
			System.out.println(contact);
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact.getContactTelDetails()) {
					System.out.println("---" + contactTelDetail);
				}
			}
		}

		System.out.println();
	}

	private static void insertContactWithDetail() {
		Contact contact = new Contact();
		contact.setFirstName("Vic");
		contact.setLastName("K");
		contact.setBirthDate(new Date(new GregorianCalendar(2001, 10, 1).getTime().getTime()));
		List<ContactTelDetail> contactTelDetails = new ArrayList<>();
		ContactTelDetail contactTelDetail = new ContactTelDetail();
		contactTelDetail.setTelType("Home");
		contactTelDetail.setTelNumber("00000000");
		contactTelDetails.add(contactTelDetail);
		contactTelDetail.setTelType("Mobile");
		contactTelDetail.setTelNumber("01010101");
		contactTelDetails.add(contactTelDetail);
		contact.setContactTelDetails(contactTelDetails);
		contactDao.insertWithDetail(contact);
	}

	private static void insertContact() {
		Contact contact = new Contact();
		contact.setFirstName("Vic");
		contact.setLastName("K");
		contact.setBirthDate(new Date(new GregorianCalendar(2001, 10, 1).getTime().getTime()));
		contactDao.insert(contact);
	}

	private static void updateContact() {
		Contact contact = new Contact();
		contact.setId(1L);
		contact.setFirstName("Vic");
		contact.setLastName("K");
		contact.setBirthDate(new Date(new GregorianCalendar(2001, 10, 1).getTime().getTime()));
		contactDao.update(contact);
	}

}
