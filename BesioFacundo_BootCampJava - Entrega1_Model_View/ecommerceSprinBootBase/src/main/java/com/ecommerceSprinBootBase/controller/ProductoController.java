package com.ecommerceSprinBootBase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/productos")

public class ProductoController {
	
	private Logger logg= LoggerFactory.getLogger(AdministradorController.class);

	@GetMapping("")
	public String read() {
		return "components/Item/itemlist";
	}
	
	
	@GetMapping("/create")
	public String create() {
		return "components/Item/itemcreate";
	}
	
	@GetMapping("/update")
	public String update() {
		return "components/Item/itemedit";
	}
	
	
	@GetMapping("/edit")
	public String editadmin() {
		return "components/Item/itemlist";
	}
	
}
