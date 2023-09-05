package com.tienda.pruebas;

import com.tienda.modelo.Categoria;
import com.tienda.modelo.Producto;
import com.tienda.dao.CategoriaDao;
import com.tienda.dao.ProductoDao;
import com.tienda.utils.JPAUtils;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class RegistroDeProducto {
    public static void main(String[] args) {

        registrarProducto();
        EntityManager manager = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(manager);
        Producto producto = productoDao.consultaPorId(1);
        System.out.println(producto.getNombre());

        List<Producto> productos = productoDao.consultarPorNombre("Samsung");
        productos.forEach(p -> System.out.println(producto.getDescription()));
    }

    private static void registrarProducto() {
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        Categoria celulares = new Categoria("CELULARES");


        Producto samsung = new Producto("Samsung", "Note 20", new BigDecimal(1000), celulares);
        em.getTransaction().begin();

        productoDao.guardar(samsung);
        categoriaDao.guardar(celulares);
        em.getTransaction().commit();
        em.close();


    }



}
