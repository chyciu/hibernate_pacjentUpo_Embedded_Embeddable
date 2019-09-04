package rozwiazanie;

import entity.OsobaUpowazniona;
import entity.Pacjent;

public class Zadanie2_rozwiazanie {

    public static void main(String[] args) {

       //dodjemy pacjenta
        PacjentUpoDAO nowyPacjent = new PacjentUpoDAO();
        nowyPacjent.create("Janek", "Kowal", "9898787656");
        nowyPacjent.create("Ola", "Nowak", "7802345433");

        //dodajemy pacjenta z osobą upoważnioną
        OsobaUpowazniona osobaUpo = new OsobaUpowazniona();
        osobaUpo.setImieUp("Kazik");
        osobaUpo.setNazwiskoUp("Jankowski");
        osobaUpo.setNrDowoduUp("db56566");
        nowyPacjent.createWithUpo1("Ola", "Jankowska", "8903149999", osobaUpo);

        //szukamy pacjenta
        Pacjent szukanyPacjent = nowyPacjent.readByPesel("7802345433");
        System.out.println("Znaleziony pacjent to: " + szukanyPacjent.toString());
        Pacjent szukanyPacjent2 = nowyPacjent.readByPesel("8903149999");
        System.out.println("Znaleziony pacjent to: " + szukanyPacjent2.toString());


        //usuwanie pacjenta (po ID -> Long)
        nowyPacjent.delete(2L);

        //ustawiamy Upo dla osoby 1
        nowyPacjent.createOrUpdateUpo(osobaUpo, "89012098786", 1);
        //ustawiamy Upo dla osoby 2
        nowyPacjent.createOrUpdateUpo(osobaUpo, "89012098786", 2);
        //ustawiamy Upo dla osoby 3
        nowyPacjent.createOrUpdateUpo(osobaUpo, "89012098786", 3);


        //sprawdzamy weryfikację
        boolean statusJeden = nowyPacjent.verifyUpo(osobaUpo, "89012098786");
        System.out.println("Pacjent posiada Upo: " + statusJeden);

        OsobaUpowazniona osobaUpo2 = new OsobaUpowazniona();
        osobaUpo2.setImieUp("Magda");
        osobaUpo2.setNazwiskoUp("Banach");
        osobaUpo2.setNrDowoduUp("AO988767");
        boolean statusDwa = nowyPacjent.verifyUpo(osobaUpo2, "89012098786");

    }
}
