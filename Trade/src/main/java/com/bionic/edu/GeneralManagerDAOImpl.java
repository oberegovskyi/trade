package com.bionic.edu;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class GeneralManagerDAOImpl implements GeneralManagerDAO {
	@PersistenceContext
	private EntityManager em;
	
	public GeneralManagerDAOImpl () {
		
	}

	/**
	 * додає нову партію риби з корабля
	 */
	public void addNewInParcel(InParcel inParcel) {

		em.getTransaction().begin();
		em.persist(inParcel);
		em.getTransaction().commit();
	}

	/**
	 * додає нову рибну одиницю
	 */
	public void addNewFishItem(FishItem fishItem) {

		em.getTransaction().begin();
		em.persist(fishItem);
		em.getTransaction().commit();
	}

	/**
	 * додає нову рибну одиницю
	 */
	public void saveFishItem(FishItem fishItem) {

		em.getTransaction().begin();
		em.merge(fishItem);
		em.getTransaction().commit();
	}

	/**
	 * 0 - не прийшла 1 - прийшла 2 - не продається 3 - списана встановлює рибу
	 * як не доступну для продажу
	 */
	public void setFishUnsaled(FishItem fishItem) {

		fishItem.setStatus(3);
		em.getTransaction().begin();
		em.merge(fishItem);
		em.getTransaction().commit();
	}

	/**
	 * додає нову рибну одиницю
	 */
	public void saveCustomer(Customer customer) {

		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();
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

}
