package com.bruno.projects.mccourse.domain;

import javax.persistence.Entity;

import com.bruno.projects.mccourse.domain.enums.PaymentStatus;

@Entity
public class CardPayment extends Payment{
	
	private static final long serialVersionUID = 1L;
	
	private Integer parcelsNumber;
	
	public CardPayment() {}

	public CardPayment(Integer id, PaymentStatus status, Request request, Integer parcelsNumber) {
		super(id, status, request);
		this.parcelsNumber = parcelsNumber;
	}

	public Integer getParcelsNumber() {
		return parcelsNumber;
	}

	public void setParcelsNumber(Integer parcelsNumber) {
		this.parcelsNumber = parcelsNumber;
	}

}
