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
		String izenAbizena;
		boolean aurkitua = false;

		do {
			// Pedimos todo en un solo texto
			Kontsola.inprimatu("Sartu langilearen izen-abizenak:");
			izenAbizena = Teklatua.irakurri().trim();

			try {
				FileReader irakurriLangileakFitxategia = new FileReader("./src/eredua/fitxategia/LANGILEAK.txt");
				BufferedReader irakurriZatiHandiaLangileak = new BufferedReader(irakurriLangileakFitxategia);

				// Saltamos la primera línea
				irakurriZatiHandiaLangileak.readLine();

				String lerroa;

				while ((lerroa = irakurriZatiHandiaLangileak.readLine()) != null) {

					String[] tokenak = lerroa.split("\t");

					// Unimos nombre y apellido del archivo para comparar con el texto introducido
					String fitxategikoIzena = tokenak[1] + " " + tokenak[2];

					if (izenAbizena.equalsIgnoreCase(fitxategikoIzena)) {
						Langileak langileak = kapsulatuDatuak(tokenak);
						zerrenda.add(langileak);
						Kontsola.inprimatu(langileak);
						aurkitua = true;
						break; // Paramos la lectura al encontrarlo
					}
				}

				irakurriZatiHandiaLangileak.close();
				irakurriLangileakFitxategia.close();

			} catch (Exception arazoa) {
				Kontsola.inprimatu(arazoa.toString());
			}

			if (!aurkitua) {
				Kontsola.inprimatu("Izen eta abizen hori duen langilerik ez da existitzen. Saiatu berriro.");
			}

		} while (!aurkitua);

		return zerrenda;
	}

	private Langileak kapsulatuDatuak(String[] tokenak) {

		Langileak langileak = new Langileak();

		langileak.setIzena(tokenak[1]);
		langileak.setAbizena(tokenak[2]);
		langileak.setTelZenbakia(tokenak[4]);
		langileak.setAltaEguna(tokenak[5]);

		return langileak;
	}
}