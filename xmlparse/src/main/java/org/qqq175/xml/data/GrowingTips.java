//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.22 at 03:02:30 AM MSK 
//

package org.qqq175.xml.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="temperature" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minExclusive value="0"/>
 *             &lt;maxExclusive value="100"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="watering" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minExclusive value="0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="heliophilous" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "growingTips")
public class GrowingTips {

	@XmlAttribute(name = "temperature", required = true)
	private int temperature;
	@XmlAttribute(name = "watering", required = true)
	private int watering;
	@XmlAttribute(name = "heliophilous", required = true)
	private boolean heliophilous;

	/**
	 * Gets the value of the temperature property.
	 * 
	 */
	public int getTemperature() {
		return temperature;
	}

	/**
	 * Sets the value of the temperature property.
	 * 
	 */
	public void setTemperature(int value) {
		this.temperature = value;
	}

	/**
	 * Gets the value of the watering property.
	 * 
	 */
	public int getWatering() {
		return watering;
	}

	/**
	 * Sets the value of the watering property.
	 * 
	 */
	public void setWatering(int value) {
		this.watering = value;
	}

	/**
	 * Gets the value of the heliophilous property.
	 * 
	 */
	public boolean isHeliophilous() {
		return heliophilous;
	}

	/**
	 * Sets the value of the heliophilous property.
	 * 
	 */
	public void setHeliophilous(boolean value) {
		this.heliophilous = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (heliophilous ? 1231 : 1237);
		result = prime * result + temperature;
		result = prime * result + watering;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		GrowingTips other = (GrowingTips) obj;
		if (heliophilous != other.heliophilous)
			return false;
		if (temperature != other.temperature)
			return false;
		if (watering != other.watering)
			return false;
		return true;
	}

}