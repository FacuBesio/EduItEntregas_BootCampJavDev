package com.ecommerceSprinBootBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceSprinBootBase.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {

}
