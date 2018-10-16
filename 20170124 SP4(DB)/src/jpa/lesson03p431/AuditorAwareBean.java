package jpa.lesson03p431;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareBean implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return "Vic";
	}

}
