package telran.measure;

public enum LengthUnit {
	MM(1), CM(10), IN(25.4f), FT(304.8f), M(1000), KM(1_000_000);

	private float value;

	LengthUnit(float nMil) {
		value = nMil;
	}

	public float getValue() {
		return value;

	}

	public Length between(Length length1, Length length2) {
		float newValue = Math.abs(length1.getAmount() * length1.getUnit().getValue()
				- length2.getAmount() * length2.getUnit().getValue());
		newValue /= value;
		return new Length(newValue, this);
	}
}
