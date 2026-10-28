package logotipo;

public class Logotipoa {
	public Integer Altuera = 4; 

	public Logotipoa() {

	}

	public void run() {
		piramide1();
		piramide2();
		piramide3();
		piramide4();
		piramide5();
	}

	private void piramide1() {
		// Lehen piramide honetan alderantzikatuta egin behar dut, hasieran espaziorik
		// ez izatea eragiten duena ("m" horregatik hasten da zeroan eta igotzen doa)
		// eta nire * has zaitezte Altueran zehaztutako zabalerarekin k
		for (Integer n = 0; n < Altuera; ++n) { // Beti lehen for (n) -ak altuera neurtzen du Altuera-n jarritako
												// zenbakiaren arabera
			for (Integer m = 0; m < n + 1; ++m)
				// Espazioak jartzen ditu
				System.out.print(" ");
			for (Integer k = Altuera * 2 - 1; k >= (2 * n + 1); k--) {
				// (2* n - 1) piramideak modu simetrikoan sor ditzan jartzen ditu asterikoak,
				// adibidean agertzen den 1,3,5,7 ordenaren arabera.
				System.out.print("*");

			}
			System.out.println();// Markatu lerroaren amaiera hurrengora pasatzeko

		}
	}

	private void piramide2() {
		// Lehenengoaren berdina da, baina logika alderantzikatuz,
		// espazio askorekin eta gutxi batzuekin * enpizatzen du, baina erreb.
		// termiatzen dute

		for (Integer n = 0; n < Altuera; ++n) {
			for (Integer m = 0; m < Altuera - n; ++m)
				System.out.print(" ");
			for (Integer k = -1; k <= (2 * n - 1); k++) {

				System.out.print("*");

			}
			System.out.println();

		}
	}

	private void piramide3() {
		// Piramide hori zertxobait desberdina da, eta beste logika bat erabiltzen du;
		// lehenik eta behin, espazio batzuek ezkerreko hutsunea
		// betetzen dute, eta, kasu honetan* espazio baten ihesa duen println lerroa
		// gainditzen du; bigarren lerroan gauza bera egiten du,
		// baina jauziaren erdien eta espazioen artean 2 For daude; bat 0 an hasten da,
		// eta, hortik aurrera, ezkerreko zatia * betetzen du,
		// eta erdian, piramide normal bat balitz bezala, espazioak jartzen ditu. x
		// altua amaitzean, zoru bat jartzen da
		for (Integer n = 0; n < Altuera + 1; ++n) {
			for (Integer m = 0; m < Altuera - n; ++m)
				System.out.print(" ");
			if (n >= 1) {
				for (Integer p = 0; p < 1; ++p)
					System.out.print("*");
			}
			if (n >= Altuera) {
				System.out.print("*".repeat(Altuera * 2 - 1));
				// Azalpena: 3. eta 4. pirmaide horiek lurrean dauden beste guztiak baino lerro
				// bat altuagoak dira,
				// eta adibidean 4. piramidea beste guztiak bezain altua da, baina Andonik esan
				// zidan ondo dagoela.
			} else {
				for (Integer k = 0; k <= (2 * n - 2); k++) {
					System.out.print(" ");
				}
			}

			System.out.println("*");

		}
	}

	private void piramide4() {
		// Laukizuzena da, eta Altuera +1 bezalako espazio zabalak ditu. Hori dela eta,
		// erdian* lerroak salto egiten du, eta, amaitzean, zorua aurreko piramidean
		// bezala jartzen da.

		for (Integer n = 0; n < Altuera + 1; ++n) {

			if (n >= Altuera) {
				System.out.print("*".repeat(Altuera * 2));
			} else {
				for (Integer m = Altuera + n - 1; m >= n; --m)
					System.out.print(" ");
			}

			System.out.println("*");

		}
	}

	private void piramide5() {
		// da 3 primidea soru barik
		for (Integer n = 0; n < Altuera; ++n) {
			for (Integer m = 0; m < Altuera - n; ++m)
				System.out.print(" ");
			if (n >= 1) {
				for (Integer p = 0; p < 1; ++p)
					System.out.print("*");
			}
			for (Integer k = 0; k <= (2 * n - 2); k++) {
				System.out.print(" ");

			}
			System.out.println("*");

		}

	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Logotipoa lg = new Logotipoa();
		lg.run();
	}

}
