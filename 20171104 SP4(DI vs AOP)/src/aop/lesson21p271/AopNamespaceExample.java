package aop.lesson21p271;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/aop/lesson21/app-context.xml");
		ctx.refresh();
		MyBean bean = (MyBean) ctx.getBean("myBean");
		bean.execute();

	}

}
