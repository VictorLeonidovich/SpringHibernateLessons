package aop.lesson08p229;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> cls) {
		return ("foo".equals(method.getName()));
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {

			@Override
			public boolean matches(Class<?> cls) {
				return (cls == BeanOne.class);
			}
		};
	}

}
