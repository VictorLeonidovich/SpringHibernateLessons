package di.lesson08p69.annotation;

import org.springframework.stereotype.Service;

@Service("provider")
public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello World!";
	}

}
