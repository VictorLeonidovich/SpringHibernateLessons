package scheduling.lesson04p527;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TaskExecutorSample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/scheduling/lesson04/app-context.xml");
		ctx.refresh();
		TaskToExecute taskToExecute = ctx.getBean(TaskToExecute.class);
		taskToExecute.executeTask();
	}

}
