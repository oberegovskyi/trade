package com.bionic.edu.DAOImpl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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

	public GeneralManagerDAOImpl() {

	}

	/**
	 * ���� ���� ����� ���� � �������
	 */
	public int addNewInParcel(InParcel inParcel) {

		em.persist(inParcel);
		em.flush();
		return inParcel.getInParcelId();
	}

	/**
	 * ���� ���� ����� �������
	 */
	public void addNewFishItem(FishItem fishItem) {

		em.persist(fishItem);
	}

	/**
	 * ���� ���� ����� �������
	 */
	public void saveFishItem(FishItem fishItem) {

		em.merge(fishItem);
	}

	/**
	 * 0 - �� ������� 1 - ������� 2 - �� ��������� 3 - ������� ���������� ����
	 * �� �� �������� ��� �������
	 */
	public void setFishUnsaled(FishItem fishItem) {

		fishItem.setStatus(3);
		em.merge(fishItem);
	}

	/**
	 * ���� ���� ����� �������
	 */
	public void saveCustomer(Customer customer) {
		em.merge(customer);
	}

	/**
	 * ������� ����� �� ������ ���
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
	 * ������� ����, �� ��� ������� ����� ��� ����
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
	 * ������� ��� ���� ���� ����, �� ������� � ��� ����
	 */
	public Map<java.sql.Date, Double> getFishWeightReport(FishItem fishItem,
			java.sql.Date date1, java.sql.Date date2) {


		TypedQuery<OutParcelItem> query = em
				.createQuery(
						"SELECT o FROM OutParcelItem as o WHERE o.fishItem=:fish  AND o.outParcel.outParcelDate>=:dt1 AND o.outParcel.outParcelDate<=:dt2",
						OutParcelItem.class);
		query.setParameter("fish", fishItem);
		query.setParameter("dt1", date1);
		query.setParameter("dt2", date2);
		List<OutParcelItem> result = query.getResultList();
		Map<java.sql.Date, Double> map = new TreeMap<java.sql.Date, Double>();
		for (OutParcelItem ii : result) {
			if (map.containsKey(ii.getOutParcel().getOutParcelDate())) {
				double we=0;
				we = map.get(ii.getOutParcel().getOutParcelDate())
						+ ii.getWeight();
				map.put(ii.getOutParcel().getOutParcelDate(), we);
			} else {
				map.put(ii.getOutParcel().getOutParcelDate(), ii.getWeight());
			}
		}
		return map;
	}

	public List<FishItem> getAllFishItemsInParcel(InParcel inParcel) {
		TypedQuery<FishItem> query = em
				.createQuery("SELECT f FROM FishItem f WHERE f.inParcel=:in",
						FishItem.class);
		query.setParameter("in", inParcel);
		List<FishItem> result = query.getResultList();
		return result;
	}

	public void saveInParcel(InParcel inParcel) {
		em.merge(inParcel);
	}

	public InParcel getInParcel(int i) {
		return em.find(InParcel.class, i);
	}

	public List<OutParcel> getAllOutAvParcels() {
		TypedQuery<OutParcel> query = em.createQuery(
				"SELECT o FROM OutParcel o WHERE o.available=1 AND o.taken=0",
				OutParcel.class);
		List<OutParcel> result = query.getResultList();
		return result;
	}

}
