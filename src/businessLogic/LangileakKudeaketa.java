
package businessLogic;

// Behar ditugun klaseak inportatu
import eredua.Langileak;
import ikuspegia.Kontsola;
import kontrolagailua.Teklatua;

import java.io.*;
import java.util.*;

public class LangileakKudeaketa {

	// Langileen zerrenda gordetzeko
	private List<Langileak> zerrenda;

	// Langile baten datuak bilatu eta irakurri
	public List<Langileak> langileaIrakurri() throws Exception {

		// Langileen zerrenda huts bat sortu
		zerrenda = new ArrayList<Langileak>();

		String izenAbizena;
		boolean aurkitua = false;

		// Langilea aurkitu arte bilaketa errepikatu
		do {

			// Langilearen izena, abizena edo ID-a eskatu
			Kontsola.inprimatu("Sartu langilearen izen-abizenak edo ID-a:");
			izenAbizena = Teklatua.irakurri().trim();

			try {

				// Langileen fitxategia ireki
				FileReader irakurriLangileakFitxategia = new FileReader(eredua.Fitxategiak.bidea("LANGILEAK.txt"));

				// Fitxategia lerroz lerro irakurri
				BufferedReader irakurriZatiHandiaLangileak = new BufferedReader(irakurriLangileakFitxategia);

				// Lehenengo lerroa saltatu (izenburuak)
				irakurriZatiHandiaLangileak.readLine();

				String lerroa;

				// Fitxategiko lerro guztiak irakurri
				while ((lerroa = irakurriZatiHandiaLangileak.readLine()) != null) {

					// Lerroko datuak banatu
					String[] tokenak = lerroa.split("\t");

					// Langilearen izena eta abizena elkartu
					String fitxategikoIzena = tokenak[1] + " " + tokenak[2];

					// Sartutako datua fitxategiko datuekin alderatu
					if (izenAbizena.equalsIgnoreCase(fitxategikoIzena)
							|| izenAbizena.equalsIgnoreCase(tokenak[1])
							|| izenAbizena.equalsIgnoreCase(tokenak[2])
							|| izenAbizena.equals(tokenak[0])) {

						// Langilearen datuak objektu batean gorde
						Langileak langileak = kapsulatuDatuak(tokenak);

						// Langilea zerrendan gehitu
						zerrenda.add(langileak);

						// Langilearen datuak pantailan erakutsi
						Kontsola.inprimatu(langileak);

						aurkitua = true;

						// Bilaketa amaitu
						break;
					}
				}

				// Fitxategiak itxi
				irakurriZatiHandiaLangileak.close();
				irakurriLangileakFitxategia.close();

			} catch (Exception arazoa) {

				// Errorea pantailan erakutsi
				Kontsola.inprimatu(arazoa.toString());
			}

			// Langilea aurkitu ez bada, abisua erakutsi
			if (!aurkitua) {
				Kontsola.inprimatu("Izen eta abizen hori duen langilerik ez da existitzen. Saiatu berriro.");
			}

		} while (!aurkitua);

		// Aurkitutako langileen zerrenda itzuli
		return zerrenda;
	}

	// Fitxategiko datuak Langileak objektuan gorde
	private Langileak kapsulatuDatuak(String[] tokenak) {

		Langileak langileak = new Langileak();

		// Langilearen datuak objektuan gorde
		langileak.setID(tokenak[0]);
		langileak.setIzena(tokenak[1]);
		langileak.setAbizena(tokenak[2]);
		langileak.setTelZenbakia(tokenak[4]);
		langileak.setAltaEguna(tokenak[5]);

		// Langilearen objektua itzuli
		return langileak;
	}
}
