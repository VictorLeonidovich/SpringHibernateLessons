package di.lesson11p79.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("confusion")
public class ConstructorConfusion {
	private String someValue;

	public ConstructorConfusion(String someValue) {
		System.out.println("ConstructorConfusion(String) called.");
		this.someValue = someValue;
	}

	@Autowired
	public ConstructorConfusion(@Value("90") int someValue) {
		System.out.println("ConstructorConfusion(int) called.");
		this.someValue = "Number: " + Integer.toString(someValue);
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/di/lesson11/app-context-annotation.xml");
		ctx.refresh();
		ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean("confusion");
		System.out.println(cc);
	}

	@Override
	public String toString() {
		return someValue;
	}

}
