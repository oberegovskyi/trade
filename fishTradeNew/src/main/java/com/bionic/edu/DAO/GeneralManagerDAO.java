package com.bionic.edu.DAO;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.bionic.edu.fishTradeNew.Customer;
import com.bionic.edu.fishTradeNew.InParcel;
import com.bionic.edu.fishTradeNew.FishItem;
import com.bionic.edu.fishTradeNew.OutParcel;
import com.bionic.edu.fishTradeNew.OutParcelItem;

public class GeneralManagerDAO {
	private static final String UNIT_NAME = "FishM";
	public static void main(String[] args )
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		Calendar c =  Calendar.getInstance();
		Date cc = new Date(c.getTime().getTime());
		
		InParcel inpT =  new InParcel(cc);
		
		InParcel inT = em.find(InParcel.class, 2);
		FishItem fishIT =em.find(FishItem.class, 1);
		Customer custT =  em.find(Customer.class, 1);
		custT.setPayment(90);
		
		System.out.println(getFishWeightReport(em,fishIT));
		//FishItem fishIT =  new FishItem("Riba","krutaya",0, 123, 56, 78, inT, 0);
		//fishIT.setStatus(3);
		//saveCustomer(em, custT);
	}
	
	/**
	 * додає нову партію риби з корабля
	 */
	public static void addNewInParcel (EntityManager em, InParcel inParcel) {
		
			em.getTransaction().begin();
			em.persist(inParcel);
			em.getTransaction().commit();
	}
	/**
	 * додає нову рибну одиницю
	 */
	public static void addNewFishItem (EntityManager em, FishItem fishItem) {
		
			em.getTransaction().begin();
			em.persist(fishItem);
			em.getTransaction().commit();
	}
	
	/**
	 * додає нову рибну одиницю
	 */
	public static void saveFishItem (EntityManager em, FishItem fishItem) {
		
			em.getTransaction().begin();
			em.merge(fishItem);
			em.getTransaction().commit();
	}
	
	/**
	 * 0 - не прийшла
	 * 1 - прийшла
	 * 2 - не продається
	 * 3 - списана
	 *     встановлює рибу як не доступну для продажу
	 */
	public static void setFishUnsaled (EntityManager em, FishItem fishItem) {
		
			fishItem.setStatus(3);
			em.getTransaction().begin();
			em.merge(fishItem);
			em.getTransaction().commit();
	}
	
	/**
	 * додає нову рибну одиницю
	 */
	public static void saveCustomer (EntityManager em, Customer customer) {
		
			em.getTransaction().begin();
			em.merge(customer);
			em.getTransaction().commit();
	}
	
	/**
	 * повертає дохід по окремій рибі
	 */
	public static double getFishIncomeReport (EntityManager em, FishItem fishItem) {
		
		TypedQuery<OutParcelItem> query = em.createQuery("SELECT o FROM OutParcelItem o WHERE o.fishItem=:fish", OutParcelItem.class);
		query.setParameter("fish", fishItem);
		List<OutParcelItem> result=query.getResultList();
		double sum=0;
		for (OutParcelItem oo : result) {
			sum+=(oo.getFishItem().getBuyPrice()-oo.getFishItem().getSellPrice())*oo.getWeight();
		}
		return sum;			
	}
	
	/**
	 * повертає суму, на яку продано даний вид риби
	 */
	public static double getFishSumReport (EntityManager em, FishItem fishItem) {
		
		TypedQuery<OutParcelItem> query = em.createQuery("SELECT o FROM OutParcelItem o WHERE o.fishItem=:fish", OutParcelItem.class);
		query.setParameter("fish", fishItem);
		List<OutParcelItem> result=query.getResultList();
		double sum=0;
		for (OutParcelItem oo : result) {
			sum+=(oo.getFishItem().getSellPrice())*oo.getWeight();
		}
		return sum;			
	}
	
	/**
	 * повертає всю вагу даної риби, що продали
	 */
	public static double getFishWeightReport (EntityManager em, FishItem fishItem) {
		
		TypedQuery<OutParcelItem> query = em.createQuery("SELECT o FROM OutParcelItem o WHERE o.fishItem=:fish", OutParcelItem.class);
		query.setParameter("fish", fishItem);
		List<OutParcelItem> result=query.getResultList();
		double sum=0;
		for (OutParcelItem oo : result) {
			sum+=oo.getWeight();
		}
		return sum;			
	}

}
