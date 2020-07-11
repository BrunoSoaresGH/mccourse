package com.bruno.projects.mccourse.domain.enums;

public enum ClientType {

	FISICALPERSON				(1, "Fisical Person"),
	LEGALPERSON					(2, "Legal Person");
	
	private int code;
	private String description;
	
	private ClientType(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static ClientType toEnum(Integer code) {
		if(code == null) return null;
		
		for(ClientType ct : ClientType.values()) {
			if(code.equals(ct.getCode())) return ct;
		}
		
		throw new IllegalArgumentException("Invalid id " + code);
	}
	
}
