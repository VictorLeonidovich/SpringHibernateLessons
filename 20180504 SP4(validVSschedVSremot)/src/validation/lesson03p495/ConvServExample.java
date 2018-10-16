package validation.lesson03p495;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

public class ConvServExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/validation/lesson03/app-context.xml");
		ctx.refresh();
		Contact chris = ctx.getBean("chris", Contact.class);
		System.out.println("Chris info: " + chris);

		ConversionService conversionService = ctx.getBean(ConversionService.class);
		AnotherContact anotherContact = conversionService.convert(chris, AnotherContact.class);
		System.out.println("AnotherContact info: " + anotherContact);
		String[] stringArray = conversionService.convert("a,b,c", String[].class);
		System.out.println("String array: " + stringArray[0] + stringArray[1] + stringArray[2]);
		List<String> listString = new ArrayList<>();
		listString.add("a");
		listString.add("b");
		listString.add("c");
		Set<String> setString = conversionService.convert(listString, HashSet.class);
		for (String string : setString) {
			System.out.println("Set: " + string);
		}
	}

}
