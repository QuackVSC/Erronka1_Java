package kontrolagailua;

import ikuspegia.*;

public class Kontrolagailua {

	public Kontrolagailua() throws Exception {
		try {
			run();
		} catch (Exception e) {
			Kontsola.inprimatu(e.toString());
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
					new businessLogic.LangileakKudeaketa().langileaIrakurri();
				}
				if (aukera.equals("2")) {

				}
				if (aukera.equals("3")) {

				}
				if (aukera.equals("4")) {

				}
				if (aukera.equals("5")) {

				}
				if(aukera.equals("6")) {
					Menu.menuInprimaketa();
				}
			}

		} catch (Exception e) {
			Kontsola.inprimatu(e.toString());
		}
	}

	public static void main(String[] args) throws Exception {
		new Kontrolagailua();
	}

}
