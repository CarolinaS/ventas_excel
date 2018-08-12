package com.tcs.ventas.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ventas.entity.Producto;
import com.tcs.ventas.mapper.ProductoMapper;
import com.tcs.ventas.model.ProductoDTO;
import com.tcs.ventas.repository.ProductoJpaRepository;

@Service
public class ProductoBusiness {

	@Autowired
	private ProductoJpaRepository productoRepository;

	public List<ProductoDTO> getAll() {
		return productoRepository.findAll()
				.stream()
				.map(ProductoMapper::toDTO)
				.collect(Collectors.toList());
	}

	public ProductoDTO getById(int codigoProducto) {
		return productoRepository
				.findById(codigoProducto)
				.map(ProductoMapper::toDTO)
				.orElse(null);
	}

	public int save(ProductoDTO productoDto) {
		Producto productoCreado = productoRepository.save(ProductoMapper.toEntity(productoDto));
		return productoCreado.getCodigo();
	}

	public int update(ProductoDTO productoDto) {
		return save(productoDto);
	}

	public int remove(int codigoProducto) {
		productoRepository.deleteById(codigoProducto);
		return codigoProducto;
	}

}
