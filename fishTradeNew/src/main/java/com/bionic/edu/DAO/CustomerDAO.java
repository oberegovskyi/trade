package com.bionic.edu.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.bionic.edu.fishTradeNew.Customer;
import com.bionic.edu.fishTradeNew.FishItem;
import com.bionic.edu.fishTradeNew.OutParcel;
import com.bionic.edu.fishTradeNew.OutParcelItem;


public class CustomerDAO {
	private static final String UNIT_NAME = "FishM";
	
	public static void main(String[] args )
	{

		EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = factory.createEntityManager();
			//Calendar c =  Calendar.getInstance();
			//Date cc = new java.sql.Date(c.getTime().getTime());
						
			OutParcel parct =  em.find(OutParcel.class, 2);
			FishItem itemf =  em.find(FishItem.class, 1);
			OutParcelItem outParcelItemT = em.find(OutParcelItem.class, 1);
			//Customer cust =  em.find(Customer.class, 2);
			OutParcelItem temp = new OutParcelItem(parct,itemf,56);
			
			outParcelItemT.setWeight(200);
			outParcelItemT.setFishItem(itemf);
			
			//saveOutParcelItem(em, outParcelItemT);
			//deleteFishItem(em,outParcelItemT);
			//addFishToParcelItem(em, temp);
			System.out.println(getPriceOfParcel(em,parct));

	}
	
	/**
	 * 
	 * @return всі товари, що продаються
	 */
	public static List<FishItem> getAllAvailableFishItems (EntityManager em) {
		TypedQuery<FishItem> query = em.createQuery("SELECT f FROM FishItem as f WHERE f.status<=2", FishItem.class);
		List<FishItem> listI = null;
	
			listI=query.getResultList();

		
		return listI;	
	}
	
	/**
	 * 
	 * додає новий вид риби до даної посилки
	 */
	public static void addFishToParcelItem (EntityManager em, OutParcelItem temp) {
	
			em.getTransaction().begin();
			em.persist(temp);
			em.getTransaction().commit();

	}
	/**
	 * 
	 * додає нового клієнта
	 */
	public static void addCustomer (EntityManager em, Customer temp) {

			em.getTransaction().begin();
			em.persist(temp);
			em.getTransaction().commit();

	}
	
	/**
	 * 
	 * ставить статус риби як видалений
	 */
	public static void deleteFishItem (EntityManager em,OutParcelItem temp) {
	
			temp.setIsDeleted(1);
			em.getTransaction().begin();
			em.merge(temp);
			em.getTransaction().commit();

	}
	
	/**
	 * 
	 * зберігає OutParcelItem 
	 */
	public static void saveOutParcelItem (EntityManager em, OutParcelItem temp) {
		
		em.getTransaction().begin();
		em.merge(temp);
		em.getTransaction().commit();

	}
	
	/**
	 * 
	 * @return загальну вагу конкертної посилки 
	 */
	public static double getAllWeightOfParcel (EntityManager em, OutParcelItem temp) {
		TypedQuery<Double> query = em.createQuery("SELECT sum(o.weight) FROM OutParcelItem o WHERE o.outParcel.outParcelId=:id", Double.class);
		query.setParameter("id", temp.getOutParcel().getOutParcelId());
		double totalWeight;
		totalWeight= query.getSingleResult(); 
		return totalWeight;	

	}
	
	/**
	 * @return ціну всієї посилки
	 */
	public static double getPriceOfParcel (EntityManager em, OutParcel temp) {
		TypedQuery<OutParcelItem> query = em.createQuery("SELECT o FROM OutParcelItem o WHERE o.outParcel.outParcelId=:id", OutParcelItem.class);
		query.setParameter("id", temp.getOutParcelId());
		List<OutParcelItem> weightPrice=null;
		double result=0; 
			weightPrice = query.getResultList();
			System.out.println(weightPrice);
			for (OutParcelItem in: weightPrice) {
				result+=in.getWeight()*in.getFishItem().getSellPrice();
			}

		return result;
	}
}
