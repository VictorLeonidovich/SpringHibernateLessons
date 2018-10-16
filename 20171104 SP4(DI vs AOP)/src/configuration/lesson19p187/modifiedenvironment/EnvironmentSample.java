package configuration.lesson19p187.modifiedenvironment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

public class EnvironmentSample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.refresh();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		Map appMap = new HashMap<>();
		appMap.put("user.home", "application_home");
		propertySources.addFirst(new MapPropertySource("PRoSPring_4_MAP", appMap));
		System.out.println("User.home: " + System.getProperty("user.home"));
		System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));
		System.out.println("User.home: " + env.getProperty("user.home"));
		System.out.println("JAVA_HOME: " + env.getProperty("JAVA_HOME"));

	}

}
