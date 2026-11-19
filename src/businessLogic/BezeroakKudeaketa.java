
package businessLogic;

// Behar ditugun klaseak inportatu
import eredua.Bezeroak;
import ikuspegia.Kontsola;
import kontrolagailua.Teklatua;

import java.io.*;
import java.util.*;

public class BezeroakKudeaketa {

	// Bezeroen zerrenda gordetzeko
	private List<Bezeroak> zerrenda;

	// Bezero baten datuak bilatu eta irakurri
	public List<Bezeroak> bezeroaIrakurri() throws Exception {

		// Bezeroen zerrenda huts bat sortu
		zerrenda = new ArrayList<Bezeroak>();

		String izenAbizena;
		boolean aurkitua = false;

		// Bezeroa aurkitu arte bilaketa errepikatu
		do {

			// Bezeroaren izena, abizena edo ID-a eskatu
			Kontsola.inprimatu("Sartu bezeroaren izen-abizenak edo ID-a:");
			izenAbizena = Teklatua.irakurri().trim();

			try {

				// Bezeroen fitxategia ireki
				FileReader irakurriBezeroakFitxategia = new FileReader(eredua.Fitxategiak.bidea("BEZEROAK.txt"));

				// Fitxategia lerroz lerro irakurri
				BufferedReader irakurriZatiHandiaBezeroak = new BufferedReader(irakurriBezeroakFitxategia);

				// Lehenengo lerroa saltatu (izenburuak)
				irakurriZatiHandiaBezeroak.readLine();

				String lerroa;

				// Fitxategiko lerro guztiak irakurri
				while ((lerroa = irakurriZatiHandiaBezeroak.readLine()) != null) {

					// Lerroko datuak banatu
					String[] tokenak = lerroa.split("\t");

					// Bezeroaren izen-abizenak elkartu
					String fitxategikoIzena = tokenak[1] + " " + tokenak[2];

					// Sartutako datua fitxategiko datuekin alderatu
					if (izenAbizena.equalsIgnoreCase(fitxategikoIzena)
							|| izenAbizena.equalsIgnoreCase(tokenak[1])
							|| izenAbizena.equalsIgnoreCase(tokenak[2])
							|| izenAbizena.equals(tokenak[0])) {

						// Bezeroaren datuak objektu batean gorde
						Bezeroak bezeroak = kapsulatuDatuak(tokenak);

						// Bezeroaren telefonoa bilatu
						String telefonoa = telefonoaLortu(bezeroak.getID());

						// Telefonoa bezeroaren objektuan gorde
						bezeroak.setTelefonoa(telefonoa);

						// Bezeroa zerrendan gehitu
						zerrenda.add(bezeroak);

						// Bezeroaren datuak pantailan erakutsi
						Kontsola.inprimatu(bezeroak);

						aurkitua = true;

						// Bilaketa amaitu
						break;
					}
				}

				// Fitxategiak itxi
				irakurriZatiHandiaBezeroak.close();
				irakurriBezeroakFitxategia.close();

			} catch (Exception arazoa) {

				// Errorea pantailan erakutsi
				Kontsola.inprimatu(arazoa.toString());
			}

			// Bezeroa aurkitu ez bada, abisua erakutsi
			if (!aurkitua) {
				Kontsola.inprimatu("Izen eta abizen hori duen bezerorik ez da existitzen. Saiatu berriro.");
			}

		} while (!aurkitua);

		// Aurkitutako bezeroaren zerrenda itzuli
		return zerrenda;
	}

	// Bezeroaren telefonoa bilatu
	private String telefonoaLortu(String idBezeroTelefonoa) throws Exception {

		String telefonoa = null;

		try {

			// Telefonoen fitxategia ireki
			FileReader irakurriTelFitxategia = new FileReader(eredua.Fitxategiak.bidea("BEZERO_TELEFONOAK.txt"));

			// Fitxategia lerroz lerro irakurri
			BufferedReader irakurriZatiHandiaTel = new BufferedReader(irakurriTelFitxategia);

			// Lehenengo lerroa saltatu
			irakurriZatiHandiaTel.readLine();

			String lerroa;

			// Fitxategiko lerro guztiak irakurri
			while ((lerroa = irakurriZatiHandiaTel.readLine()) != null) {

				// Lerroko datuak banatu
				String[] tokenak = lerroa.split("\t");

				// Bezeroaren ID-a berdina den begiratu
				if (idBezeroTelefonoa.equals(tokenak[1])) {

					// Telefono zenbakia gorde
					telefonoa = tokenak[2];

					// Bilaketa amaitu
					break;
				}
			}

			// Fitxategiak itxi
			irakurriZatiHandiaTel.close();
			irakurriTelFitxategia.close();

		} catch (Exception arazoa) {

			// Errorea pantailan erakutsi
			Kontsola.inprimatu(arazoa.toString());
		}

		// Aurkitutako telefonoa itzuli
		return telefonoa;
	}

	// Fitxategiko datuak Bezeroak objektuan gorde
	private Bezeroak kapsulatuDatuak(String[] tokenak) {

		Bezeroak bezeroak = new Bezeroak();

		// Bezeroaren datuak objektuan gorde
		bezeroak.setID(tokenak[0]);
		bezeroak.setIzena(tokenak[1]);
		bezeroak.setAbizena(tokenak[2]);
		bezeroak.setEmail(tokenak[4]);

		// Bezeroaren objektua itzuli
		return bezeroak;
	}
}
