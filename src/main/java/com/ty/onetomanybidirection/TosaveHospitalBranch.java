package com.ty.onetomanybidirection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TosaveHospitalBranch {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital = new Hospital();
		hospital.setName("jaidev");
		hospital.setAddress("bangalore");

		Branch branch = new Branch();
		branch.setName("bangalore");
		branch.setAddress("basavanagudi");
		Branch branch1 = new Branch();
		branch1.setName("bangalore");
		branch1.setAddress("basavanagudi");
		branch.setHospital(hospital);
		branch1.setHospital(hospital);

		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch);
		entityManager.persist(branch1);
		entityTransaction.commit();

	}

}
