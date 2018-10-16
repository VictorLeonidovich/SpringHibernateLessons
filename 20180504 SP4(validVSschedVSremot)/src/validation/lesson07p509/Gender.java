package validation.lesson07p509;

public enum Gender {
	MALE("M"), FEMALE("F");
	private String code;

	private Gender(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return this.code;
	}
}
