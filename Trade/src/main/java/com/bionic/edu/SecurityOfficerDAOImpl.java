package com.bionic.edu;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		em.persist(employee);
	}

	/**
	 * ������ ����������
	 */
	public void saveEmployee(Employee employee) {
		em.merge(employee);
	}

	/**
	 * ����� ����������
	 */
	public void blockEmployee(Employee employee) {
		employee.setBlocked(1);
		em.merge(employee);
	}

	/**
	 * ���� ������ �볺���
	 */
	public void addNewCustomer(Customer customer) {
		em.persist(customer);
	}

	/**
	 * ������ �볺���
	 */
	public void saveCustomer(Customer customer) {
		em.merge(customer);
	}

	/**
	 * ����� �볺���
	 */
	public void blockCustomer(Customer customer) {
		customer.setBlocked(1);
		em.merge(customer);
	}


	public List<Customer> getAllCustomers() {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer as c",Customer.class);
		List<Customer> listI = null;

		listI = query.getResultList();
		return listI;
	}
}
