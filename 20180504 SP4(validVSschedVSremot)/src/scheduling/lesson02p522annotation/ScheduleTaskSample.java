package scheduling.lesson02p522annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ScheduleTaskSample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/scheduling/lesson02/task-namespace-app-context.xml");
		ctx.refresh();
		while (true) {

		}
	}

}
