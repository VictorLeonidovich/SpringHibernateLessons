package di.lesson09p73.annotation;

public interface MessageRenderer {
	public void render();

	public void setMessageProvider(MessageProvider provider);

	public MessageProvider getMessageProvider();
}
