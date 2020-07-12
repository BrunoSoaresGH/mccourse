package com.bruno.projects.mccourse.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.bruno.projects.mccourse.domain.enums.PaymentStatus;

@Entity
public class BilletPayment extends Payment{
	
	private static final long serialVersionUID = 1L;
	
	private Date dueDate;
	private Date paymentDate;
	
	public BilletPayment() {}

	public BilletPayment(Integer id, PaymentStatus status, Request request, Date dueDate, Date paymentDate) {
		super(id, status, request);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
