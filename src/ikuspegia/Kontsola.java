package ikuspegia;

public class Kontsola { /*Aquí se cea un código que cuando se haga uso de él inprimirá un texto o número sin necesidad
 de escribir siempre IO.println()*/
	
	public static void inprimatu(String mezua) {

		IO.println(mezua);
	}

	public static void inprimatu(Integer zenbakia) {

		IO.println(zenbakia);
	}
	
	public static void inprimatu(Double zenbakiHamartarra) {
		IO.println(zenbakiHamartarra);
	}
	
	public static void inprimatu(Object objektua){
		IO.println(objektua.toString());
	}
}
