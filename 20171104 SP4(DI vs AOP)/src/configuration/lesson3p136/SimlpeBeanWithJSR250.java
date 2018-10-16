package configuration.lesson3p136;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.GenericXmlApplicationContext;



public class SimlpeBeanWithJSR250 {
	private static final String DEFAULT_NAME = "Luke Skywalker";
	private String name;
	private int age = Integer.MIN_VALUE;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@PostConstruct
	public void init(){
		System.out.println("Initializing bean");
		if (name == null) {
			System.out.println("Using default name");
			name = DEFAULT_NAME;
		}
		if (age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException("You must set the age property of any beans of type " + SimlpeBeanWithJSR250.class);
		}
	}
	@Override
	public String toString() {
		return "SimlpeBean [name=" + name + ", age=" + age + "]";
	}
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/configuration/lesson3/app-context-xml.xml");
		ctx.refresh();
		SimlpeBeanWithJSR250 simpleBean1 = getBean("simpleBean1", ctx);
		SimlpeBeanWithJSR250 simpleBean2 = getBean("simpleBean2", ctx);
		SimlpeBeanWithJSR250 simpleBean3 = getBean("simpleBean3", ctx);

	}
	private static SimlpeBeanWithJSR250 getBean(String beanName, GenericXmlApplicationContext ctx) {
		try {
			SimlpeBeanWithJSR250 bean = (SimlpeBeanWithJSR250) ctx.getBean(beanName);
			System.out.println(bean);
			return bean;
		} catch (BeanCreationException e) {
			System.out.println("An error occured in bean configuration " + e.getMessage());
			return null;
		}
	}

}
