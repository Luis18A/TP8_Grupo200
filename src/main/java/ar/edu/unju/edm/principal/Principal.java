package ar.edu.unju.edm.principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

	public static EntityManager manager;
	public static EntityManagerFactory emf;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 //creamos un gestor de persistencia. ahora está en la clase EmfSingleton.java
		emf = Persistence.createEntityManagerFactory("TestPersistence");
		manager = emf.createEntityManager();

	}

}
