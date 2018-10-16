package configuration.lesson18p183;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileXmlConfigExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		//ctx.getEnvironment().setActiveProfiles("kindergarten"); //or -Dspring.profiles.actve="kindergarten"
		//ctx.getEnvironment().setActiveProfiles("highschool");    //or -Dspring.profiles.actve="highschool"
		ctx.load("classpath:META-INF/spring/configuration/lesson18/*-config.xml");
		ctx.refresh();
		FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
		List<Food> lunchSet = foodProviderService.provideLunchSet();
		for (Food food : lunchSet) {
			System.out.println("Food: " + food);
		}
	}

}
