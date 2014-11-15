package com.bionic.edu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class SecurityOfficerDAOImpl implements SecurityOfficerDAO {
	@PersistenceContext
	private EntityManager em;
	
	public SecurityOfficerDAOImpl () {
		
	}

	/**
	 * додає нового працівника
	 */
	public void addNewEmployee(Employee employee) {
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
	}

	/**
	 * редагує працівника
	 */
	public void saveEmployee(Employee employee) {
		em.getTransaction().begin();
		em.merge(employee);
		em.getTransaction().commit();
	}

	/**
	 * блокує працівника
	 */
	public void blockEmployee(Employee employee) {
		employee.setBlocked(1);
		em.getTransaction().begin();
		em.merge(employee);
		em.getTransaction().commit();
	}

	/**
	 * додає нового клієнта
	 */
	public void addNewCustomer(Customer customer) {
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
	}

	/**
	 * редагує клієнта
	 */
	public void saveCustomer(Customer customer) {
		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();
	}

	/**
	 * блокує клієнта
	 */
	public void blockCustomer(Customer customer) {
		customer.setBlocked(1);
		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();
	}
}
