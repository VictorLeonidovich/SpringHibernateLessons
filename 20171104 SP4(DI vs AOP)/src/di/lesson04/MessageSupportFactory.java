package di.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MessageSupportFactory {
	private static MessageSupportFactory instance;
	private Properties props;
	private MessageRenderer renderer;
	private MessageProvider provider;
	
	private MessageSupportFactory() {
		props = new Properties();
		try {
			props.load(new FileInputStream("src/META-INF/spring/di/lesson04/msf.properties"));
			String rendererClass = props.getProperty("renderer.class");
			String providerClass = props.getProperty("provider.class");
			
			renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
			provider = (MessageProvider) Class.forName(providerClass).newInstance();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	static{
		instance = new MessageSupportFactory();
	}
	public static MessageSupportFactory getInstance() {
		return instance;
	}
	public MessageRenderer getMessageRenderer() {
		return renderer;
	}
	public MessageProvider getMessageProvider() {
		return provider;
	}
	
	

}
