package com.bionic.edu.DAO;

import java.sql.Date;
import java.util.Calendar;
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
			FishItem itemf =  em.find(FishItem.class, 2);
			//Customer cust =  em.find(Customer.class, 2);
			OutParcelItem temp = new OutParcelItem(parct,itemf,56);

			addFishToParcelItem(em, temp);
			System.out.println(temp);

	}
	
	/**
	 * 
	 * @return всі товари, що продаються
	 */
	public static List<FishItem> getAllAvailableFishItems (EntityManager em) {
		TypedQuery<FishItem> query = em.createQuery("SELECT f FROM FishItem as f WHERE f.status<=2", FishItem.class);
		List<FishItem> listI = null;
		try{ 
			listI=query.getResultList();
		}

		finally{ 
			em.close();
		}
		
		return listI;	
	}
	
	/**
	 * 
	 * додає новий вид риби до даної посилки
	 */
	public static void addFishToParcelItem (EntityManager em, OutParcelItem temp) {
		try {
			em.getTransaction().begin();
			em.persist(temp);
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
	}
	/**
	 * 
	 * додає нового клієнта
	 */
	public static void addCustomer (EntityManager em, Customer temp) {
		try {
			em.getTransaction().begin();
			em.persist(temp);
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
	}
}
