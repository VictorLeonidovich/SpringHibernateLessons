package validation.lesson08p511;

public enum CustomerType {
	INDIVIDUAL("I"), CORPORATE("C");
	private String code;

	private CustomerType(String code) {
		this.code = code;
	}
	@Override
	public String toString(){
		return this.code;
	}

}
