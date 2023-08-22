package com.tienda.modelo.dao;

import com.tienda.modelo.Producto;

import javax.persistence.EntityManager;

public class ProductoDao {

    private EntityManager manager;

    public ProductoDao(EntityManager manager) {
        this.manager = manager;
    }

    public void guardar(Producto producto) {
        this.manager.persist(producto);
    }





}
