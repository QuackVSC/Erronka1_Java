
package businessLogic;

// Behar ditugun klaseak inportatu
import eredua.Eskariak;
import ikuspegia.Kontsola;
import kontrolagailua.Teklatua;

import java.io.*;
import java.util.*;

public class EskariakKudeaketa {

    // Eskariak irakurri eta faktura sortu
    public void fakturakKudeatu() throws Exception {
        eskariLerroakIrakurri();
        fakturaSortu();
    }

    // Eskarien zerrenda gordetzeko
    private List<Eskariak> zerrenda;

    // Eskari baten produktuak irakurri
    public List<Eskariak> eskariLerroakIrakurri() throws Exception {

        // Zerrenda huts bat sortu
        zerrenda = new ArrayList<Eskariak>();

        String idEskaria;
        boolean aurkitua = false;

        // Eskariaren ID-a eskatu eta bilatu
        do {

            Kontsola.inprimatu("Sartu eskariaren ID-a:");
            idEskaria = Teklatua.irakurri();

            try {

                // Produktuen fitxategia ireki
                FileReader irakurriEskariLerroakFitxategia = new FileReader(eredua.Fitxategiak.bidea("ESKARI_LERROAK.txt"));

                // Fitxategia lerroz lerro irakurri
                BufferedReader irakurriZatiHandiaEskariLerroak = new BufferedReader(irakurriEskariLerroakFitxategia);

                // Lehenengo lerroa saltatu (izenburuak)
                irakurriZatiHandiaEskariLerroak.readLine();

                String lerroa;

                // Fitxategiko lerro guztiak irakurri
                while ((lerroa = irakurriZatiHandiaEskariLerroak.readLine()) != null) {

                    // Lerroko datuak banatu
                    String[] tokenak = lerroa.split("\t");

                    // Eskariaren ID-a berdina den begiratu
                    if (idEskaria.equals(tokenak[0])) {

                        // Datuak objektu batean gorde
                        Eskariak eskariak = kapsulatuDatuak(tokenak);

                        // Eskariaren data bilatu
                        String data = eskariakIrakurri(eskariak.getZenbakia());

                        // Data objektuan gorde
                        eskariak.setData(data);

                        // Produktua zerrendan gehitu
                        zerrenda.add(eskariak);

                        aurkitua = true;
                    }
                }

                // Fitxategiak itxi
                irakurriZatiHandiaEskariLerroak.close();
                irakurriEskariLerroakFitxategia.close();

            } catch (Exception arazoa) {

                // Errorea pantailan erakutsi
                Kontsola.inprimatu(arazoa.toString());
            }

            // Eskaria aurkitu ez bada, abisua erakutsi
            if (!aurkitua) {
                Kontsola.inprimatu("ID hori duen eskaririk ez da existitzen. Saiatu berriro.");
            }

        } while (!aurkitua);

        // Aurkitutako produktuen zerrenda itzuli
        return zerrenda;
    }

    // Eskariaren data bilatu
    public String eskariakIrakurri(String idEskaria) throws Exception {

        String data = null;

        try {

            // Eskarien fitxategia ireki
            FileReader irakurriEskariakFitxategia = new FileReader(eredua.Fitxategiak.bidea("ESKARIAK.txt"));

            // Fitxategia lerroz lerro irakurri
            BufferedReader irakurriZatiHandiaEskariak = new BufferedReader(irakurriEskariakFitxategia);

            // Lehenengo lerroa saltatu
            irakurriZatiHandiaEskariak.readLine();

            String lerroa;

            // Fitxategiko lerro guztiak irakurri
            while ((lerroa = irakurriZatiHandiaEskariak.readLine()) != null) {

                // Lerroko datuak banatu
                String[] tokenak = lerroa.split("\t");

                // Eskariaren ID-a bilatu
                if (idEskaria.equals(tokenak[1])) {

                    // Eskariaren data gorde
                    data = tokenak[3];

                    break;
                }
            }

            // Fitxategiak itxi
            irakurriZatiHandiaEskariak.close();
            irakurriEskariakFitxategia.close();

        } catch (Exception arazoa) {

            // Errorea pantailan erakutsi
            Kontsola.inprimatu(arazoa.toString());
        }

        // Data itzuli
        return data;
    }

    // Fitxategiko datuak Eskariak objektuan gorde
    private Eskariak kapsulatuDatuak(String[] tokenak) {

        Eskariak eskariak = new Eskariak();

        // Produktuaren datuak objektuan gorde
        eskariak.setZenbakia(tokenak[0]);
        eskariak.setProduktua(tokenak[2]);
        eskariak.setKopurua(Integer.valueOf(tokenak[3]));

        // Prezioaren koma puntuz aldatu
        String prezioZuzena = tokenak[4].replace(",", ".");

        // Prezioa zenbaki batean bihurtu
        eskariak.setPrezioa(Double.valueOf(prezioZuzena));

        // Objektua itzuli
        return eskariak;
    }

    // Faktura sortu, erakutsi eta fitxategian gorde
    public void fakturaSortu() throws Exception {

        // Fakturaren guztizkoa kalkulatzeko
        double guztira = 0;

        // Fakturaren testua gordetzeko
        String faktura = "";

        // Fakturaren goiburua sortu
        faktura += "==============================\n";
        faktura += "          GAMESTOP\n";
        faktura += "           FAKTURA\n";
        faktura += "==============================\n\n";

        // Eskariaren zenbakia eta data erakutsi
        faktura += "Eskari zenbakia: " + zerrenda.get(0).getZenbakia() + "\n";
        faktura += "Eskari data: " + zerrenda.get(0).getData() + "\n\n";

        // Produktu guztiak banan-banan irakurri
        for (Eskariak eskariak : zerrenda) {

            // Produktuaren datuak fakturan gehitu
            faktura += "------------------------------\n";
            faktura += "Produktua: " + eskariak.getProduktua() + "\n";
            faktura += "Kopurua: " + eskariak.getKopurua() + "\n";
            faktura += "Prezioa: " + eskariak.getPrezioa() + " €\n";

            // Produktuaren prezioa guztizkoari gehitu
            guztira += eskariak.getKopurua() * eskariak.getPrezioa();
        }

        // Fakturaren guztizkoa gehitu
        faktura += "------------------------------\n";
        faktura += "GUZTIRA: " + String.format("%.2f", guztira) + " €\n";
        faktura += "==============================\n";

        // Faktura kontsolan erakutsi
        Kontsola.inprimatu(faktura);

        // Faktura fitxategian gorde
        FileWriter fitxategia = new FileWriter(eredua.Fitxategiak.bidea("FAKTURAK.txt"), true);

        // Fakturaren testua fitxategian idatzi
        fitxategia.write(faktura);

        // Fitxategia itxi
        fitxategia.close();

        // Faktura gorde dela erakutsi
        Kontsola.inprimatu("Faktura gordeta.");
    }
}
