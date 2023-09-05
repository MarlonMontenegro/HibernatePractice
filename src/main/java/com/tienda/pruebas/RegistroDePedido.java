package com.tienda.pruebas;

import com.tienda.dao.CategoriaDao;
import com.tienda.dao.ClienteDao;
import com.tienda.dao.PedidoDao;
import com.tienda.dao.ProductoDao;
import com.tienda.modelo.*;
import com.tienda.utils.JPAUtils;
import com.tienda.vo.RelatorioDeVenta;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class RegistroDePedido {
    public static void main(String[] args) {
        registrarProducto();

        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        Producto producto = productoDao.consultaPorId(1L);
        ClienteDao clienteDao = new ClienteDao(em);
        PedidoDao pedidoDao = new PedidoDao(em);

        Cliente cliente = new Cliente("Juan", "k6757kjb");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarItems(new ItemsPedido(5, producto, pedido));

        List<RelatorioDeVenta> relatorio = pedidoDao.relatorioDeVentasVO();

        for (RelatorioDeVenta venta : relatorio) {
            System.out.println(venta[0]);
            System.out.println(venta[1]);
            System.out.println(venta[2]);

        }


        em.getTransaction().begin();
        clienteDao.guardar(cliente);
        pedidoDao.guardar(pedido);

        em.getTransaction().commit();

    }

    private static void registrarProducto() {
        Categoria celulares = new Categoria("CELULARES");
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        Producto samsung = new Producto("Samsung", "Note 20", new BigDecimal(1000), celulares);
        em.getTransaction().begin();

        productoDao.guardar(samsung);
        categoriaDao.guardar(celulares);
        em.getTransaction().commit();
        em.close();
    }

}
