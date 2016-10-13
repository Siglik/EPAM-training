/**
 * 
 */
package org.qqq175.airline.airplane;

/**
 * Describes airplane that can transport peoples
 * 
 * @author qqq175
 *
 */
public class Airliner extends Plane {
	/** Max passengers can be boarded */
	private int seatCapacity;

	/**
	 * Constructor
	 */
	public Airliner() {
	}

	/**
	 * @param modelName
	 * @param fuelCompsumtion
	 * @param rangeOfFlight
	 * @param numberOfCrew
	 * @param seatCapacity
	 */
	public Airliner(String modelName, double fuelCompsumtion, int rangeOfFlight, int seatCapacity) {
		super(modelName, fuelCompsumtion, rangeOfFlight);
		this.seatCapacity = seatCapacity;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + seatCapacity;
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airliner other = (Airliner) obj;
		if (seatCapacity != other.seatCapacity)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Airliner [ModelName = ").append(getModelName()).append(", FuelCompsumtion = ").append(getFuelCompsumtion())
				.append(" kg/h, RangeOfFlight = ").append(getRangeOfFlight()).append(" km, seatCapacity = ").append(seatCapacity).append("]");
		return builder.toString();
	}

}