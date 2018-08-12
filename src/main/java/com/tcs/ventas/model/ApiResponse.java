package com.tcs.ventas.model;

import java.util.List;

import lombok.Data;

@Data // Getter Setter ToString Equals Hashcode
public class ApiResponse<T> {

	public boolean success;
	private String message;
	T payload;
	List<ConstraintViolation> contraintViolations;

}
