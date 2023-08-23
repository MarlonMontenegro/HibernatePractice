package com.tienda.modelo.dao;

import com.tienda.modelo.Producto;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductoDao {

    private EntityManager manager;

    public ProductoDao(EntityManager manager) {
        this.manager = manager;
    }

    public void guardar(Producto producto) {
        this.manager.persist(producto);
    }

    public Producto consultaPorId(long id) {
        return manager.find(Producto.class, id);
    }

    public List<Producto> consultarTodos() {

        String jpql = "SELECT P FROM Producto AS P";
        return manager.createQuery(jpql, Producto.class).getResultList();
    }

    public List<Producto> consultarPorNomber(String nombre) {
        String jpql = "SELECT P FROM Producto AS P WHERE P.nombre=:nombre";
        return manager.createQuery(jpql, Producto.class).setParameter("nombre", nombre).getResultList();
    }

    public List<Producto> consultaPorNombreDeCategoria(String nombre) {

        String jpql = "SELECT P FROM Producto AS P WHERE P.categoria.nombre=:nombre";

        return manager.createQuery(jpql, Producto.class).setParameter("nombre", nombre).getResultList();
    }

    public BigDecimal consultarPrecioPorNombreDeProducto(String nombre) {
        String jpql = "SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre";
        return manager.createQuery(jpql, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
    }

}
