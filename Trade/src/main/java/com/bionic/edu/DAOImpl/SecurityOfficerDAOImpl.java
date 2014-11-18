package com.bionic.edu.DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.DAO.SecurityOfficerDAO;
import com.bionic.edu.entities.Customer;
import com.bionic.edu.entities.Employee;

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
		em.persist(employee);
	}

	/**
	 * редагує працівника
	 */
	public void saveEmployee(Employee employee) {
		em.merge(employee);
	}

	/**
	 * блокує працівника
	 */
	public void blockEmployee(Employee employee) {
		employee.setBlocked(1);
		em.merge(employee);
	}

	/**
	 * додає нового клієнта
	 */
	public void addNewCustomer(Customer customer) {
		em.persist(customer);
	}

	/**
	 * редагує клієнта
	 */
	public void saveCustomer(Customer customer) {
		em.merge(customer);
	}

	/**
	 * блокує клієнта
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
