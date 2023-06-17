package com.ecommerceSprinBootBase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private Logger logg= LoggerFactory.getLogger(UsuarioController.class);

	@GetMapping("")
	public String home() {
		return "usuarios/home";
	}
	
	@GetMapping("/registro")
    public String register() {
        return "pages/register";
    }
	
	@GetMapping("/login")
    public String login() {
        return "pages/login";
    }
	
	@GetMapping("/compras")
    public String shopping() {
        return "pages/shopping";
    }
	
	@GetMapping("/detallecompra")
    public String shoppingdetail() {
        return "pages/shopping_detail";
    }
	
	@GetMapping("/cerrar")
    public String closesession() {
        return "redirect:/";
    }
	
}