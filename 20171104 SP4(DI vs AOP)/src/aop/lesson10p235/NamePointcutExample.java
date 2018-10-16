package aop.lesson10p235;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class NamePointcutExample {

	public static void main(String[] args) {
		NameBean target = new NameBean();
		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
		advisor.addMethodName("foo");
		advisor.addMethodName("bar");
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		NameBean proxy = (NameBean) pf.getProxy();
		proxy.foo();
		proxy.foo(999);
		proxy.bar();
		proxy.yap();
	}

}
