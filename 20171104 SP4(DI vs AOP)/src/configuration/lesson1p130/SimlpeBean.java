package configuration.lesson1p130;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.GenericXmlApplicationContext;



public class SimlpeBean {
	private static final String DEFAULT_NAME = "Luke Skywalker";
	private String name;
	private int age = Integer.MIN_VALUE;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void init(){
		System.out.println("Initializing bean");
		if (name == null) {
			System.out.println("Using default name");
			name = DEFAULT_NAME;
		}
		if (age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("You must set the age property of any beans of type " + SimlpeBean.class);
		}
	}
	@Override
	public String toString() {
		return "SimlpeBean [name=" + name + ", age=" + age + "]";
	}
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/configuration/lesson1/app-context-xml.xml");
		ctx.refresh();
		SimlpeBean simpleBean1 = getBean("simpleBean1", ctx);
		SimlpeBean simpleBean2 = getBean("simpleBean2", ctx);
		SimlpeBean simpleBean3 = getBean("simpleBean3", ctx);

	}
	private static SimlpeBean getBean(String beanName, GenericXmlApplicationContext ctx) {
		try {
			SimlpeBean bean = (SimlpeBean) ctx.getBean(beanName);
			System.out.println(bean);
			return bean;
		} catch (BeanCreationException e) {
			System.out.println("An error occured in bean configuration " + e.getMessage());
			return null;
		}
	}

}
