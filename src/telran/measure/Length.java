package telran.measure;

import java.util.Locale;
import java.util.Objects;

public class Length implements Comparable<Length> {

	private final float amount;
	private final LengthUnit unit;

	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	/**
	 * equals two Length objects according to LengthUnit 10m == 10000mm
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return compareTo((Length) obj) == 0;
	}

	@Override
	public int compareTo(Length o) {
		return Float.compare(amount, o.convert(unit).amount);
	}

	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit convert(LengthUnit.M)
	 *         returns Length in meters
	 */
	public Length convert(LengthUnit unit) {
		return new Length(amount * this.unit.getValue() / unit.getValue(), unit);
	}

	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20.0M (string expression of Length object containing 20 meters)
	 */
	public String toString() {
		return String.format(Locale.US, "%.1f%s", amount, unit);
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return unit;
	}

}
