package di.lesson18p102.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/di/lesson18/app-context-xml.xml");
		ctx.refresh();
		DemoBean abstractBean = (DemoBean) ctx.getBean("abstractLookupBean");
		DemoBean standardBean = (DemoBean) ctx.getBean("standardLookupBean");
		
		displayInfo(abstractBean);
		displayInfo(standardBean);

	}

	private static void displayInfo(DemoBean bean) {
		MyHelper helper1 = bean.getMyHelper();
		MyHelper helper2 = bean.getMyHelper();
		System.out.println("Helper instance the same?: " + (helper1 == helper2));
		StopWatch watch = new StopWatch();
		watch.start("lookupDemo");
		for (int i = 0; i < 100000; i++) {
			MyHelper helper = bean.getMyHelper();
			helper.doSomethingHelpful();
		}
		watch.stop();
		System.out.println("100000 gets took " + watch.getTotalTimeMillis() + " ms");

	}

}
