package di.lesson09p73.xml;

public interface MessageRenderer {
	public void render();

	public void setMessageProvider(MessageProvider provider);

	public MessageProvider getMessageProvider();
}
