package businessLogic;

import eredua.Eskariak;
import ikuspegia.Kontsola;
import kontrolagailua.Teklatua;

import java.io.*;
import java.util.*;

public class EskariakKudeaketa {

	private List<Eskariak> zerrenda;

	public List<Eskariak> eskariaIrakurri() throws Exception {

		zerrenda = new ArrayList<Eskariak>();
		String idEskaria;
		boolean aurkitua = false;

		do {
			Kontsola.inprimatu("Sartu eskariaren ID-a:");
			idEskaria = Teklatua.irakurri();

			try {
				FileReader irakurriEskariakFitxategia = new FileReader("./src/eredua/fitxategia/ESKARI_LERROAK.txt");
				BufferedReader irakurriZatiHandiaEskariak = new BufferedReader(irakurriEskariakFitxategia);

				irakurriZatiHandiaEskariak.readLine();

				String lerroa;

				while ((lerroa = irakurriZatiHandiaEskariak.readLine()) != null) {

					String[] tokenak = lerroa.split("\t");

					if (idEskaria.equals(tokenak[0])) {
						Eskariak eskariak = kapsulatuDatuak(tokenak);
						zerrenda.add(eskariak);
						Kontsola.inprimatu(eskariak);
						aurkitua = true;
					}
				}
				irakurriZatiHandiaEskariak.close();
				irakurriEskariakFitxategia.close();

			} catch (Exception arazoa) {
				Kontsola.inprimatu(arazoa.toString());
			}
			
			if(!aurkitua) {
				Kontsola.inprimatu("ID hori duen eskaririk ez da existitzen. Saiatu berriro.");
			}
		} while (!aurkitua);
		return zerrenda;
	}

	private Eskariak kapsulatuDatuak(String[] tokenak) {

		Eskariak eskariak = new Eskariak();

		eskariak.setZenbakia(tokenak[0]);
		eskariak.setProduktua(tokenak[2]);
		eskariak.setKopurua(Integer.valueOf(tokenak[3]));
		
		String prezioZuzena=tokenak[4].replace(",", ".");
		
		eskariak.setPrezioa(Double.valueOf(prezioZuzena));

		return eskariak;
	}
}
