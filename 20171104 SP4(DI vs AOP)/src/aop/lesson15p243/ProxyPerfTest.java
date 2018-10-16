package aop.lesson15p243;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ProxyPerfTest {

	public static void main(String[] args) {
		SimpleBean target = new DefaultSimpleBean();
		Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(), new NoOpBeforeAdvice());
		runCglibTests(advisor, target);
		runCglibFrozenTests(advisor, target);
		runJdkTests(advisor, target);
	}

	private static void runCglibTests(Advisor advisor, SimpleBean target) {
		ProxyFactory pf = new ProxyFactory();
		pf.setProxyTargetClass(true);
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		SimpleBean proxy = (SimpleBean) pf.getProxy();
		System.out.println("Runing test for standard proxy CGLIB");
		test(proxy);
	}

	private static void runCglibFrozenTests(Advisor advisor, SimpleBean target) {
		ProxyFactory pf = new ProxyFactory();
		pf.setProxyTargetClass(true);
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		pf.setFrozen(true);
		SimpleBean proxy = (SimpleBean) pf.getProxy();
		System.out.println("Runing test for proxy CGLIB with fixing advice chain");
		test(proxy);
	}

	private static void runJdkTests(Advisor advisor, SimpleBean target) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		pf.setInterfaces(new Class[] { SimpleBean.class });
		SimpleBean proxy = (SimpleBean) pf.getProxy();
		System.out.println("Runing test for JDK proxy");
		test(proxy);
	}

	private static void test(SimpleBean bean) {
		long before = 0;
		long after = 0;
		System.out.println("Testing AdvisedMethod");
		before = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			bean.advised();
		}
		after = System.currentTimeMillis();
		System.out.println("Took " + (after - before) + " ms");

		System.out.println("Testing UnadvisedMethod");
		before = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			bean.unadvised();
		}
		after = System.currentTimeMillis();
		System.out.println("Took " + (after - before) + " ms");

		System.out.println("Testing equals() Method");
		before = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			bean.equals(bean);
		}
		after = System.currentTimeMillis();
		System.out.println("Took " + (after - before) + " ms");

		System.out.println("Testing hashcode() Method");
		before = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			bean.hashCode();
		}
		after = System.currentTimeMillis();
		System.out.println("Took " + (after - before) + " ms");

		Advised advised = (Advised) bean;
		System.out.println("Testing Advised.getProxyTargetClass() Method");
		before = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			advised.getTargetClass();
		}
		after = System.currentTimeMillis();
		System.out.println("Took " + (after - before) + " ms");

		System.out.println(">>>\n");
	}

}
