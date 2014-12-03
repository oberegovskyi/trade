package com.bionic.edu.DAOImpl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.edu.DAO.CustomerDAO;
import com.bionic.edu.entities.Customer;
import com.bionic.edu.entities.FishItem;
import com.bionic.edu.entities.InParcel;
import com.bionic.edu.entities.OutParcel;
import com.bionic.edu.entities.OutParcelItem;

@Repository
public class CustomerDAOImpl implements CustomerDAO, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;

	public CustomerDAOImpl() {

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

		em.persist(temp);

	}

	/**
	 * 
	 * ���� ������ �볺���
	 */
	public void addCustomer(Customer temp) {
		em.persist(temp);
	}

	/**
	 * 
	 * ������� ������ ���� �� ���������
	 */
	public void deleteFishItem(OutParcelItem temp) {

		temp.setIsDeleted(1);
		em.merge(temp);
	}

	/**
	 * 
	 * ������ OutParcelItem
	 */
	public void saveOutParcelItem(OutParcelItem temp) {
		em.merge(temp);
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
		for (OutParcelItem in : weightPrice) {
			result += in.getWeight() * in.getFishItem().getSellPrice();
		}
		return result;
	}

	public List<InParcel> getAllInParcels() {
		TypedQuery<InParcel> query = em.createQuery(
				"SELECT i FROM InParcel as i", InParcel.class);
		List<InParcel> listI = null;

		listI = query.getResultList();

		return listI;
	}

	public Customer checkLoginPassword(String login, String password) {
		Customer cust = null;
		try {
			TypedQuery<Customer> query = em
					.createQuery(
							"SELECT c FROM Customer as c WHERE c.login=:log AND c.password=:pas",
							Customer.class);
			query.setParameter("log", login);
			query.setParameter("pas", password);
			cust = query.getSingleResult();
		} catch (NoResultException e) {
			return cust;
		}

		return cust;
	}

	/**
	 * ���� ���� �����
	 */
	public void addOutParcelWithItems(OutParcel temp, List<OutParcelItem> items) {
		em.persist(temp);
		for (OutParcelItem in : items) {
			em.persist(in);
			FishItem tempF = em.find(FishItem.class, in.getFishItem()
					.getFishItemId());
			double we = tempF.getWeight();
			tempF.setWeight(we - in.getWeight());
			em.merge(tempF);
		}
	}

	public List<OutParcel> getOutParcels(Customer customer) {
		TypedQuery<OutParcel> query = em.createQuery(
				"SELECT o FROM OutParcel as o WHERE o.customer=:cust",
				OutParcel.class);
		List<OutParcel> listI = null;
		query.setParameter("cust", customer);
		listI = query.getResultList();

		return listI;
	}

	public List<OutParcelItem> getOutParcelItems(OutParcel outParcel) {
		TypedQuery<OutParcelItem> query = em.createQuery(
				"SELECT o FROM OutParcelItem as o WHERE o.outParcel=:out",
				OutParcelItem.class);
		List<OutParcelItem> listI = null;
		query.setParameter("out", outParcel);
		listI = query.getResultList();

		return listI;
	}

	public void updateCustomer(Customer customer) {
		em.merge(customer);
	}

	public void updateFishItem(FishItem fishItem) {
		em.merge(fishItem);
	}
}
