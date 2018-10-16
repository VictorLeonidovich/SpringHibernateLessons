package di.lesson20p111.xml;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNameAliasing {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/di/lesson20/app-context-xml.xml");
		ctx.refresh();
		String string1 = (String) ctx.getBean("name1");
		String string2 = (String) ctx.getBean("name2");
		String string3 = (String) ctx.getBean("name3");
		String string4 = (String) ctx.getBean("name4");
		String string5 = (String) ctx.getBean("name5");
		String string6 = (String) ctx.getBean("name6");
		System.out.println(string1 == string2);
		System.out.println(string2 == string3);
		System.out.println(string3 == string4);
		System.out.println(string4 == string5);
		System.out.println(string5 == string6);
		System.out.println(Arrays.deepToString(ctx.getAliases("name1")));

	}

}
