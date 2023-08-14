package telran.measure;

import java.util.Locale;

public class Length implements Comparable<Length> {

	private float amount;
	private LengthUnit unit;

	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	@Override
	public boolean equals(Object obj) {
		Length length = (Length) obj;
		return amount * unit.getValue() == length.amount * length.unit.getValue();
	}

	public Length convert(LengthUnit l) {
		float newAmount = amount * unit.getValue() / l.getValue();
		return new Length(newAmount, l);
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return unit;
	}

	@Override
	public int compareTo(Length o) {
		int res;
		Length length = (Length) o;

		if (amount * unit.getValue() == length.amount * length.unit.getValue()) {
			res = 0;
		} else {
			res = amount * unit.getValue() > length.amount * length.unit.getValue() ? 1 : -1;
		}

		return res;
	}

	@Override
	public String toString() {
		return String.format(Locale.US, "%.1f%s", amount, unit);
	}

}
