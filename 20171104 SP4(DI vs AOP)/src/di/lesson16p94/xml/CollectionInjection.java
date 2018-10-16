package di.lesson16p94.xml;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionInjection {
	private Map<String, Object> map;
	private Properties props;
	private Set set;
	private List list;

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/di/lesson16/prop-xml-style.xml");
		ctx.refresh();
		CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
		instance.displayInfo();

	}
	
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public void setList(List list) {
		this.list = list;
	}
	private void displayInfo() {
		System.out.println("Map contents:\n");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
		System.out.println("\nProperties contents:\n");
		for (Map.Entry<Object, Object> entry : props.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
		System.out.println("\nSet contents:\n");
		for (Object obj : set) {
			System.out.println("Value: " + obj);
		}
		System.out.println("\nList contents:\n");
		for (Object obj : list) {
			System.out.println("Value: " + obj);
		}
	}

}
