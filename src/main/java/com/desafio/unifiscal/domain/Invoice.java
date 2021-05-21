package com.desafio.unifiscal.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.desafio.unifiscal.services.dto.InvoiceDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String invoiceNumber;
	private String name;

	private String estabilishment;

	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dateOfIssuance;

	private BigDecimal total;

	@OneToMany(cascade = CascadeType.ALL )
	@JoinColumn(name="invoice_id")
	private List<Tax> taxes = new ArrayList<Tax>();
	
	public Invoice() {
	}

	public Invoice(Long id, String invoiceNumber, String estabilishment, LocalDate dateOfIssuance, BigDecimal total, String name) {
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.estabilishment = estabilishment;
		this.dateOfIssuance = dateOfIssuance;
		this.total = total;
		this.name = name;
	}

	public Invoice(InvoiceDTO dto) {
		this.id = dto.getId();
		this.invoiceNumber = dto.getInvoiceNumber();
		this.estabilishment = dto.getEstabilishment();
		this.dateOfIssuance = dto.getDateOfIssuance();
		this.total = dto.getTotal();
		this.taxes = dto.getTaxes();
		this.name = dto.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Tax> getTaxes() {
		return taxes;
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
		Invoice other = (Invoice) obj;
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
		return "Invoice [id=" + id + ", invoiceNumber=" + invoiceNumber + ", estabilishment=" + estabilishment
				+ ", dateOfIssuance=" + dateOfIssuance + ", total=" + total + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
