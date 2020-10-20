package br.edu.ifce.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("ACADEMIA");

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
