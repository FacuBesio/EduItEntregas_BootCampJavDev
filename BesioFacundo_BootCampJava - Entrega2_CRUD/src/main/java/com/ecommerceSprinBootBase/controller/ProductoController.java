package com.ecommerceSprinBootBase.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerceSprinBootBase.model.Producto;
import com.ecommerceSprinBootBase.model.Usuario;
import com.ecommerceSprinBootBase.service.IProductoService;
import com.ecommerceSprinBootBase.service.UploadFileService;


@Controller
@RequestMapping("/administrador/productos")
public class ProductoController {
	
	private final Logger LOGGER= LoggerFactory.getLogger(ProductoController.class);
	@Autowired
    private IProductoService productoService;
	@Autowired
    private UploadFileService uploadFileService;

	@GetMapping("")
    public String read(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "pages/product_read";
    }
	

    @GetMapping("/create")
    public String create() {
        return "pages/product_create";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
    	Producto producto = new Producto();
    	Optional <Producto> optionalProducto = productoService.get(id);
    	producto = optionalProducto.get();
    	LOGGER.info("Producto: {}" + producto);
    	model.addAttribute("producto", producto);
        return "pages/product_update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
       	Producto producto = new Producto();
    	producto = productoService.get(id).get();
    	if(!producto.getImagen().equals("default.png")) {
    		List <Producto> listaProductos = productoService.findAll();
    		for(Producto p:listaProductos){
    			if(!(producto.getImagen().equals(p.getImagen())) && !(producto.getId().equals(p.getId()))) {
    				System.out.println("*******************************************************************");
    				System.out.println("DISTINTA IMAGEN - DISTINTO ID - SE PUEDE BORRAR");
    				uploadFileService.deleteImage(producto.getImagen());
    				System.out.println("Se borro la imagen '"+producto.getImagen()+"'");
    				System.out.println("*******************************************************************");
    				break;
    			} else if((producto.getImagen().equals(p.getImagen())) && !(producto.getId().equals(p.getId()))) {	
    				System.out.println("*******************************************************************");
    				System.out.println("IGUAL IMAGEN - DISTINTO ID - NO PUEDE BORRAR");
    				System.out.println("La imagen "+producto.getImagen()+" esta siendo utilazada por mas de un Producto:");
    				System.out.println("'"+p.getNombre()+" "+ p.getImagen()+ "' - '"+producto.getNombre()+" "+ producto.getImagen()+"'");
    				System.out.println("*******************************************************************");
    				break;
    			} else if((producto.getImagen().equals(p.getImagen())) && (producto.getId().equals(p.getId()))) {
    				System.out.println("*******************************************************************");
    				System.out.println("IGUAL IMAGEN - IGUAL ID - SE PUEDE BORRAR");
    				uploadFileService.deleteImage(producto.getImagen());
    				System.out.println("Se borro la imagen '"+producto.getImagen()+"'");
    				System.out.println("*******************************************************************");
    			} 
			};
    	}
    	productoService.delete(id);
    	return "redirect:/administrador/productos";
    }
    
    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img") MultipartFile file) {
    	LOGGER.info("producto: {}" + producto);
    	Usuario usuario = new Usuario(10003, "Nahuel", "Nahuel_1979", "mail@gmail.com","Calle 123", "45651321","ADMIN", "pass");
    	producto.setUsuario(usuario);
    	//if(producto.getId() == null) {
    	if(producto.getImagen() == null) {
    		String imagenName = uploadFileService.saveImage(file);
    		producto.setImagen(imagenName);
    	}
    	productoService.create(producto);
    	return "redirect:/administrador/productos";
    }
    
    @PostMapping("/update")
    public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        Producto productoConImage = productoService.get(producto.getId()).get();
        if(file.isEmpty()){
            producto.setImagen(productoConImage.getImagen());
        }else{
            if(!productoConImage.getImagen().equals("default.png")){
                uploadFileService.deleteImage(productoConImage.getImagen());
        }
            producto.setImagen(uploadFileService.saveImage(file));
        }
        LOGGER.info("Producto: {}", producto);
        productoService.update(producto);
        return "redirect:/administrador/productos";
    }
}