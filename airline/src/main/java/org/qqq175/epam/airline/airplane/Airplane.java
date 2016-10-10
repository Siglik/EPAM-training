/**
 * 
 */
package org.qqq175.epam.airline.airplane;

/**
 * abstract class that describes common airplanes characteristics and methods
 * 
 * @author qqq175
 *
 */
public abstract class Airplane {
	/**
	 * model of airplane
	 */
	private String modelName;
	/**
	 * fuel comsumtinon kg/hour
	 */
	private double fuelCompsumtion;
	/**
	 * max range of flight, km
	 */
	private int rangeOfFlight;

	/**
	 * default constructor
	 */
	public Airplane() {
	}

	/**
	 *
	 * @param modelName
	 * @param fuelCompsumtion
	 * @param rangeOfFlight
	 * @param numberOfCrew
	 */
	public Airplane(String modelName, double fuelCompsumtion, int rangeOfFlight) {
		this.modelName = modelName;
		this.fuelCompsumtion = fuelCompsumtion;
		this.rangeOfFlight = rangeOfFlight;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public double getFuelCompsumtion() {
		return fuelCompsumtion;
	}

	public void setFuelCompsumtion(double fuelCompsumtion) {
		this.fuelCompsumtion = fuelCompsumtion;
	}

	public int getRangeOfFlight() {
		return rangeOfFlight;
	}

	public void setRangeOfFlight(int rangeOfFlight) {
		this.rangeOfFlight = rangeOfFlight;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(fuelCompsumtion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
		temp = Double.doubleToLongBits(rangeOfFlight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airplane other = (Airplane) obj;
		if (Double.doubleToLongBits(fuelCompsumtion) != Double.doubleToLongBits(other.fuelCompsumtion))
			return false;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		if (Double.doubleToLongBits(rangeOfFlight) != Double.doubleToLongBits(other.rangeOfFlight))
			return false;
		return true;
	}
}
