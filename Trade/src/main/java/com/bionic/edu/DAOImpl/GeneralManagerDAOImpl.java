package com.bionic.edu.DAOImpl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.DAO.GeneralManagerDAO;
import com.bionic.edu.entities.Customer;
import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.InParcel;
import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.entities.OutParcelItem;

@Repository
public class GeneralManagerDAOImpl implements GeneralManagerDAO, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public GeneralManagerDAOImpl () {
		
	}

	/**
	 * додає нову партію риби з корабля
	 */
	public int addNewInParcel(InParcel inParcel) {

		em.persist(inParcel);
		em.flush();
		return inParcel.getInParcelId();
	}

	/**
	 * додає нову рибну одиницю
	 */
	public void addNewFishItem(FishItem fishItem) {

		em.persist(fishItem);
	}

	/**
	 * додає нову рибну одиницю
	 */
	public void saveFishItem(FishItem fishItem) {

		em.merge(fishItem);
	}

	/**
	 * 0 - не прийшла 1 - прийшла 2 - не продається 3 - списана встановлює рибу
	 * як не доступну для продажу
	 */
	public void setFishUnsaled(FishItem fishItem) {

		fishItem.setStatus(3);
		em.merge(fishItem);
	}

	/**
	 * додає нову рибну одиницю
	 */
	public void saveCustomer(Customer customer) {
		em.merge(customer);
	}

	/**
	 * повертає дохід по окремій рибі
	 */
	public double getFishIncomeReport(FishItem fishItem) {

		TypedQuery<OutParcelItem> query = em.createQuery(
				"SELECT o FROM OutParcelItem o WHERE o.fishItem=:fish",
				OutParcelItem.class);
		query.setParameter("fish", fishItem);
		List<OutParcelItem> result = query.getResultList();
		double sum = 0;
		for (OutParcelItem oo : result) {
			sum += (oo.getFishItem().getBuyPrice() - oo.getFishItem()
					.getSellPrice()) * oo.getWeight();
		}
		return sum;
	}

	/**
	 * повертає суму, на яку продано даний вид риби
	 */
	public double getFishSumReport(FishItem fishItem) {

		TypedQuery<OutParcelItem> query = em.createQuery(
				"SELECT o FROM OutParcelItem o WHERE o.fishItem=:fish",
				OutParcelItem.class);
		query.setParameter("fish", fishItem);
		List<OutParcelItem> result = query.getResultList();
		double sum = 0;
		for (OutParcelItem oo : result) {
			sum += (oo.getFishItem().getSellPrice()) * oo.getWeight();
		}
		return sum;
	}

	/**
	 * повертає всю вагу даної риби, що продали
	 */
	public double getFishWeightReport(FishItem fishItem) {

		TypedQuery<OutParcelItem> query = em.createQuery(
				"SELECT o FROM OutParcelItem o WHERE o.fishItem=:fish",
				OutParcelItem.class);
		query.setParameter("fish", fishItem);
		List<OutParcelItem> result = query.getResultList();
		double sum = 0;
		for (OutParcelItem oo : result) {
			sum += oo.getWeight();
		}
		return sum;
	}
	
	public List <FishItem> getAllFishItemsInParcel (InParcel inParcel){
		TypedQuery<FishItem> query = em.createQuery("SELECT f FROM FishItem f WHERE f.inParcel=:in",FishItem.class);
		query.setParameter("in", inParcel);
		List<FishItem> result = query.getResultList();
		return result;
	}
	
	public void saveInParcel (InParcel inParcel) {
		em.merge(inParcel);	
	}

	public InParcel getInParcel (int i) {
		return em.find(InParcel.class,i);
	}
	
	public List<OutParcel> getAllOutAvParcels () {
		TypedQuery<OutParcel> query = em.createQuery("SELECT o FROM OutParcel o WHERE o.available=1 AND o.taken=0" ,OutParcel.class);
		List<OutParcel> result = query.getResultList();
		return result;
	}
}
