package telran.measure;

import java.util.Locale;

public class Length implements Comparable<Length> {

	private float amount;
	private LengthUnit unit;
	private float thisLength;

	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
		thisLength = amount * unit.getValue();
	}

	@Override
	public boolean equals(Object obj) {
		return thisLength == getTargetLength(obj);
	}

	@Override
	public int compareTo(Length o) {
		int res;

		if (this.equals(o)) {
			res = 0;
		} else {
			res = thisLength > getTargetLength(o) ? 1 : -1;
		}

		return res;
	}

	private float getTargetLength(Object obj) {
		Length length = (Length) obj;
		return length.amount * length.unit.getValue();

	}

	public Length convert(LengthUnit l) {
		float newAmount = thisLength / l.getValue();
		return new Length(newAmount, l);
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return unit;
	}

	@Override
	public String toString() {
		return String.format(Locale.US, "%.1f%s", amount, unit);
	}

}
