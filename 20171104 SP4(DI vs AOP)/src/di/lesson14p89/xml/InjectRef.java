package di.lesson14p89.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectRef {
	private Oracle oracle;

	public void setOracle(Oracle oracle) {
		this.oracle = oracle;
	}


	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/di/lesson14/prop-xml-style.xml");
		ctx.refresh();
		InjectRef injectRef = (InjectRef) ctx.getBean("injectRef");
		System.out.println(injectRef);

	}


	@Override
	public String toString() {
		return oracle.defineMeaningOfLife();
	}
	

}
