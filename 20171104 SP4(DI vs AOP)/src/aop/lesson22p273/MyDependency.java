package aop.lesson22p273;

public class MyDependency {
	public void foo(int intValue) {
		System.out.println("foo(int): " + intValue);
	}

	public void bar() {
		System.out.println("bar()");
	}
}
