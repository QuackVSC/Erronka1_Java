package kontrolagailua;

import ikuspegia.*;
import logotipoa.*;

public class Kontrolagailua {

	public Kontrolagailua() throws Exception {
		try {
			run();
		} catch (Exception arazoa) {
			Kontsola.inprimatu(arazoa.toString());
		}
	}

	private void run() throws Exception {

		try {

			Logotipoa.run();

			String aukera = "";

			Menu.menuInprimaketa();
			while (!aukera.equals("7")) {
				Kontsola.inprimatu("Aukera idatzi: ");
				aukera = Teklatua.irakurri();

				if (aukera.equals("1")) {
					while (!aukera.equals("2"))
						Kontsola.inprimatu("Zer egin nahi duzu?");
					aukera=Teklatua.irakurri();
					Kontsola.inprimatu("1. buruzagi baten langileen zerrenda kudeatu \n 2. Irten");
					if (aukera.equals("1")) {
						new businessLogic.BuruzagiakKudeaketa().BuruzagiaIrakurri();
					}
				}
				if (aukera.equals("2")) {
					new businessLogic.LangileakKudeaketa().langileaIrakurri();
				}
				if (aukera.equals("3")) {
					new businessLogic.BezeroakKudeaketa().bezeroaIrakurri();
				}
				if (aukera.equals("4")) {
					new businessLogic.EskariakKudeaketa().eskariLerroakIrakurri();
				}
				if (aukera.equals("5")) {
					Kontsola.inprimatu("HURRENGORA ARTE!");
					break;
				}
			}

		} catch (Exception arazoa) {
			Kontsola.inprimatu(arazoa.toString());
		}
	}

	public static void main(String[] args) throws Exception {

		new Kontrolagailua();
	}

}
