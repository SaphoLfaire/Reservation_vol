package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import DAO.DatabaseHelper;
import DAO.VolDAO;
import model.Vol;

public class ServiceVol {

	private static VolDAO vDAO = new VolDAO();

	private ServiceVol() {

	}

	public static Boolean creationObjets(Vol vol) {
		try {
			vDAO.persist(vol);
			return true;
		}

		catch (Exception e) {
			return false;
		}

	}

	public static Vol findVol(Vol vol) {
		return (Vol) vDAO.find(vol);
	}

	public static Vol trouverNumVol(String numVol) {
		EntityManager em = DatabaseHelper.createEntityManager();
		try {
			TypedQuery<Vol> query = em.createQuery("select u " + "from Vol u " + "where u.numVol =:id ", Vol.class);
			query.setParameter("id", numVol);

			return query.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			em.close();
			return null;
		}

	}

	public static void listeVols() {
		EntityManager em = DatabaseHelper.createEntityManager();

		TypedQuery<Vol> query = em.createQuery("select u " + "from Vol u ", Vol.class);
		List<Vol> volList = query.getResultList();
		System.out.println("Numero | Type | Place     | Depart | Arrivee | Date ");
		for (Vol vol : volList) {
			System.out.println(vol.toString());

		}

	}

	public static List<Vol> listeVolParLieu(String depart) { /// NE MARcHE PAS
		EntityManager em = DatabaseHelper.createEntityManager();
		try {
			TypedQuery<Vol> query = em.createQuery("select u " + "from Vol  " + "where u.villeDepart =:id ",
					Vol.class);
			query.setParameter("id", depart);

			return query.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			em.close();
			return null;
		}
	}

}
