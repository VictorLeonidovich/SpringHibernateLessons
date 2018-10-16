package aop.lesson18p259;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {

	public IsModifiedAdvisor() {
		super(new IsModifiedMixin());
	}

}
