package di.lesson17p97.annotation;

public class FtpArtworkSender implements ArtworkSender {

	@Override
	public String getFriendlyName() {
		return "File Transfer Protocol";
	}

	@Override
	public String getShortName() {
		return "ftp";
	}

	@Override
	public void sendArtWork(String artworkPath, Recipient recipient) {
		System.out.println("Working wit ftp...");
	}

}
