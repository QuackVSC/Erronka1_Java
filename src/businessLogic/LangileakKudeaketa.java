
package businessLogic;

import eredua.Langileak;
import ikuspegia.Kontsola;
import kontrolagailua.Teklatua;

import java.io.*;
import java.util.*;

public class LangileakKudeaketa {

	private List<Langileak> zerrenda;

	public List<Langileak> langileaIrakurri() throws Exception {

		zerrenda = new ArrayList<Langileak>();

		try {
			FileReader fr = new FileReader("./src/eredua/fitxategia/LANGILEAK.txt");

			BufferedReader br = new BufferedReader(fr);

			br.readLine();

			String lerroa;

			while ((lerroa = br.readLine()) != null) {

				String[] tokenak = lerroa.split("\t");

				Langileak langileak = kapsulatuDatuak(tokenak);
				zerrenda.add(langileak);
			}

			br.close();
			fr.close();

		} catch (Exception e) {
			Kontsola.inprimatu(e.toString());
		}

		String IDlangilea;

		boolean aurkitua = false;

		do {
			Kontsola.inprimatu("Sartu langilearen IDa:");
			IDlangilea = Teklatua.irakurri();

			for (Langileak langilea : zerrenda) {

				if (IDlangilea.equals(langilea.getID())) {
					Kontsola.inprimatu(langilea);
					aurkitua = true;
					break;
				}
			}

			if (!aurkitua) {
				Kontsola.inprimatu("ID hori ez da existitzen. Saiatu berriro.");
			}

		} while (!aurkitua);

		return zerrenda;
	}

	private Langileak kapsulatuDatuak(String[] tokenak) {

		Langileak langileak = new Langileak();

		langileak.setID(tokenak[0]);
		langileak.setIzena(tokenak[1]);
		langileak.setAbizena(tokenak[2]);
		langileak.setTelZenbakia(tokenak[4]);
		langileak.setAltaEguna(tokenak[5]);

		return langileak;
	}
}
