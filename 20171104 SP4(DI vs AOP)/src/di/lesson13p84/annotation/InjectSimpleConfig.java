package di.lesson13p84.annotation;

import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {
	private String name = "Vict";
	private int age = 9;
	private float height = 0.9f;
	private boolean programmer = false;
	private Long ageInSeconds = 1111111L;
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public float getHeight() {
		return height;
	}
	public boolean getProgrammer() {
		return programmer;
	}
	public Long getAgeInSeconds() {
		return ageInSeconds;
	}
	

}
