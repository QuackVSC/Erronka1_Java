package kontrolagailua;

import ikuspegia.Kontsola;

public class Menu {  //Aquí se muestra el menu para que el usuario decida que operación quiere realizar
	public static void menuInprimaketa() {
		Kontsola.inprimatu("\n MENUA");
		Kontsola.inprimatu("--------------------");
		Kontsola.inprimatu("1. Buruzagiak \n");
		Kontsola.inprimatu("2. Langileak \n");
		Kontsola.inprimatu("3. Bezeroak \n");
		Kontsola.inprimatu("4. Bezeroen erosketa \n");
		Kontsola.inprimatu("5. Irten \n");
	}
	
	public static String aukeraIrakurri() { //Aquí se lee la opción seleccionada por el usuario
		String aukera=Teklatua.irakurri();
		return aukera;
		
	}
}
