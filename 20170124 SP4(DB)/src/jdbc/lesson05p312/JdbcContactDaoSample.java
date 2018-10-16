package jdbc.lesson05p312;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcContactDaoSample {

	private static ContactDao contactDao;

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/jdbc/lesson05/app-context-annotation.xml");
		System.out.println("-------------before ctx.refresh();");
		ctx.refresh();
		System.out.println("-------------after ctx.refresh();");
		contactDao = ctx.getBean("contactDao", ContactDao.class);
		System.out.println("-------------after ctx.getBean(...);");

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

}
