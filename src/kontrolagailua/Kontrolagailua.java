package kontrolagailua;

// Behar ditugun klaseak inportatu
import businessLogic.*;
import ikuspegia.*;

public class Kontrolagailua {

	public Kontrolagailua() throws Exception {

		try {
			// Programa martxan jarri
			run();

		} catch (Exception arazoa) {
			// Errore bat gertatzen bada, pantailan erakutsi
			Kontsola.inprimatu(arazoa.toString());
		}
	}

	private void run() throws Exception {

		try {
			// Erabiltzailea erregistratu edo saioa hasi
			Erregistroa.autentifikatu();

			// Programaren logotipoa erakutsi
			Logotipoa.run();

			// Menu nagusiko eta azpimenuko aukerak gordetzeko aldagaiak
			String aukera = "";
			String aukera2 = "";

			// 5. aukera aukeratu arte menua errepikatu
			while (!aukera.equals("5")) {

				// Menu nagusia pantailan erakutsi
				Menu.menuInprimaketa();

				// Erabiltzaileari aukera eskatu
				Kontsola.inprimatu("Aukera idatzi: ");
				aukera = Teklatua.irakurri();

				// 1. aukera: buruzagi baten informazioa bilatu
				if (aukera.equals("1")) {

					aukera2 = "";

					// 2. aukera aukeratu arte bilaketak errepikatu
					while (!aukera2.equals("2")) {

						// Buruzagiaren informazioa bilatu
						new BuruzagiakKudeaketa().BuruzagiaIrakurri();

						Kontsola.inprimatu("\n \n");

						// Beste bilaketa bat egin edo menu nagusira itzuli
						Kontsola.inprimatu("==========================");
						Kontsola.inprimatu("1. Beste bilaketa bat egin");
						Kontsola.inprimatu("2. Menu nagusira itzuli");
						Kontsola.inprimatu("==========================");

						aukera2 = Teklatua.irakurri();
					}
				}

				// 2. aukera: langile baten informazioa bilatu
				if (aukera.equals("2")) {

					aukera2 = "";

					// 2. aukera aukeratu arte bilaketak errepikatu
					while (!aukera2.equals("2")) {

						// Langilearen informazioa bilatu
						new LangileakKudeaketa().langileaIrakurri();

						Kontsola.inprimatu("\n \n");

						// Beste bilaketa bat egin edo menu nagusira itzuli
						Kontsola.inprimatu("==========================");
						Kontsola.inprimatu("1. Beste bilaketa bat egin");
						Kontsola.inprimatu("2. Menu nagusira itzuli");
						Kontsola.inprimatu("==========================");

						aukera2 = Teklatua.irakurri();
					}
				}

				// 3. aukera: bezero baten informazioa bilatu
				if (aukera.equals("3")) {

					aukera2 = "";

					// 2. aukera aukeratu arte bilaketak errepikatu
					while (!aukera2.equals("2")) {

						// Bezeroaren informazioa bilatu
						new BezeroakKudeaketa().bezeroaIrakurri();

						Kontsola.inprimatu("\n \n");

						// Beste bilaketa bat egin edo menu nagusira itzuli
						Kontsola.inprimatu("==========================");
						Kontsola.inprimatu("1. Beste bilaketa bat egin");
						Kontsola.inprimatu("2. Menu nagusira itzuli");
						Kontsola.inprimatu("==========================");

						aukera2 = Teklatua.irakurri();
					}
				}

				// 4. aukera: faktura sortu
				if (aukera.equals("4")) {

					aukera2 = "";

					// 2. aukera aukeratu arte fakturak sortu
					while (!aukera2.equals("2")) {

						// Eskariaren datuak irakurri eta faktura sortu
						new EskariakKudeaketa().fakturakKudeatu();

						Kontsola.inprimatu("\n \n");

						// Beste faktura bat egin edo menu nagusira itzuli
						Kontsola.inprimatu("==========================");
						Kontsola.inprimatu("1. Beste bilaketa bat egin");
						Kontsola.inprimatu("2. Menu nagusira itzuli");
						Kontsola.inprimatu("==========================");
						aukera2 = Teklatua.irakurri();
					}
				}

				// 5. aukera: programa amaitu
				if (aukera.equals("5")) {

					Kontsola.inprimatu("HURRENGORA ARTE!");
					break;
				}
			}

		} catch (Exception arazoa) {
			// Errore bat gertatzen bada, pantailan erakutsi
			Kontsola.inprimatu(arazoa.toString());
		}
	}

	public static void main(String[] args) throws Exception {

		// Programa abiarazi Kontrolagailua objektu bat sortuz
		new Kontrolagailua();
	}
}