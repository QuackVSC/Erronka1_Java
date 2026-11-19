package businessLogic;

import java.io.*;

import ikuspegia.Kontsola;
import kontrolagailua.Teklatua;

public class Erregistroa {

	public static void autentifikatu() throws Exception {

		String aukera = "";

		// Erabiltzaileari zer egin nahi duen galdetu
		while (true) {
			Kontsola.inprimatu("Kaixo,zer egin nahi duzu?");
			Kontsola.inprimatu("===============");
			Kontsola.inprimatu("1. Erregistratu");
			Kontsola.inprimatu("2. Saioa hasi");
			Kontsola.inprimatu("===============");

			aukera = Teklatua.irakurri();

			// Erabiltzailea erregistratu nahi badu
			if (aukera.equals("1")) {

				erregistratu();

			// Saioa hasi nahi badu
			} else if (aukera.equals("2")) {

				saioaHasi();
				break;

			// Beste aukera bat sartzen badu
			} else {

				Kontsola.inprimatu("Aukera okerra!");
			}
		}
	}

	// Erabiltzaile berri bat erregistratu
	private static void erregistratu() throws Exception {

		Kontsola.inprimatu("Sartu erabiltzaile izena:");
		String erabiltzailea = Teklatua.irakurri();

		// Erabiltzaile izena fitxategian dagoen begiratu
		if (erabiltzaileaExistitzenDa(erabiltzailea)) {

			Kontsola.inprimatu("Erabiltzaile hori dagoeneko erregistratuta dago!");

		} else {

			// Pasahitza eskatu
			Kontsola.inprimatu("Sartu pasahitza:");
			String pasahitza = Teklatua.irakurri();

			// Kontuak gordetzen diren fitxategia ireki
			// true erabilita, datu berriak amaieran gehitzen dira
			FileWriter fitxategia = new FileWriter(eredua.Fitxategiak.bidea("KONTUAK.txt"), true);

			// Erabiltzaile izena eta pasahitza fitxategian gorde
			fitxategia.write(erabiltzailea + ";" + pasahitza + "\n");

			// Fitxategia itxi
			fitxategia.close();

			Kontsola.inprimatu("Erregistroa ondo egin da!");
		}
	}

	// Erabiltzaile izena fitxategian dagoen egiaztatu
	private static boolean erabiltzaileaExistitzenDa(String erabiltzailea) throws Exception {

		// Fitxategia irakurtzeko ireki
		BufferedReader fitxategia = new BufferedReader(new FileReader(eredua.Fitxategiak.bidea("KONTUAK.txt")));

		String lerroa;
		boolean aurkituta = false;

		// Fitxategiko lerro guztiak irakurri
		while ((lerroa = fitxategia.readLine()) != null) {

			// Lerroko datuak ; ikurraren bidez banatu
			String[] datuak = lerroa.split(";");

			// Erabiltzaile izena berdina den begiratu
			if (erabiltzailea.equals(datuak[0])) {

				aurkituta = true;
				break;
			}
		}

		// Fitxategia itxi
		fitxategia.close();

		// Erabiltzailea aurkitu den ala ez itzuli
		return aurkituta;
	}

	// Erabiltzailearen saioa hasi
	private static void saioaHasi() throws Exception {

		boolean zuzena = false;

		// Datu zuzenak sartu arte errepikatu
		while (!zuzena) {

			Kontsola.inprimatu("Sartu erabiltzaile izena:");
			String erabiltzailea = Teklatua.irakurri();

			Kontsola.inprimatu("Sartu pasahitza:");
			String pasahitza = Teklatua.irakurri();

			// Kontuak dituen fitxategia irakurtzeko ireki
			BufferedReader fitxategia = new BufferedReader(new FileReader(eredua.Fitxategiak.bidea("KONTUAK.txt")));

			String lerroa;

			// Fitxategiko kontu guztiak aztertu
			while ((lerroa = fitxategia.readLine()) != null) {

				// Erabiltzaile izena eta pasahitza banatu
				String[] datuak = lerroa.split(";");

				// Bi datuak bat datozela egiaztatu
				if (erabiltzailea.equals(datuak[0]) && pasahitza.equals(datuak[1])) {

					zuzena = true;
					break;
				}
			}

			// Fitxategia itxi
			fitxategia.close();

			// Datuak okerrak badira, berriro eskatu
			if (!zuzena) {

				Kontsola.inprimatu("Erabiltzailea edo pasahitza okerra da. Saiatu berriro.");
			}
		}

		// Saioa behar bezala hasi dela adierazi
		Kontsola.inprimatu("Saioa behar bezala hasi da!");
		Kontsola.inprimatu("===========================");
	}
}