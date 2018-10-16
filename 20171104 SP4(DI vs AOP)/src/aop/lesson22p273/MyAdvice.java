package aop.lesson22p273;

import org.aspectj.lang.JoinPoint;

public class MyAdvice {

	public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue) {
		if (intValue != 100) {
			System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName() + " "
					+ joinPoint.getSignature().getName());
		}
		
	}

}
