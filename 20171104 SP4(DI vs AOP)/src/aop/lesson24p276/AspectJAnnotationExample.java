package aop.lesson24p276;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/aop/lesson24/app-context.xml");
		ctx.refresh();
		MyBean bean = (MyBean) ctx.getBean("myBean");
		bean.execute();

	}

}
