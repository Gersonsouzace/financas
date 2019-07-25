package br.com.caelum.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Metodo de chamada para criar o EntityManager Factory da persistencia financas.

public class JPAUtil {

		private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas"); //static para garantir que ira ter apenas uma instancia em memoria desta "fabrica".
		
		public EntityManager getEntityManager() {

			return emf.createEntityManager();
			
		}
}
