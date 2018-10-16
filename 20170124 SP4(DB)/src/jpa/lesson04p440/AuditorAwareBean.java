package jpa.lesson04p440;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareBean implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return "Vic";
	}

}
