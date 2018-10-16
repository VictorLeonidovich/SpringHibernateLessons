package aop.lesson22p273;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/aop/lesson22/app-context.xml");
		ctx.refresh();
		MyBean bean = (MyBean) ctx.getBean("myBean");
		bean.execute();

	}

}
