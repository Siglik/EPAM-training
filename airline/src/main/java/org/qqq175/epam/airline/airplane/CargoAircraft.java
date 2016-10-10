package org.qqq175.epam.airline.airplane;

public class CargoAircraft extends Airplane {
	/** Max pay load, tonn */
	private int payLoad;
	/** Max pay capacity, m3 */
	private int cargoCapacity;

	/**
	 * Describes airplane that can transport cargo
	 * 
	 * @author qqq175
	 */
	public CargoAircraft() {
	}

	/**
	 * @param modelName
	 * @param fuelCompsumtion
	 * @param rangeOfFlight
	 * @param numberOfCrew
	 * @param payLoad
	 * @param cargoCapacity
	 */
	public CargoAircraft(String modelName, double fuelCompsumtion, int rangeOfFlight, int payLoad, int cargoCapacity) {
		super(modelName, fuelCompsumtion, rangeOfFlight);
		this.payLoad = payLoad;
		this.cargoCapacity = cargoCapacity;
	}

	public int getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(int payLoad) {
		this.payLoad = payLoad;
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public void setCargoCapacity(int cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cargoCapacity;
		result = prime * result + payLoad;
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
		CargoAircraft other = (CargoAircraft) obj;
		if (cargoCapacity != other.cargoCapacity)
			return false;
		if (payLoad != other.payLoad)
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
		builder.append("CargoAircraft [ModelName = ").append(getModelName()).append(", FuelCompsumtion = ").append(getFuelCompsumtion())
				.append(" kg/h , RangeOfFlight = ").append(getRangeOfFlight()).append(" km, payLoad = ").append(payLoad)
				.append(" tonn, cargoCapacity = ").append(cargoCapacity).append(" m3]");
		return builder.toString();
	}
}
