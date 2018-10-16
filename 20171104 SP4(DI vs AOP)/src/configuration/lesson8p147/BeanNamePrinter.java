package configuration.lesson8p147;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNamePrinter implements BeanNameAware {
	private String beanName;

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public void someOperation() {
		System.out.println("BeanNamePrinter [beanName=" + beanName + "]");
	}

}
