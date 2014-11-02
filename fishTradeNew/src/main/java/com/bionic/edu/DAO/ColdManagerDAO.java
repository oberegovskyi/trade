package com.bionic.edu.DAO;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bionic.edu.fishTradeNew.Customer;
import com.bionic.edu.fishTradeNew.FishItem;
import com.bionic.edu.fishTradeNew.InParcel;
import com.bionic.edu.fishTradeNew.OutParcel;

public class ColdManagerDAO {
	private static final String UNIT_NAME = "FishM";
	public static void main(String[] args )
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		Calendar c =  Calendar.getInstance();
		Date cc = new Date(c.getTime().getTime());
		
		InParcel inpT =  new InParcel(cc);
		
		InParcel inT = em.find(InParcel.class, 2);
		FishItem fishIT =em.find(FishItem.class, 4);
		Customer custT =  em.find(Customer.class, 1);
		OutParcel outT =  em.find(OutParcel.class, 1);
		
		setWriteOffFishItem(em,fishIT);
		
	}
	
	/**
	 * реєструє дату і вагу риби, що прийшла
	 */
	public static void saveCameWeightDate (EntityManager em, FishItem fishItem) {
			fishItem.setStatus(1);
			em.getTransaction().begin();
			em.merge(fishItem.getInParcel());
			em.merge(fishItem);
			em.getTransaction().commit();
	}
	
	/**
	 * реєструє продаж партії
	 */
	public static void setTaken (EntityManager em, OutParcel outParcel) {
			outParcel.setTaken(1);
			em.getTransaction().begin();
			em.merge(outParcel);
			em.getTransaction().commit();
	}
	
	/**
	 * списує рибу
	 */
	public static void setWriteOffFishItem (EntityManager em, FishItem fishItem) {
			fishItem.setStatus(3);
			em.getTransaction().begin();
			em.merge(fishItem);
			em.getTransaction().commit();
	}
}
