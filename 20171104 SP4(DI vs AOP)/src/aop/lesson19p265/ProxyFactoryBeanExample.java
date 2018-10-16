package aop.lesson19p265;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProxyFactoryBeanExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/aop/lesson19/app-context.xml");
		ctx.refresh();
		MyBean bean1 = (MyBean) ctx.getBean("myBean1");
		MyBean bean2 = (MyBean) ctx.getBean("myBean2");
		System.out.println("Bean 1");
		bean1.execute();
		System.out.println("Bean 2");
		bean2.execute();
	}

}
