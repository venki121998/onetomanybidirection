package com.ty.onetomanybidirection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ToSaveMobileSim {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Mobile mobile= new Mobile();
		mobile.setName("apple");
		mobile.setCost(500000);
		Sim sim= new Sim();
		sim.setMobile(mobile);
		sim.setProvider("jio");
		sim.setType("4g");
		Sim sim1= new Sim();
		sim1.setProvider("jio");
		sim1.setType("4g");
		List<Sim>sims= new ArrayList<Sim>();
		sims.add(sim);
		sims.add(sim);
		
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim);
		entityManager.persist(sim1);
		entityTransaction.commit();
	}

}
