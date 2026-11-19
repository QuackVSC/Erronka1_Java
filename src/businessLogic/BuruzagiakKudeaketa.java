
package businessLogic;

// Behar ditugun klaseak inportatu
import eredua.Buruzagiak;
import ikuspegia.Kontsola;
import kontrolagailua.Teklatua;

import java.io.*;
import java.util.*;

public class BuruzagiakKudeaketa {

	// Buruzagien zerrenda gordetzeko
	private List<Buruzagiak> zerrenda;

	// Buruzagi baten datuak bilatu eta irakurri
	public List<Buruzagiak> BuruzagiaIrakurri() throws Exception {

		// Zerrenda huts bat sortu
		zerrenda = new ArrayList<Buruzagiak>();

		String idNagusia;
		boolean aurkitua = false;

		// Buruzagia aurkitu arte bilaketa errepikatu
		do {

			// Buruzagiaren ID-a eskatu
			Kontsola.inprimatu("Sartu buruzagiaren ID nagusia:");
			idNagusia = Teklatua.irakurri();

			try {

				// Langileen fitxategia ireki
				FileReader irakurriFitxategia = new FileReader(eredua.Fitxategiak.bidea("LANGILEAK.txt"));

				// Fitxategia lerroz lerro irakurri
				BufferedReader irakurriZatiHandia = new BufferedReader(irakurriFitxategia);

				// Lehenengo lerroa saltatu (izenburuak)
				irakurriZatiHandia.readLine();

				String lerroa;

				// Fitxategiko lerro guztiak irakurri
				while ((lerroa = irakurriZatiHandia.readLine()) != null) {

					// Lerroko datuak banatu
					String[] tokenak = lerroa.split("\t");

					// Sartutako ID-a fitxategiko ID-arekin alderatu
					if (idNagusia.equals(tokenak[6])) {

						// Datuak objektu batean gorde
						Buruzagiak buruzagiak = kapsulatuDatuak(tokenak);

						// Buruzagia zerrendan gehitu
						zerrenda.add(buruzagiak);

						// Buruzagiaren datuak pantailan erakutsi
						Kontsola.inprimatu(buruzagiak);

						aurkitua = true;
					}
				}

				// Fitxategiak itxi
				irakurriFitxategia.close();
				irakurriZatiHandia.close();

			} catch (Exception arazoa) {

				// Errorea pantailan erakutsi
				Kontsola.inprimatu(arazoa.toString());
			}

			// Buruzagia aurkitu ez bada, abisua erakutsi
			if (!aurkitua) {
				Kontsola.inprimatu("ID hori duen buruzagirik ez da aurkitu. Saiatu berriro");
			}

		} while (!aurkitua);

		// Aurkitutako buruzagien zerrenda itzuli
		return zerrenda;
	}

	// Fitxategiko datuak Buruzagiak objektuan gorde
	private Buruzagiak kapsulatuDatuak(String[] tokenak) {

		Buruzagiak buruzagiak = new Buruzagiak();

		// Buruzagiaren datuak objektuan gorde
		buruzagiak.setIzena(tokenak[1]);
		buruzagiak.setAbizena(tokenak[2]);
		buruzagiak.setEmail(tokenak[3]);
		buruzagiak.setIdNagusia(tokenak[6]);

		// Buruzagiaren objektua itzuli
		return buruzagiak;
	}
}
