package com.tcs.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.ventas.business.VentaBusiness;

@Controller
public class ExportController {

	@Autowired
	private VentaBusiness ventas;

	@GetMapping("venta/{id}/download")
	public String download(Model model, @PathVariable Integer id) {

		model.addAttribute("venta", ventas.findById(id));
		return "";
	}

}
