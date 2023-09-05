package com.tienda.dao;

import com.tienda.modelo.Cliente;
import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {

    private EntityManager manager;

    public ClienteDao(EntityManager manager) {
        this.manager = manager;
    }

    public void guardar(Cliente cliente) {
        this.manager.persist(cliente);
    }

    public Cliente consultaPorId(long id) {
        return manager.find(Cliente.class, id);
    }

    public List<Cliente> consultarTodos() {

        String jpql = "SELECT P FROM Cliente AS P";
        return manager.createQuery(jpql, Cliente.class).getResultList();
    }

    public List<Cliente> consultarPorNombre(String nombre) {
        String jpql = "SELECT P FROM Cliente AS P WHERE P.nombre=:nombre";
        return manager.createQuery(jpql, Cliente.class).setParameter("nombre", nombre).getResultList();
    }

}
