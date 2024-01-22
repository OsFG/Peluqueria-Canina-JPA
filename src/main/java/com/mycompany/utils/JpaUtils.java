package com.mycompany.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	
	private static EntityManagerFactory eMF = Persistence.createEntityManagerFactory("PCJpa");
	
	public static EntityManager getEntityMan(){
		return eMF.createEntityManager();		
	}
}