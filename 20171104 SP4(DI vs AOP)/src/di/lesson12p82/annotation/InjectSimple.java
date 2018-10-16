package di.lesson12p82.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;
@Service("injectSimple")
public class InjectSimple {
	@Value("Victor")
	private String name;
	@Value("15")
	private int age;
	@Value("1.7")
	private float height;
	@Value("true")
	private boolean programmer;
	@Value("543")
	private Long ageInSeconds;

	public static void main(String[] args) {
		GenericXmlApplicationContext gtx = new GenericXmlApplicationContext();
		gtx.load("classpath:META-INF/spring/di/lesson12/annot-style.xml");
		gtx.refresh();
		InjectSimple injectSimple = (InjectSimple) gtx.getBean("injectSimple");
		System.out.println(injectSimple);

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}

	public void setAgeInSeconds(Long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}

	@Override
	public String toString() {
		return "InjectSimple [name=" + name + ", age=" + age + ", height=" + height + ", isProgrammer=" + programmer
				+ ", ageInSeconds=" + ageInSeconds + "]";
	}

}
