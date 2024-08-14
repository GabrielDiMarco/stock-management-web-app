package com.stock.singleton;

import javax.persistence.*;

public class SingletonManFact {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	//EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
    
    private SingletonManFact() {        
    
    }
    
    public static EntityManager getInstance() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("miUP");
            em = emf.createEntityManager();
        }
        return em;
    }
    
    public static void closeInstance() {
    	if(em != null) {
    		em.close();
    	}
    }
}
