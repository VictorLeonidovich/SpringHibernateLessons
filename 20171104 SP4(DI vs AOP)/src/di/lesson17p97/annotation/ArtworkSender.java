package di.lesson17p97.annotation;

public interface ArtworkSender {
	public void sendArtWork(String artworkPath, Recipient recipient);
	public String getFriendlyName();
	public String getShortName();

}
