package aop.lesson19p265;

public class MyBean {
	private MyDependency dep;

	public void execute() {
		dep.foo();
		dep.bar();
	}

	public void setDep(MyDependency dep) {
		this.dep = dep;
	}

}
