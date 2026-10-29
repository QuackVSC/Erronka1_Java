package businessLogic;

import eredua.Buruzagiak;
import ikuspegia.Kontsola;
import kontrolagailua.Teklatua;

import java.io.*;
import java.util.*;

public class BuruzagiakKudeaketa {

	private List<Buruzagiak> zerrenda;

	public List<Buruzagiak> BuruzagiaIrakurri() throws Exception {

		zerrenda = new ArrayList<Buruzagiak>();
		String idNagusia;
		boolean aurkitua = false;

		do {
			Kontsola.inprimatu("Sartu buruzagiaren ID nagusia:");
			idNagusia = Teklatua.irakurri();

			try {
				FileReader irakurriFitxategia = new FileReader("./src/eredua/fitxategia/LANGILEAK.txt");
				BufferedReader irakurriZatiHandia = new BufferedReader(irakurriFitxategia);

				irakurriZatiHandia.readLine();

				String lerroa;
				while ((lerroa = irakurriZatiHandia.readLine()) != null) {
					String[] tokenak = lerroa.split("\t");

					if (idNagusia.equals(tokenak[6])) {
						Buruzagiak buruzagiak = kapsulatuDatuak(tokenak);
						zerrenda.add(buruzagiak);
						Kontsola.inprimatu(buruzagiak);
						
					}
				}

				irakurriFitxategia.close();
				irakurriZatiHandia.close();

			} catch (Exception arazoa) {
				Kontsola.inprimatu(arazoa.toString());
			}
			if(!aurkitua) {
				Kontsola.inprimatu("ID hori duen buruzagirik ez da aurkitu. Saiatu berriro");
			}
		}

		while (!aurkitua);

		return zerrenda;
	}

	private Buruzagiak kapsulatuDatuak(String[] tokenak) {
		Buruzagiak buruzagiak = new Buruzagiak();

		buruzagiak.setIzena(tokenak[1]);
		buruzagiak.setAbizena(tokenak[2]);
		buruzagiak.setEmail(tokenak[3]);
		buruzagiak.setIdNagusia(tokenak[6]);

		return buruzagiak;
	}
}
