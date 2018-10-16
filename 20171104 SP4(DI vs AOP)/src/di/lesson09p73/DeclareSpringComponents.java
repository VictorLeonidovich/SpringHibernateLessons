package di.lesson09p73;

import org.springframework.context.support.GenericXmlApplicationContext;

import di.lesson09p73.xml.MessageRenderer;

public class DeclareSpringComponents {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		 ctx.load("classpath:META-INF/spring/di/lesson09/prop-xml-style.xml");
		 //ctx.load("classpath:META-INF/spring/di/lesson09/p-xml-style.xml");
		//ctx.load("classpath:META-INF/spring/di/lesson09/annot-style.xml");
		ctx.refresh();
		MessageRenderer messageRenderer = ctx.getBean("renderer", MessageRenderer.class);
		messageRenderer.render();

	}

}
