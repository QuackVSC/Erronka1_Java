package kontrolagailua;

import ikuspegia.Kontsola;

public class Menu {  //Aquí se muestra el menu para que el usuario decida que operación quiere realizar
	public static void menuInprimaketa() {
		Kontsola.inprimatu("Menua");
		Kontsola.inprimatu("1. Buruzagi baten langileen zerrenda");
		Kontsola.inprimatu("2. Langileak");
		Kontsola.inprimatu("3. Bezeroak");
		Kontsola.inprimatu("4. Bezeroen erosketa");
		Kontsola.inprimatu("5. Irten");
	}
	
	public static String aukeraIrakurri() { //Aquí se lee la opción seleccionada por el usuario
		String aukera=Teklatua.irakurri();
		return aukera;
		
	}
}
