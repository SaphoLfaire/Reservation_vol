package controller;

import java.util.Scanner;

import javax.persistence.EntityManager;

import DAO.DatabaseHelper;
import model.Reservation;
import model.Vol;

public class App {

	public static void main(String[] args) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		DatabaseHelper.commitTxAndClose(em);
		Reservation res1 = new Reservation();

		boolean arret = false;
		while (!arret) {
			System.out.println("--Mon menu de gestion de vol et de reservation--");
			System.out.println("1) Gestion des Vols");
			System.out.println("2) Gestion des reservations");
			System.out.println("3) Quitter");
			System.out.println("Entrez votre choix");
			Scanner scanner = new Scanner(System.in);
			String sousmenu1 = scanner.nextLine();
			//scanner.close();
			switch (sousmenu1) {
			case "1": 
				
				//arret = true;
				Controller.sousMenuVol();
				break;
			case "2":
				Controller.sousMenuReservation();
				break;
			case "3":
				System.exit(0);
				break;
			
			default:
				
				System.out.println("entrez un choix entre 1 et 3 \n");
				break;
			}
		}

	}

}
