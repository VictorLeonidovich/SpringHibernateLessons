package aop.lesson25p282;

public aspect MessageWrapper {
	private String prefix;
	private String suffix;

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	pointcut doWriting() :
	execution(*
			aop.lesson25p282.MessageWriter.writeMessage());

	before() : doWriting() {
		System.out.println(prefix);
	}

	after() : doWriting() {
		System.out.println(suffix);
	}
}
