package eredua;

import java.io.*;

public class Fitxategiak {

	// Fitxategiaren bidea itzuli (Eclipsen edo JAR-ean)
	public static String bidea(String izena) {

		// Eclipsen gaude? Orduan lehengo bidea erabili
		File eclipsekoa = new File("./src/eredua/fitxategia/" + izena);

		if (eclipsekoa.exists()) {
			return "./src/eredua/fitxategia/" + izena;
		}

		// JAR-ean gaude: "fitxategia" karpeta erabili
		File karpeta = new File("fitxategia");

		// Karpeta ez badago, sortu
		if (!karpeta.exists()) {
			karpeta.mkdir();
		}

		File fitxategia = new File("fitxategia/" + izena);

		// Fitxategia ez badago, JAR barrutik kopiatu
		if (!fitxategia.exists()) {

			try {

				// JAR barruko fitxategia ireki
				InputStream jarrekoa = Fitxategiak.class.getResourceAsStream("/eredua/fitxategia/" + izena);

				// Fitxategi berria sortu
				FileWriter idatzi = new FileWriter(fitxategia);

				if (jarrekoa != null) {

					// JAR barrukoa lerroz lerro irakurri
					BufferedReader irakurri = new BufferedReader(new InputStreamReader(jarrekoa));

					String lerroa;

					// Lerro bakoitza fitxategi berrian idatzi
					while ((lerroa = irakurri.readLine()) != null) {
						idatzi.write(lerroa + "\n");
					}

					irakurri.close();
				}

				// Fitxategia itxi
				idatzi.close();

			} catch (Exception arazoa) {

				// Errorea pantailan erakutsi
				System.out.println(arazoa.toString());
			}
		}

		// Bidea itzuli
		return "fitxategia/" + izena;
	}
}
