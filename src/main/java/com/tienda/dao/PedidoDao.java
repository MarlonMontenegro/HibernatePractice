package com.tienda.dao;

import com.tienda.modelo.Pedido;
import com.tienda.vo.RelatorioDeVenta;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {

    private EntityManager manager;

    public PedidoDao(EntityManager manager) {
        this.manager = manager;
    }

    public void guardar(Pedido pedido) {
        this.manager.persist(pedido);
    }

    public Pedido consultaPorId(long id) {
        return manager.find(Pedido.class, id);
    }

    public List<Pedido> consultarTodos() {

        String jpql = "SELECT P FROM Pedido AS P";
        return manager.createQuery(jpql, Pedido.class).getResultList();
    }

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM  Pedido  p";
        return manager.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public Double valorPromedioVendido() {
        String jpql = "SELECT AVG (p.valorTotal) FROM  Pedido p";
        return manager.createQuery(jpql, Double.class).getSingleResult();
    }

    public List<RelatorioDeVenta> relatorioDeVentasVO() {
        String jpql = "SELECT new com.tienda.vo.RelatorioDeVenta(producto.nombre, "
                + "SUM(item.cantidad), "
                + "MAX(pedido.fecha)) "
                + "FROM Pedido pedido "
                + "JOIN pedido.items item "
                + "JOIN item.producto producto "
                + "GROUP BY producto.nombre "
                + "ORDER BY item.cantidad DESC";
        return manager.createQuery(jpql, RelatorioDeVenta.class).getResultList();
    }

}
