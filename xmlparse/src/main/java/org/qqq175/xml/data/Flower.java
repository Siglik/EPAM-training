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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java class for Flower complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="Flower">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="soil">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="подзолистая"/>
 *               &lt;enumeration value="грунтовая"/>
 *               &lt;enumeration value="дерново-подзолистая"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{}visualParameters"/>
 *         &lt;element ref="{}growingTips"/>
 *         &lt;element name="multiplying">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="черенок"/>
 *               &lt;enumeration value="семена"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *             &lt;pattern value="[0-9]{9}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="origin" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Flower", propOrder = { "soil", "visualParameters", "growingTips", "multiplying" })
public class Flower {

	@XmlElement(required = true)
	private String soil;
	@XmlElement(required = true)
	private VisualParameters visualParameters;
	@XmlElement(required = true)
	private GrowingTips growingTips;
	@XmlElement(required = true)
	private String multiplying;
	@XmlAttribute(name = "id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	private String id;
	@XmlAttribute(name = "name", required = true)
	private String name;
	@XmlAttribute(name = "origin", required = true)
	private String origin;

	/**
	 * Gets the value of the soil property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSoil() {
		return soil;
	}

	/**
	 * Sets the value of the soil property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSoil(String value) {
		this.soil = value;
	}

	/**
	 * Gets the value of the visualParameters property.
	 * 
	 * @return possible object is {@link VisualParameters }
	 * 
	 */
	public VisualParameters getVisualParameters() {
		return visualParameters;
	}

	/**
	 * Sets the value of the visualParameters property.
	 * 
	 * @param value
	 *            allowed object is {@link VisualParameters }
	 * 
	 */
	public void setVisualParameters(VisualParameters value) {
		this.visualParameters = value;
	}

	/**
	 * Gets the value of the growingTips property.
	 * 
	 * @return possible object is {@link GrowingTips }
	 * 
	 */
	public GrowingTips getGrowingTips() {
		return growingTips;
	}

	/**
	 * Sets the value of the growingTips property.
	 * 
	 * @param value
	 *            allowed object is {@link GrowingTips }
	 * 
	 */
	public void setGrowingTips(GrowingTips value) {
		this.growingTips = value;
	}

	/**
	 * Gets the value of the multiplying property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMultiplying() {
		return multiplying;
	}

	/**
	 * Sets the value of the multiplying property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMultiplying(String value) {
		this.multiplying = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the origin property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Sets the value of the origin property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrigin(String value) {
		this.origin = value;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("ID: ").append(this.id);
		result.append("\nНаимненование: ").append(this.name);
		result.append("\nПочва для посадки: ").append(this.soil);
		result.append("\nМесто происхождения: ").append(this.origin);

		result.append("\nВнешние параметры");
		result.append("\n\tЦвет стебля: ").append(this.visualParameters.getStemColor());
		if (this.visualParameters.getLeafColor() != null) {
			result.append("\n\tЦвет листьев: ").append(this.visualParameters.getLeafColor());
		}
		if (this.visualParameters.getFlowerColor() != null) {
			result.append("\n\tЦвет цветка: ").append(this.visualParameters.getFlowerColor());
		}
		result.append("\n\tСредний размер растения: ").append(this.visualParameters.getSize()).append(" см");

		result.append("\nПредпочтительные  условия произрастания");
		result.append("\n\tТемпература: ").append(this.growingTips.getTemperature()).append(" °C");
		result.append("\n\tПолив: ").append(this.growingTips.getWatering()).append(" мл");
		result.append("\n\tСветолюбив: ").append(this.growingTips.isHeliophilous());

		result.append("\nРазмножение: ").append(this.multiplying).append("\n");
		return result.toString();
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
		result = prime * result + ((growingTips == null) ? 0 : growingTips.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((multiplying == null) ? 0 : multiplying.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((soil == null) ? 0 : soil.hashCode());
		result = prime * result + ((visualParameters == null) ? 0 : visualParameters.hashCode());
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
		Flower other = (Flower) obj;
		if (growingTips == null) {
			if (other.growingTips != null)
				return false;
		} else if (!growingTips.equals(other.growingTips))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (multiplying == null) {
			if (other.multiplying != null)
				return false;
		} else if (!multiplying.equals(other.multiplying))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (soil == null) {
			if (other.soil != null)
				return false;
		} else if (!soil.equals(other.soil))
			return false;
		if (visualParameters == null) {
			if (other.visualParameters != null)
				return false;
		} else if (!visualParameters.equals(other.visualParameters))
			return false;
		return true;
	}
}