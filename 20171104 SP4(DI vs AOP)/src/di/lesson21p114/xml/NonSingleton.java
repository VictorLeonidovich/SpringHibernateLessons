package di.lesson21p114.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class NonSingleton {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/di/lesson21/app-context-xml.xml");
		ctx.refresh();
		String string1 = (String) ctx.getBean("nonSingleton");
		String string2 = (String) ctx.getBean("nonSingleton");
		
		String string3 = (String) ctx.getBean("singleton");
		String string4 = (String) ctx.getBean("singleton");
		
		System.out.println("Identity equal? " + (string1 == string2));
		System.out.println("Value equal? " + (string1.equals(string2)));
		System.out.println(string1);
		System.out.println(string2);
		System.out.println("");
		System.out.println("Identity equal? " + (string3 == string4));
		System.out.println("Value equal? " + (string3.equals(string4)));
		System.out.println(string3);
		System.out.println(string4);

	}

}
