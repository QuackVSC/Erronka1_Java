
package kontrolagailua;

import ikuspegia.Kontsola;

public class Menu {

	// Menu nagusia pantailan erakutsi
	public static void menuInprimaketa() {

		// Menuaren goiko marra erakutsi
		Kontsola.inprimatu("=================================");

		// GameStop-en logotipoa erakutsi
		Kontsola.inprimatu("  __  __  _____  _   _  _   _   ");
		Kontsola.inprimatu(" |  \\/  || ____|| \\ | || | | |  ");
		Kontsola.inprimatu(" | |\\/| ||  _|  |  \\| || | | |  ");
		Kontsola.inprimatu(" | |  | || |___ | |\\  || |_| |  ");
		Kontsola.inprimatu(" |_|  |_||_____||_| \\_| \\___/   ");

		// Menuaren aukerak erakutsi
		Kontsola.inprimatu("\n=================================\n");
		Kontsola.inprimatu("1. Buruzagiak \n");
		Kontsola.inprimatu("2. Langileak \n");
		Kontsola.inprimatu("3. Bezeroak \n");
		Kontsola.inprimatu("4. Bezeroen erosketa \n");
		Kontsola.inprimatu("5. Irten \n");

		// Menuaren beheko marra erakutsi
		Kontsola.inprimatu("=================================");
	}

	// Erabiltzaileak aukeratutako aukera irakurri
	public static String aukeraIrakurri() {

		// Teklatutik sartutako aukera jaso
		String aukera = Teklatua.irakurri();

		// Aukera itzuli
		return aukera;
	}
}
