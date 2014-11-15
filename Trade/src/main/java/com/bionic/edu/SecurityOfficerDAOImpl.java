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
	 * ���� ������ ����������
	 */
	public void addNewEmployee(Employee employee) {
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
	}

	/**
	 * ������ ����������
	 */
	public void saveEmployee(Employee employee) {
		em.getTransaction().begin();
		em.merge(employee);
		em.getTransaction().commit();
	}

	/**
	 * ����� ����������
	 */
	public void blockEmployee(Employee employee) {
		employee.setBlocked(1);
		em.getTransaction().begin();
		em.merge(employee);
		em.getTransaction().commit();
	}

	/**
	 * ���� ������ �볺���
	 */
	public void addNewCustomer(Customer customer) {
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();
	}

	/**
	 * ������ �볺���
	 */
	public void saveCustomer(Customer customer) {
		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();
	}

	/**
	 * ����� �볺���
	 */
	public void blockCustomer(Customer customer) {
		customer.setBlocked(1);
		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();
	}
}
