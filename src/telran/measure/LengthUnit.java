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

	public Length between(Length l1, Length l2) {
		Length length1 = l1.convert(this);
		Length length2 = l2.convert(this);
		return new Length(length2.getAmount() - length1.getAmount(), this);
	}
}
