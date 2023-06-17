package com.ecommerceSprinBootBase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	
	private Logger logg= LoggerFactory.getLogger(AdministradorController.class);

	@GetMapping("")
	public String home() {
		return "administrador/home";
	}
	
    @GetMapping("/producto")
    public String itemdetail() {
        return "pages/product_detail";
    }

    @GetMapping("/usuarios")
    public String users() {
    	return "pages/users";
	}

    @GetMapping("/ordenes")
    public String order() {
        return "pages/order";
    }

    @GetMapping("/detalleorden")
    public String orderdetail() {
        return "pages/order_detail";
    }
}

