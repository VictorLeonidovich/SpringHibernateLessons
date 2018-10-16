package di.lesson18p102.xml;

public abstract class AbstractLookupDemoBean implements DemoBean {
	private MyHelper myHelper;

	@Override
	public void someOperation() {
		myHelper.doSomethingHelpful();
	}

}
