package com.desafio.unifiscal.services.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String invoiceNumber;
    private String estabilishment;
    private LocalDate dateOfIssuance;
    private BigDecimal total;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		InvoiceDTO other = (InvoiceDTO) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "InvoiceDTO [id=" + id + ", invoiceNumber=" + invoiceNumber + ", estabilishment=" + estabilishment
				+ ", dateOfIssuance=" + dateOfIssuance + ", total=" + total + "]";
	}

    
    
    
    


}
