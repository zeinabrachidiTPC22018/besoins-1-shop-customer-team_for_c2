/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author zeina
 */
public class TP2_JPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em;
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("TP2_JPAPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        
    }
    
}
