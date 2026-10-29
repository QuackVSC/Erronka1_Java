package kontrolagailua;

import ikuspegia.*;

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
			String aukera = "";

			Menu.menuInprimaketa();
			while (!aukera.equals("7")) {
				Kontsola.inprimatu("Aukera idatzi");
				aukera = Teklatua.irakurri();

				if (aukera.equals("1")) {
					new businessLogic.BuruzagiakKudeaketa().BuruzagiaIrakurri();
				}
				if (aukera.equals("2")) {
					new businessLogic.LangileakKudeaketa().langileaIrakurri();
				}
				if (aukera.equals("3")) {
					new businessLogic.BezeroakKudeaketa().bezeroaIrakurri();
				}
				if (aukera.equals("4")) {
					new businessLogic.EskariakKudeaketa().eskariaIrakurri();
				}
				if (aukera.equals("5")) {
					break;
				}
				if (aukera.equals("6")) {
					Menu.menuInprimaketa();
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
