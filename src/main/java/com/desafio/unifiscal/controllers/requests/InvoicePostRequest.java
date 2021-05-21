package com.desafio.unifiscal.controllers.requests;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InvoicePostRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String invoiceNumber;
    private String estabilishment;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dateOfIssuance;
    
    private BigDecimal total;
    
	public InvoicePostRequest(String invoiceNumber, String estabilishment, LocalDate dateOfIssuance, BigDecimal total, String name) {
	
		this.invoiceNumber = invoiceNumber;
		this.estabilishment = estabilishment;
		this.dateOfIssuance = dateOfIssuance;
		this.total = total;
		this.setName(name);
	}
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getEstabilishment() {
		return estabilishment;
	}
	public void setEstabilishment(String estabilishment) {
		this.estabilishment = estabilishment;
	}
	public LocalDate getDateOfIssuance() {
		return dateOfIssuance;
	}
	public void setDateOfIssuance(LocalDate dateOfIssuance) {
		this.dateOfIssuance = dateOfIssuance;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfIssuance == null) ? 0 : dateOfIssuance.hashCode());
		result = prime * result + ((estabilishment == null) ? 0 : estabilishment.hashCode());
		result = prime * result + ((invoiceNumber == null) ? 0 : invoiceNumber.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		InvoicePostRequest other = (InvoicePostRequest) obj;
		if (dateOfIssuance == null) {
			if (other.dateOfIssuance != null)
				return false;
		} else if (!dateOfIssuance.equals(other.dateOfIssuance))
			return false;
		if (estabilishment == null) {
			if (other.estabilishment != null)
				return false;
		} else if (!estabilishment.equals(other.estabilishment))
			return false;
		if (invoiceNumber == null) {
			if (other.invoiceNumber != null)
				return false;
		} else if (!invoiceNumber.equals(other.invoiceNumber))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoicePostRequest [invoiceNumber=" + invoiceNumber + ", estabilishment=" + estabilishment
				+ ", dateOfIssuance=" + dateOfIssuance + ", total=" + total + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
    
}
