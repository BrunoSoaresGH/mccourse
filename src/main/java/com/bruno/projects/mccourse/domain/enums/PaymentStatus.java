package com.bruno.projects.mccourse.domain.enums;

public enum PaymentStatus {
	
	PAID 				(1, "Paid"),
	PENDENT				(2, "Pendent"),
	CANCELED			(3, "Canceled");
	
	private int code;
	private String description;
	
	private PaymentStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static PaymentStatus toEnum(Integer code) {
		if(code == null) return null;
		
		for(PaymentStatus ps: PaymentStatus.values()) {
			if(code.equals(ps.getCode())) return ps;
		}
		
		throw new IllegalArgumentException("Invalid id " + code);
	}
	
}
