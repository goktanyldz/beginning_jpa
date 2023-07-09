import org.hibernate.type.StringType;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Settings {


      boolean verilerAlindi=false;

     private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("goktan");
     private static EntityManager entityManager = entityManagerFactory.createEntityManager();




    public void add_(Urun urun){
        entityManager.getTransaction().begin();
        entityManager.persist(urun);
        entityManager.getTransaction().commit();
    }

    public void update_(Urun urun){
        entityManager.getTransaction().begin();
        entityManager.merge(urun);
        entityManager.getTransaction().commit();
    }

    public void remove_(int id){
        entityManager.getTransaction().begin();
        Urun urun1 = entityManager.find(Urun.class,id);
        if (urun1 instanceof CepTelefonu){
            entityManager.remove((CepTelefonu)urun1);

        } else if (urun1 instanceof  FotografMakinesi) {
            entityManager.remove((FotografMakinesi)urun1);

        }
        entityManager.getTransaction().commit();
    }

    public List<Urun> findByUrunTuru(Urun urun) {

        String className = urun.getClass().getSimpleName();

        String jpql = "SELECT u FROM " + className + " u WHERE TYPE(u) = :urunType";
        TypedQuery<Urun> query = entityManager.createQuery(jpql, Urun.class);
        query.setParameter("urunType", urun.getClass());
        List<Urun> urunList = query.getResultList();
       return  urunList;


    }

}
