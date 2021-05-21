package com.desafio.unifiscal.services.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import com.desafio.unifiscal.controllers.requests.InvoicePostRequest;
import com.desafio.unifiscal.controllers.requests.InvoicePutRequest;
import com.desafio.unifiscal.domain.Invoice;
import com.desafio.unifiscal.domain.Tax;


public class InvoiceDTO  extends RepresentationModel<InvoiceDTO> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
    private String invoiceNumber;
    private String estabilishment;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfIssuance;
    private BigDecimal total;
    private List<Tax> taxes = new ArrayList<Tax>();
    
    public InvoiceDTO() {}
    
    public InvoiceDTO(Invoice invoice) {
		this.id = invoice.getId();
		this.invoiceNumber = invoice.getInvoiceNumber();
		this.estabilishment = invoice.getEstabilishment();
		this.dateOfIssuance = invoice.getDateOfIssuance();
		this.total = invoice.getTotal();
		this.taxes = invoice.getTaxes();
		this.name = invoice.getName();
	}
    
    public InvoiceDTO(InvoicePutRequest invoice) {
  		this.id = invoice.getId();
  		this.invoiceNumber = invoice.getInvoiceNumber();
  		this.estabilishment = invoice.getEstabilishment();
  		this.dateOfIssuance = invoice.getDateOfIssuance();
  		this.total = invoice.getTotal();
  		this.name = invoice.getName();
  	}
    
    public InvoiceDTO(InvoicePostRequest invoice) {
    		this.invoiceNumber = invoice.getInvoiceNumber();
    		this.estabilishment = invoice.getEstabilishment();
    		this.dateOfIssuance = invoice.getDateOfIssuance();
    		this.total = invoice.getTotal();
    		this.name = invoice.getName();
    	}
    
	public InvoiceDTO(Long id, String invoiceNumber, String estabilishment, LocalDate dateOfIssuance,
			BigDecimal total) {
	
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.estabilishment = estabilishment;
		this.dateOfIssuance = dateOfIssuance;
		this.total = total;
	}
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

	public List<Tax> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<Tax> list) {
		this.taxes = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
