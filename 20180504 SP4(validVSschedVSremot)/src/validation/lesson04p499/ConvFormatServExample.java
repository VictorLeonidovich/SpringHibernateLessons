package validation.lesson04p499;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

public class ConvFormatServExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/validation/lesson04/app-context.xml");
		ctx.refresh();
		Contact chris = ctx.getBean("chris", Contact.class);
		System.out.println("Chris info: " + chris);

		ConversionService conversionService = ctx.getBean("conversionService", ConversionService.class);
		System.out.println("Birthdate of contact is: " + conversionService.convert(chris.getBirthDate(), String.class));

	}

}
