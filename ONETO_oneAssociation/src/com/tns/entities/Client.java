package com.tns.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = new Student();
		student.setName("Mohammedi");
		Address homeAddress = new Address();
		homeAddress.setStreet("MG road");
		homeAddress.setCity("kalaburagi");
		homeAddress.setState("karnataka");
		homeAddress.setZipCode("585104");
		
		//inject address into student
		student.setAddress(homeAddress);
		
		//persist only student, no need to persist Address explicitly
		em.persist(student);
		em.getTransaction().commit();
		
		System.out.println("Added the recorded successfully.");
		em.close();
		factory.close();
	}
}