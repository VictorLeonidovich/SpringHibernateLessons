package di.lesson18p102.xml;

public class StandardLookupDemoBean implements DemoBean {
	private MyHelper myHelper;

	public void setMyHelper(MyHelper myHelper) {
		this.myHelper = myHelper;
	}

	@Override
	public MyHelper getMyHelper() {
		return this.myHelper;
	}

	@Override
	public void someOperation() {
		myHelper.doSomethingHelpful();
	}

}
