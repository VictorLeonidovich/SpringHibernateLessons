package di.lesson10p75.xml;



public class ConfigurableMessageProvider implements MessageProvider {
	private String message;
	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}

}
