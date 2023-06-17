package com.ecommerceSprinBootBase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceSprinBootBase.model.Producto;
import com.ecommerceSprinBootBase.repository.IProductoRepository;


@Service
public class ProductoImplement implements IProductoService{

	@Autowired
	private IProductoRepository productoRepository;
	
	
	@Override
	public Producto create(Producto producto) {
		productoRepository.save(producto);
		return null;
	}

	@Override
	public Optional<Producto> get(Integer id) {
		return productoRepository.findById(id);
	}

	@Override
	public void update(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public void delete(Integer id) {
		productoRepository.deleteById(id);
	}

	@Override
    public List<Producto> findAll() { 
		return productoRepository.findAll();
	}

	
}
