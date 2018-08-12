package com.tcs.ventas.model;

import java.util.List;

import lombok.Data;

@Data // Getter Setter ToString Equals Hashcode
public class ApiResponseVenta {

	public boolean success;
	private String message;
	private String payload;
	List<ConstraintViolation> contraintViolations;

}
