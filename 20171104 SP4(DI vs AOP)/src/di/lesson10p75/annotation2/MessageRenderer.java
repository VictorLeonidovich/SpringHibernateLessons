package di.lesson10p75.annotation2;

public interface MessageRenderer {
	public void render();

	public void setMessageProvider(MessageProvider provider);

	public MessageProvider getMessageProvider();
}
