package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Visitor;

import javax.persistence.*;
import java.util.List;

public class DemoGetVisitor {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;

        try{
            factory = Persistence.createEntityManagerFactory("musicdb_pu");
            manager = factory.createEntityManager();
            TypedQuery<Visitor> findGeoffrey = manager.createQuery("SELECT vi from Visitor vi WHERE vi.name = :name", Visitor.class);
            findGeoffrey.setParameter("name", "geoffrey");
            List<Visitor> resultList = findGeoffrey.getResultList();

            for (var person: resultList) {
                System.out.println(String.format("Name: %s\nage: %d", person.getName(), person.getAge()));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
