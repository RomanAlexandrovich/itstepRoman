package org.rest.ws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Currency {
	private int id;//PK id database
	private String numCode;
    private String charCode;
    private int scale;
    private String name;
    public int getId() {
	return id;
	}
	public Currency() {
		
	}
	
	public Currency(String numCode, String charCode, int scale, String name, double rate) {
		super();
		this.numCode = numCode;
		this.charCode = charCode;
		this.scale = scale;
		this.name = name;
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return "Currency [id=" + id + ", numCode=" + numCode + ", charCode=" + charCode + ", scale=" + scale + ", name="
				+ name + ", rate=" + rate + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((charCode == null) ? 0 : charCode.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numCode == null) ? 0 : numCode.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + scale;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		if (charCode == null) {
			if (other.charCode != null)
				return false;
		} else if (!charCode.equals(other.charCode))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numCode == null) {
			if (other.numCode != null)
				return false;
		} else if (!numCode.equals(other.numCode))
			return false;
		if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
			return false;
		if (scale != other.scale)
			return false;
		return true;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumCode() {
		return numCode;
	}
	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	public String getCharCode() {
		return charCode;
	}
	public void setCharCode(String charCode) {
		this.charCode = charCode;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	private double rate;
}
