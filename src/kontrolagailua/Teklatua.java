package kontrolagailua;

import java.io.FileReader;
import java.util.Scanner;

public class Teklatua { /*Aquí se crea un código que sirve para leer siempre lo que se necesite sin necesidad de crear 
	un escaner nuevo*/
	
	static Scanner sc = new Scanner(System.in);

	public static String irakurri() {
		return sc.nextLine();
	}
	
	public static String irakurri(FileReader fr) {
		return sc.nextLine();
	}
	
	public static Integer irakurriZenbakia() {
		return sc.nextInt();
	}
}