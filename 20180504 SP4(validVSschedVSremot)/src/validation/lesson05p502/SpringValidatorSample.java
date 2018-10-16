package validation.lesson05p502;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SpringValidatorSample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/validation/lesson05/app-context.xml");
		ctx.refresh();
		Contact contact = new Contact();
		contact.setFirstName(null);
		contact.setLastName("Schaefer");
		Validator contactValidator = ctx.getBean("contactValidator", ContactValidator.class);
		BeanPropertyBindingResult result = new BeanPropertyBindingResult(contact, "Chris");
		ValidationUtils.invokeValidator(contactValidator, contact, result);
		List<ObjectError> errors = result.getAllErrors();
		System.out.println("No of validation errors: " + errors.size());
		for (ObjectError error : errors) {
			System.out.println(error.getCode());
		}
	}

}
