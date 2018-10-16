package jdbc.lesson02p302;

import org.springframework.context.support.GenericXmlApplicationContext;


public class JdbcContactDaoSample {

	private static ContactDao contactDao;

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/jdbc/lesson02/app-context-annotation.xml");
		System.out.println("-------------before ctx.refresh();");
		ctx.refresh();
		System.out.println("-------------after ctx.refresh();");
		contactDao = ctx.getBean("contactDao", ContactDao.class);
		System.out.println("-------------after ctx.getBean(...);");
		
		System.out.println("First name of contact id 1 is: " + contactDao.findLastNameById(1L));;
	}
	

}
