package com.ecommerceSprinBootBase.service;

import java.util.List;
import java.util.Optional;
import com.ecommerceSprinBootBase.model.Producto;

public interface IProductoService {
	
	Producto create(Producto producto);
	Optional <Producto> get(Integer id);
	void update(Producto producto);
	void delete(Integer id);
	List<Producto> findAll();
}
