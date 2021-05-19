package com.desafio.unifiscal.domain;

import java.io.Serializable;

import com.desafio.unifiscal.domain.enums.TypeOfTaxes;

public class Tax implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private TypeOfTaxes typeOfTax;
	private String name;
	private double percent;
	
	public Tax(TypeOfTaxes typeOfTax, String name, double percent) {
		super();
		this.typeOfTax = typeOfTax;
		this.name = name;
		this.percent = percent;
	}
	
	public TypeOfTaxes getTypeOfTax() {
		return typeOfTax;
	}
	public void setTypeOfTax(TypeOfTaxes typeOfTax) {
		this.typeOfTax = typeOfTax;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(percent);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((typeOfTax == null) ? 0 : typeOfTax.hashCode());
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
		Tax other = (Tax) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(percent) != Double.doubleToLongBits(other.percent))
			return false;
		if (typeOfTax != other.typeOfTax)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tax [typeOfTax=" + typeOfTax + ", name=" + name + ", percent=" + percent + "]";
	}
	
	

}
