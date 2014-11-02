package com.bionic.edu.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bionic.edu.fishTradeNew.Customer;
import com.bionic.edu.fishTradeNew.Employee;


public class SecurityOfficerDAO {
	private static final String UNIT_NAME = "FishM";
	private static EntityManagerFactory factory;
	public static void main (String[] args) {
		factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = factory.createEntityManager();
	}
	
	
	/**
	 * додає нового працівника
	 */
	public void addNewEmployee (EntityManager em, Employee  employee) {
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
	}
	
	/**
	 * редагує працівника
	 */
	public void saveEmployee (EntityManager em, Employee  employee) {
		em.getTransaction().begin();
		em.merge(employee);
		em.getTransaction().commit();
	}
	
	/**
	 * блокує працівника
	 */
	public void blockEmployee (EntityManager em, Employee  employee) {
		employee.setBlocked(1);
		em.getTransaction().begin();
		em.merge(employee);
		em.getTransaction().commit();
	}
	
	/**
	 * додає нового клієнта
	 */
	public void addNewCustomer (EntityManager em, Customer  customer) {
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
	}
	
	/**
	 * редагує клієнта
	 */
	public void saveCustomer (EntityManager em, Customer  customer) {
		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();
	}
	
	/**
	 * блокує клієнта
	 */
	public void blockCustomer (EntityManager em, Customer  customer) {
		customer.setBlocked(1);
		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();
	}
}
