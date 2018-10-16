package di.lesson08p69.annotation;

public interface MessageRenderer {
	public void render();

	public void setMessageProvider(MessageProvider provider);

	public MessageProvider getMessageProvider();
}
