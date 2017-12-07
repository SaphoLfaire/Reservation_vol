package DAO;

import javax.persistence.EntityManager;

import model.Reservation;
import model.Vol;

public class GenericDAO<T> {

	private Class klass;

	public GenericDAO(Class<T> klass) {
		this.klass = klass;
	}

	public Boolean persist(T t) {
		EntityManager em = DatabaseHelper.createEntityManager();
		try {

			DatabaseHelper.beginTx(em);
			em.persist(t);
			DatabaseHelper.commitTxAndClose(em);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			DatabaseHelper.rollbackTxAndClose(em);
			return false;

		}

	}

	public void afficheTableau(T... ts) {

		for (T t : ts) {
			if (t instanceof Vol) {
				System.out.println("Numero      | Type | Place | Depart | Arrivee | Date ");
			}
			if (t instanceof Reservation) {
				System.out.println("Numero Reservation      | Nom | Prenom | num Vol | Date depart ");
			}
			t.toString();
		}

	}
	
	public Object find (T t) {
		EntityManager em = DatabaseHelper.createEntityManager();
		
		try {
			DatabaseHelper.beginTx(em);
			Object o = em.find(klass, t);
			DatabaseHelper.commitTxAndClose(em);
			return o;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			DatabaseHelper.rollbackTxAndClose(em);
		}
		
		Object oo = new Object();
		return oo;
	}

}
