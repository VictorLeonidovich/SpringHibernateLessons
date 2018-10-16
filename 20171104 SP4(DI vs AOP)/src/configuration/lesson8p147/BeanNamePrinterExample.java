package configuration.lesson8p147;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNamePrinterExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/configuration/lesson8/app-context-xml.xml");
		ctx.refresh();
		BeanNamePrinter beanNamePrinter = (BeanNamePrinter) ctx.getBean("beanNamePrinter");
		beanNamePrinter.someOperation();
	}

}
