package di.lesson13p84.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;
@Service("injectSimpleSpel")
public class InjectSimpleSpel {
	@Value("#{injectSimpleConfig.name}")
	private String name;
	@Value("#{injectSimpleConfig.age}")
	private int age;
	@Value("#{injectSimpleConfig.height}")
	private float height;
	@Value("#{injectSimpleConfig.programmer}")
	private boolean programmer;
	@Value("#{injectSimpleConfig.ageInSeconds}")
	private Long ageInSeconds;

	public static void main(String[] args) {
		GenericXmlApplicationContext gtx = new GenericXmlApplicationContext();
		gtx.load("classpath:META-INF/spring/di/lesson13/annot-style.xml");
		gtx.refresh();
		InjectSimpleSpel injectSimpleSpel = (InjectSimpleSpel) gtx.getBean("injectSimpleSpel");
		System.out.println(injectSimpleSpel);

	}


	@Override
	public String toString() {
		return "InjectSimple [name=" + name + ", age=" + age + ", height=" + height + ", isProgrammer=" + programmer
				+ ", ageInSeconds=" + ageInSeconds + "]";
	}

}
