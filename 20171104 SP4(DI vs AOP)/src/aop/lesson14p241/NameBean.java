package aop.lesson14p241;

public class NameBean {
	public void foo() {
		System.out.println("foo");
	}

	public void foo(int x) {
		System.out.println("foo " + x);
	}

	public void bar() {
		System.out.println("bar");
	}

	public void yap() {
		System.out.println("yap");
	}
}
