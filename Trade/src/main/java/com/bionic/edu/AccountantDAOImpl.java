package com.bionic.edu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bionic.edu.OutParcel;

@Repository
public class AccountantDAOImpl implements AccountantDAO {
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
