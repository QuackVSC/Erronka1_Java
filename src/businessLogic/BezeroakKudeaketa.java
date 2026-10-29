package businessLogic;

import eredua.Bezeroak;
import ikuspegia.Kontsola;
import kontrolagailua.Teklatua;

import java.io.*;
import java.util.*;

public class BezeroakKudeaketa {

	private List<Bezeroak> zerrenda;

	public List<Bezeroak> bezeroaIrakurri() throws Exception {

		zerrenda = new ArrayList<Bezeroak>();
		String izenAbizena;
		boolean aurkitua = false;

		do {
			Kontsola.inprimatu("Sartu bezeroaren izen-abizenak:");
			izenAbizena = Teklatua.irakurri().trim();

			try {
				FileReader irakurriBezeroakFitxategia = new FileReader("./src/eredua/fitxategia/BEZEROAK.txt");
				BufferedReader irakurriZatiHandiaBezeroak = new BufferedReader(irakurriBezeroakFitxategia);

				irakurriZatiHandiaBezeroak.readLine();

				String lerroa;

				while ((lerroa = irakurriZatiHandiaBezeroak.readLine()) != null) {

					String[] tokenak = lerroa.split("\t");

					String fitxategikoIzena = tokenak[1] + " " + tokenak[2];

					if (izenAbizena.equalsIgnoreCase(fitxategikoIzena)) {
						Bezeroak bezeroak = kapsulatuDatuak(tokenak);
						
					
						String tel = telefonoaLortu(bezeroak.getID());
						bezeroak.setTelefonoa(tel);
					

						zerrenda.add(bezeroak);
						Kontsola.inprimatu(bezeroak);
						aurkitua = true;
						break;
					}
				}
				irakurriZatiHandiaBezeroak.close();
				irakurriBezeroakFitxategia.close();

			} catch (Exception arazoa) {
				Kontsola.inprimatu(arazoa.toString());
			}
			if (!aurkitua) {
				Kontsola.inprimatu("Izen eta abizen hori duen bezerorik ez da existitzen. Saiatu berriro.");
			}
		} while (!aurkitua);
		return zerrenda;
	}


	private String telefonoaLortu(String ID) {
		String telefonoa="";
		try {
			FileReader irakurriTelFitxategia = new FileReader("./src/eredua/fitxategia/BEZERO_TELEFONOAK.txt");
			BufferedReader irakurriZatiHandiaTel = new BufferedReader(irakurriTelFitxategia);

			irakurriZatiHandiaTel.readLine();

			String lerroa;

			while ((lerroa = irakurriZatiHandiaTel.readLine()) != null) {
				String[] tokenak = lerroa.split("\t");

				
				if (ID.equals(tokenak[1])) {
					telefonoa = tokenak[2];
					break;
				}
			}
			irakurriZatiHandiaTel.close();
			irakurriTelFitxategia.close();

		} catch (Exception arazoa) {
			Kontsola.inprimatu(arazoa.toString());
		}
		return telefonoa;
	}

	private Bezeroak kapsulatuDatuak(String[] tokenak) {

		Bezeroak bezeroak = new Bezeroak();

		bezeroak.setID(tokenak[0]);
		bezeroak.setIzena(tokenak[1]);
		bezeroak.setAbizena(tokenak[2]);
		bezeroak.setEmail(tokenak[4]);

		return bezeroak;
	}
}