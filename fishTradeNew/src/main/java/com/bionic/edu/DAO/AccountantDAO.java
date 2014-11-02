package com.bionic.edu.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bionic.edu.fishTradeNew.OutParcel;

public class AccountantDAO {
	private static final String UNIT_NAME = "FishM";
	public static void main(String[] args )
	{

		EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
	}
	
	/**
	 * реєструє партію як доступну для відвантаження 
	 */
	public static void setAvailable (EntityManager em, OutParcel outParcel) {
			outParcel.setAvailable(1);
			em.getTransaction().begin();
			em.merge(outParcel);
			em.getTransaction().commit();
	}
}
	
	
