package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Visitor;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DemoCreateVisitor {
    public static void main(String[] args) {
        Visitor visitor = new Visitor("geoffrey", 29);
        EntityManagerFactory factory = null;
        EntityManager manager = null;

        try{
            factory = Persistence.createEntityManagerFactory("musicdb_pu");
            manager = factory.createEntityManager();
            EntityTransaction transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(visitor);
            transaction.commit();
        }finally {
            if(factory != null){
                factory.close();
            }
            if(manager != null){
                manager.close();
            }
        }
    }
}
