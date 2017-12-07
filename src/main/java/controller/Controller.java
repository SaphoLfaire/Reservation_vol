package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import model.Reservation;
import model.TypeAvion;
import model.Vol;
import service.ServiceReservation;
import service.ServiceVol;

public class Controller {

	public Controller() {

	}

	public static void sousMenuVol() {
		boolean arret = false;
		while (!arret) {
			System.out.println("\n --Gestion des vols--");
			System.out.println("1) Creation d'un vol");
			System.out.println("2) Liste des vols");
			System.out.println("3) Rechercher un vol par ville de depart et d’arrivee");
			System.out.println("4) Rechercher un vol par numero");
			System.out.println("5) Quitter");
			System.out.println("Entrez votre choix");
			Scanner scannerscanner1 = new Scanner(System.in);
			String sousmenu2 = scannerscanner1.nextLine();
			switch (sousmenu2) {
			case "1":
				Vol vol = new Vol();
				System.out.println("Preparez vous a rentrer des informations");
				System.out.println("Quel est le numero de vol ? ");
				vol.setNumVol(scannerscanner1.nextLine());
				System.out.println("Quel est le type d'avion ? ");
				vol.setTypeAvion(sousMenuEnumType());
				System.out.println("vous avez selectionner comme type avion " + vol.getTypeAvion());
				System.out.println("Combien de place ? ");
				vol.setNmPlace(scannerscanner1.nextLine());
				System.out.println("Ville de depart ? ");
				vol.setVilleDepart(scannerscanner1.nextLine());
				System.out.println("Ville d'arrivee ?");
				vol.setVilleArrivee(scannerscanner1.nextLine());
				 System.out.println("Date de depart ? ");
				LocalDate dateD = LocalDate.parse(scannerscanner1.nextLine(), DateTimeFormatter.BASIC_ISO_DATE);
				vol.setDateDepart(dateD);
				ServiceVol.creationObjets(vol);
				break;
			case "2":
				ServiceVol.listeVols();

				break;
			case "3":
				System.out.println("Rentrer un lieu");
				String numVol = scannerscanner1.nextLine();
				List<Vol> vol1 = ServiceVol.listeVolParLieu(numVol);
				if (vol1 != null) {
					for (Vol vol4 : vol1) {
						System.out.println("Numero | Type | Place     | Depart | Arrivee | Date ");
						System.out.println(vol1.toString());
					}

				} else {
					System.out.println("Aucun vol avec ce numero");
				}

				break;

			case "4":
				System.out.println("Rentrer le numero de vol");
				String lieuVol = scannerscanner1.nextLine();
				Vol vol2 = ServiceVol.trouverNumVol(lieuVol);
				if (vol2 != null) {
					System.out.println(vol2.toString());
				} else {
					System.out.println("Aucun vol au depart de ce lieu");
				}
				break;

			case "5":
				System.exit(0);
				break;

			default:
				System.out.println("entrez un choix entre 1 et 5 ");
				break;
			}
		}
	}

	public static void sousMenuReservation() {
		boolean arret = false;
		while (!arret) {
			System.out.println("--Gestion des reservations--");
			System.out.println("1) Creation d'une reservation");
			System.out.println("2) Voir les réservations d’un vol");
			System.out.println("3) Annuler une réservation");
			System.out.println("4) Voir toutes les reservations d’une personne");
			System.out.println("5) Quitter");
			System.out.println("Entrez votre choix");
			Scanner scanner = new Scanner(System.in);
			String sousmenu1 = scanner.nextLine();
			switch (sousmenu1) {
			case "1":
				Reservation res = new Reservation();
				System.out.println("Preparez vous a rentrer des informations");
				System.out.println("Quel est le numero de vol ? ");
				String numVol = scanner.nextLine();
				Vol vol2 = ServiceVol.trouverNumVol(numVol);
				if (vol2 != null) { // ICI REQUETE POUR TROUVER LE VOL
					

					System.out.println("Nom ? ");
					res.setNom(scanner.nextLine());
					System.out.println("Prenom ?");
					res.setPrenom(scanner.nextLine());
					System.out.println("Age ? ");
					res.setAge(scanner.nextLine());
					String numRes = "1";
					res.setNumRes(numRes);
					ServiceReservation.creationObjets(res);
					res.setNumRes(numVol + "-" + res.getId());
					System.out.println("Votre numero de reservation est le " + numRes);
					vol2.addResList(res);

				} else {
					System.out.println("Vol non trouvé");
				}

				break;
			case "2":
				System.out.println("Sous menu 2");
				break;
			case "3":
				System.exit(0);
				break;

			case "4":
				break;

			case "5":
				System.exit(0);

			default:
				System.out.println("entrez un choix entre 1 et 4");
				break;
			}
		}
	}

	private static TypeAvion sousMenuEnumType() {
		boolean arret = false;
		while (!arret) {
			System.out.println("1) A330");
			System.out.println("2) A340");
			System.out.println("3) A380");
			System.out.println("4) B747");
			System.out.println("Entrez votre choix");
			Scanner scanner = new Scanner(System.in);
			int sousmenu1 = scanner.nextInt();
			switch (sousmenu1) {
			case 1:
				return TypeAvion.A330;
			case 2:
				return TypeAvion.A340;
			case 3:
				return TypeAvion.A380;

			case 4:
				return TypeAvion.B747;

			default:
				System.out.println("entrez un choix entre 1 et 4");
				break;
			}
		}
		return TypeAvion.A330;

	}

}
