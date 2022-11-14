package es.severo;

import es.severo.persistence.entity.Tramite;
import jakarta.persistence.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Tramite t = new Tramite();
            t.setFecha(LocalDateTime.now());
            t.setTipo("Credito");
            em.persist(t);
            transaction.commit();
        }finally {
            em.close();
            emf.close();
        }

    }
}
