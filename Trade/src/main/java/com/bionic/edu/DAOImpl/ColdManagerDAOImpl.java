package com.bionic.edu.DAOImpl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bionic.edu.DAO.ColdManagerDAO;
import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.InParcel;
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
		em.merge(fishItem);
	}

	/**
	 * реєструє продаж партії
	 */
	public void updateOutParcel(OutParcel outParcel) {
		em.merge(outParcel);
	}

	/**
	 * списує рибу
	 */
	public void setWriteOffFishItem(FishItem fishItem) {
		fishItem.setStatus(3);
		em.merge(fishItem);
	}
	
	public void updateInParcel (InParcel inParcel) {
		em.merge(inParcel);
	}
}
