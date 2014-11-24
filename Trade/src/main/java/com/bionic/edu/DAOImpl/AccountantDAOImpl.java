package com.bionic.edu.DAOImpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bionic.edu.DAO.AccountantDAO;
import com.bionic.edu.entities.OutParcel;

@Repository
public class AccountantDAOImpl implements AccountantDAO, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public AccountantDAOImpl () {
		
	}

	/**
	 * реєструє партію як доступну для відвантаження
	 */
	public void setAvailable(OutParcel outParcel) {
		outParcel.setAvailable(1);
		em.getTransaction().begin();
		em.merge(outParcel);
		em.getTransaction().commit();
	}
}
