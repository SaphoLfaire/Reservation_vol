package service;

import DAO.ReservationDAO;
import model.Reservation;
import model.Vol;

public class ServiceReservation {
	
	private static ReservationDAO rDAO = new ReservationDAO();
	
	private ServiceReservation() {
		
	}
	
	public static Boolean creationObjets (Reservation res) {
		try {
			rDAO.persist(res);
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
		
	}

}
