package configuration.lesson4p139;

import java.io.File;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBean implements InitializingBean {
	private File file;
	private String filePath;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing bean");
		if (filePath == null) {
			throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBean.class);
		}
		this.file = new File(filePath);
		this.file.createNewFile();
		System.out.println("File exists: " + file.exists());
	}

	public void destroy() {
		System.out.println("Destroying bean");
		if (!file.delete()) {
			System.err.println("ERROR: failed to delete file.");
		}
		System.out.println("File exists: " + file.exists());
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/configuration/lesson4/app-context-xml.xml");
		ctx.refresh();
		DestructiveBean destructiveBean = (DestructiveBean) ctx.getBean("destructiveBean");
		System.out.println("Calling destroy");
		ctx.destroy();
		System.out.println("Called destroy");
	}

}
