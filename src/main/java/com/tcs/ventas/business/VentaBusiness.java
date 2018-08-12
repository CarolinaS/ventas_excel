package com.tcs.ventas.business;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tcs.ventas.entity.Venta;
import com.tcs.ventas.model.dto.VentaDTO;
import com.tcs.ventas.model.dto.VentaDetalleDTO;
import com.tcs.ventas.repository.VentaRepository;

@Service
public class VentaBusiness {

	private VentaRepository ventaRepository;
	public Model model;

	public VentaBusiness(VentaRepository ventaRepository) {
		this.ventaRepository = ventaRepository;
	}

	public VentaDTO findById(Integer id) {
		Optional<Venta> optVenta = ventaRepository.findById(id);
		if (!optVenta.isPresent()) {
			return null;
		}
		Venta venta = optVenta.get();

		VentaDTO ventaDto = new VentaDTO();
		ventaDto.setCodigoVenta(venta.getCodigo());

		List<VentaDetalleDTO> items = venta.getItems()
			.stream()
			.map(ventaDetalleEntity -> {
				VentaDetalleDTO dto = new VentaDetalleDTO();
				dto.setCodigoProducto(ventaDetalleEntity.getProducto().getCodigo());
				dto.setCantidad(ventaDetalleEntity.getCantidad());
				dto.setPrecioProducto(ventaDetalleEntity.getProducto().getPrecio());
				dto.setNombreProducto(ventaDetalleEntity.getProducto().getNombre());
				
				Integer cantidad = ventaDetalleEntity.getCantidad();
				BigDecimal precio = ventaDetalleEntity.getProducto().getPrecio();
				BigDecimal subTotal = precio.multiply(new BigDecimal(cantidad));
				dto.setSubTotal(subTotal);
				return dto;
			})
			.collect(Collectors.toList());
		ventaDto.setItems(items);

		return ventaDto;
	}
      
	
	
}
