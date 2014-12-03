package com.bionic.edu.DAOImpl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.DAO.AccountantDAO;
import com.bionic.edu.entities.FishItem;
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
		em.merge(outParcel);
	}
	
	public List<OutParcel> getNotAv() {
		TypedQuery<OutParcel> query = em
				.createQuery("SELECT o FROM OutParcel as o WHERE o.available=0",
						OutParcel.class);
		List<OutParcel> list = null;

		list = query.getResultList();

		return list;
	}
}
