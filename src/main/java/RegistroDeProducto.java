import com.tienda.modelo.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class RegistroDeProducto {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
        EntityManager em = factory.createEntityManager();

        Producto celular = new Producto();

        celular.setNombre("Samsung");
        celular.setDescription("Teléfono Usado, 200gb");
        celular.setPrecio(new BigDecimal("1000"));

        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();

    }
}
