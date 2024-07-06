package com.fjulca.api.empleado.dto;

import java.io.Serializable;

public class AuthResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private String token;
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthResponse(String token) {
		this.token = token;
	}

}
