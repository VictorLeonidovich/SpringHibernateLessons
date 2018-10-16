package aop.lesson20p269;

import org.springframework.context.support.GenericXmlApplicationContext;

public class IntroductionConfigExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/aop/lesson20/app-context.xml");
		ctx.refresh();
		TargetBean bean = (TargetBean) ctx.getBean("bean");
		IsModified mod = (IsModified) bean;
		System.out.println("Is targetBean?: " + (bean instanceof TargetBean));
		System.out.println("Is IsModified?: " + (bean instanceof IsModified));
		System.out.println("Has been modified?: " + (mod.isModified()));
		bean.setName("Chris Schaefer");
		System.out.println("Has been modified?: " + (mod.isModified()));
		bean.setName("Chris Schaefer");
		System.out.println("Has been modified?: " + (mod.isModified()));

	}

}
