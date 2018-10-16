package validation.lesson08p511;

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
