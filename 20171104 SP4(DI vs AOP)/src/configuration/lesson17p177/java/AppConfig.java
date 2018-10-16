package configuration.lesson17p177.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import configuration.lesson17p177.ConfigurableMessageProvider;
import configuration.lesson17p177.MessageProvider;
import configuration.lesson17p177.MessageRenderer;
import configuration.lesson17p177.StandardOutMessageRenderer;

@Configuration
public class AppConfig {
	@Bean
	public MessageProvider messageProvider(){
		return new ConfigurableMessageProvider();
	}
	@Bean
	public MessageRenderer messageRenderer(){
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(messageProvider());
		return renderer;
		
	}

}
