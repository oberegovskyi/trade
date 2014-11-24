package com.bionic.edu.DAOImpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bionic.edu.DAO.ColdManagerDAO;
import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.OutParcel;

@Repository
public class ColdManagerDAOImpl implements ColdManagerDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public ColdManagerDAOImpl () {
		
	}

	/**
	 * реєструє дату і вагу риби, що прийшла
	 */
	public void saveCameWeightDate(FishItem fishItem) {
		fishItem.setStatus(1);
		em.getTransaction().begin();
		em.merge(fishItem.getInParcel());
		em.merge(fishItem);
		em.getTransaction().commit();
	}

	/**
	 * реєструє продаж партії
	 */
	public void setTaken(OutParcel outParcel) {
		outParcel.setTaken(1);
		em.getTransaction().begin();
		em.merge(outParcel);
		em.getTransaction().commit();
	}

	/**
	 * списує рибу
	 */
	public void setWriteOffFishItem(FishItem fishItem) {
		fishItem.setStatus(3);
		em.getTransaction().begin();
		em.merge(fishItem);
		em.getTransaction().commit();
	}
}
