package kontrolagailua;

import ikuspegia.Kontsola;

public class Menu {  //Aquí se muestra el menu para que el usuario decida que operación quiere realizar
	public static void menuInprimaketa() {
		Kontsola.inprimatu("Menua");
		Kontsola.inprimatu("1. Langileak");
		Kontsola.inprimatu("2. Bezeroak");
		Kontsola.inprimatu("3. Bezeroen telefonoa");
		Kontsola.inprimatu("4. Eskaria");
		Kontsola.inprimatu("5. Eskari lerroa");
	}
	
	public static String aukeraIrakurri() { //Aquí se lee la opción seleccionada por el usuario
		String aukera=Teklatua.irakurri();
		return aukera;
		
	}
}
