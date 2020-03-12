package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Opdracht1SaveMessage {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = null;
        EntityManager manager = null;

        try{
            managerFactory= Persistence.createEntityManagerFactory("musicdb_pu");
            manager = managerFactory.createEntityManager();
            EntityTransaction transaction = manager.getTransaction();
            transaction.begin();

            Message message = new Message(1, "hello");
            manager.persist(message);
            transaction.commit();
            System.out.println("Messsage saved");

        }finally{
            if (managerFactory != null) managerFactory.close();
            if(manager != null) manager.close();
        }
    }
}
