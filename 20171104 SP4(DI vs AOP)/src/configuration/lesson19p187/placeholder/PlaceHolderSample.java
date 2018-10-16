package configuration.lesson19p187.placeholder;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PlaceHolderSample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		//ctx.load("classpath:META-INF/spring/configuration/lesson19/app-context-xml.xml");
		ctx.load("classpath:META-INF/spring/configuration/lesson19/localoverride/app-context-xml.xml");
		ctx.refresh();
		AppProperty appProperty = ctx.getBean("appProperty", AppProperty.class);
		System.out.println("application.home: " + appProperty.getApplicationHome());
		System.out.println("user.home: " + appProperty.getUserHome());
	}

}
