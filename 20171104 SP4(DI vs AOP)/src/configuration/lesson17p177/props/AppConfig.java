package configuration.lesson17p177.props;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import configuration.lesson17p177.ConfigurableMessageProvider;
import configuration.lesson17p177.MessageProvider;
import configuration.lesson17p177.MessageRenderer;
import configuration.lesson17p177.StandardOutMessageRenderer;

@Configuration
//@ImportResource(value="classpath:META-INF/spring/configuration/lesson17/props/app-context-xml.xml")
@PropertySource(value="classpath:META-INF/spring/configuration/lesson17/props/message.properties")
@ComponentScan(basePackages={"configuration.lesson17p177.props"})
@EnableTransactionManagement
public class AppConfig {
	@Autowired
	Environment env;
	@Bean
	@Lazy(value=true)
	public MessageProvider messageProvider(){
		return new ConfigurableMessageProvider(env.getProperty("message"));
	}
	@Bean(name="messageRenderer")
	@Scope(value="prototype")
	@DependsOn(value="messageProvider")
	public MessageRenderer messageRenderer(){
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(messageProvider());
		return renderer;
		
	}

}
