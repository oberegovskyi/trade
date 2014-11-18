package com.bionic.edu;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	@PersistenceContext
	private EntityManager em;
	
	public CustomerDAOImpl () {
		
	}

	/**
	 * 
	 * @return �� ������, �� ����������
	 */
	public List<FishItem> getAllAvailableFishItems() {
		TypedQuery<FishItem> query = em
				.createQuery("SELECT f FROM FishItem as f WHERE f.status<=2",
						FishItem.class);
		List<FishItem> listI = null;

		listI = query.getResultList();

		return listI;
	}

	/**
	 * 
	 * ���� ����� ��� ���� �� ���� �������
	 */
	public void addFishToParcelItem(OutParcelItem temp) {

		em.getTransaction().begin();
		em.persist(temp);
		em.getTransaction().commit();

	}

	/**
	 * 
	 * ���� ������ �볺���
	 */
	public void addCustomer(Customer temp) {

		em.getTransaction().begin();
		em.persist(temp);
		em.getTransaction().commit();

	}

	/**
	 * 
	 * ������� ������ ���� �� ���������
	 */
	public void deleteFishItem(OutParcelItem temp) {

		temp.setIsDeleted(1);
		em.getTransaction().begin();
		em.merge(temp);
		em.getTransaction().commit();

	}

	/**
	 * 
	 * ������ OutParcelItem
	 */
	public void saveOutParcelItem(OutParcelItem temp) {

		em.getTransaction().begin();
		em.merge(temp);
		em.getTransaction().commit();

	}

	/**
	 * 
	 * @return �������� ���� ��������� �������
	 */
	public double getAllWeightOfParcel(OutParcelItem temp) {
		TypedQuery<Double> query = em
				.createQuery(
						"SELECT sum(o.weight) FROM OutParcelItem o WHERE o.outParcel.outParcelId=:id",
						Double.class);
		query.setParameter("id", temp.getOutParcel().getOutParcelId());
		double totalWeight;
		totalWeight = query.getSingleResult();
		return totalWeight;

	}

	/**
	 * @return ���� �񳺿 �������
	 */
	public double getPriceOfParcel(OutParcel temp) {
		TypedQuery<OutParcelItem> query = em
				.createQuery(
						"SELECT o FROM OutParcelItem o WHERE o.outParcel.outParcelId=:id",
						OutParcelItem.class);
		query.setParameter("id", temp.getOutParcelId());
		List<OutParcelItem> weightPrice = null;
		double result = 0;
		weightPrice = query.getResultList();
		System.out.println(weightPrice);
		for (OutParcelItem in : weightPrice) {
			result += in.getWeight() * in.getFishItem().getSellPrice();
		}

		return result;
	}
	
	public List <InParcel> getAllInParcels () {
		TypedQuery<InParcel> query = em.createQuery("SELECT i FROM InParcel as i",
						InParcel.class);
		List<InParcel> listI = null;

		listI = query.getResultList();

		return listI;
	}

}
