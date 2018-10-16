package aop.lesson15p243;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class TestPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> cls) {
		return ("advised".equals(method.getName()));
	}

}
