package com.tcs.ventas.model.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class VentaDetalleDTO {

	private Integer codigoProducto;
	private BigDecimal precioProducto;
	private String nombreProducto;
	private int cantidad;
	private BigDecimal subTotal;

}
