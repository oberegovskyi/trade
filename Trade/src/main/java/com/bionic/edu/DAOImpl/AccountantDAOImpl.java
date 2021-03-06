package com.bionic.edu.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bionic.edu.DAO.AccountantDAO;
import com.bionic.edu.entities.OutParcel;

@Repository
public class AccountantDAOImpl implements AccountantDAO {
	@PersistenceContext
	private EntityManager em;
	
	public AccountantDAOImpl () {
		
	}

	/**
	 * ������ ����� �� �������� ��� ������������
	 */
	public void setAvailable(OutParcel outParcel) {
		outParcel.setAvailable(1);
		em.getTransaction().begin();
		em.merge(outParcel);
		em.getTransaction().commit();
	}
}
