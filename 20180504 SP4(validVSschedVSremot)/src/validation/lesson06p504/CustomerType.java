package validation.lesson06p504;

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
