package com.tcs.ventas.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class VentaDTO {

	private Integer codigoVenta;
	private List<VentaDetalleDTO> items;

}
