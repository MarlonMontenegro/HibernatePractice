import com.tienda.modelo.Categoria;
import com.tienda.modelo.Producto;
import com.tienda.modelo.dao.CategoriaDao;
import com.tienda.modelo.dao.ProductoDao;
import com.tienda.modelo.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroDeProducto {
    public static void main(String[] args) {

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
