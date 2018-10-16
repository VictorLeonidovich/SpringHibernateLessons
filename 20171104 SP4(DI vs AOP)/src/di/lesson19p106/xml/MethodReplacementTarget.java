package di.lesson19p106.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementTarget {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/di/lesson19/app-context-xml.xml");
		ctx.refresh();
		ReplacementTarget replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget");
		ReplacementTarget standardTarget = (ReplacementTarget) ctx.getBean("standardTarget");
		
		displayInfo(replacementTarget);
		displayInfo(standardTarget);

	}

	private static void displayInfo(ReplacementTarget target) {
		System.out.println(target.formatMessage("Hello, World!"));
		StopWatch watch = new StopWatch();
		watch.start("perfTest");
		for (int i = 0; i < 1000000; i++) {
			String out = target.formatMessage("foo");
		}
		watch.stop();
		System.out.println("1000000 invocations took: " + watch.getTotalTimeMillis() + " ms");

	}

}
