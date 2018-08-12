package com.tcs.ventas.controller;

import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.ventas.business.VentaBusiness;
import com.tcs.ventas.model.ApiResponseVenta;
import com.tcs.ventas.model.dto.VentaDTO;

@RestController
@RequestMapping("/venta")
public class VentaController {
   
	private VentaBusiness ventaBusiness;
	RedirectAttributes redirectAttributes;
	public VentaController(VentaBusiness ventaBusiness) {
		this.ventaBusiness = ventaBusiness;
	}
	 
 
	@GetMapping("/{id}")
	public ApiResponseVenta getById(@PathVariable int id) {
		ApiResponseVenta response = new ApiResponseVenta();
		VentaDTO venta = ventaBusiness.findById(id);
		response.setSuccess(true);
		response.setMessage("Ok");
		response.setPayload(Base64.getEncoder().encodeToString(venta.toString().getBytes()));
				
		return response;
	}

	
	
	
}
