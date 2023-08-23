package com.tienda.modelo.dao;

import com.tienda.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private final EntityManager manager;

    public CategoriaDao(EntityManager manager) {
        this.manager = manager;
    }

    public void guardar(Categoria categoria) {
        this.manager.persist(categoria);
    }

    public void actualizar(Categoria categoria) {
        this.manager.merge(categoria);
    }

    public void remover(Categoria categoria) {
        categoria = this.manager.merge(categoria);
        this.manager.remove(categoria);
    }

}
