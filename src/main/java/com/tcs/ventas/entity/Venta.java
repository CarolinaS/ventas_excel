package com.tcs.ventas.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "T_VENTA")
public class Venta {

	@Id
	@Column(name = "C_CODIGO_VENTA")
	private Integer codigo;

	@Column(name = "C_CODIGO_CLIENTE")
	private Integer codigoCliente;

	@OneToMany(mappedBy = "venta")
	private List<VentaDetalle> items;

}
