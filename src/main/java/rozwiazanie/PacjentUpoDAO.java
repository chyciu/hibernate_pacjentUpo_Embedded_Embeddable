package rozwiazanie;

import entity.OsobaUpowazniona;
import entity.Pacjent;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.time.LocalDate;

public class PacjentUpoDAO {

    public Pacjent create(String imie, String nazwisko, String pesel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Pacjent nowyPacjent = new Pacjent();
        nowyPacjent.setImie(imie);
        nowyPacjent.setNazwisko(nazwisko);
        nowyPacjent.setPesel(pesel);
        session.persist(nowyPacjent);
        session.flush();
        tr.commit();
        session.close();
        return nowyPacjent;
    }

    public Pacjent createWithUpo1 (String imie, String nazwisko, String pesel, OsobaUpowazniona osobaUpo1) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Pacjent nowyPacjent = new Pacjent();
        nowyPacjent.setImie(imie);
        nowyPacjent.setNazwisko(nazwisko);
        nowyPacjent.setPesel(pesel);
        osobaUpo1.setDataDodania(Date.valueOf(LocalDate.now()));
        nowyPacjent.setOsobaUpowazniona1(osobaUpo1);
        session.persist(nowyPacjent);
        session.flush();
        tr.commit();
        session.close();
        return nowyPacjent;
    }

    public Pacjent readByPesel (String pesel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Pacjent pacjentRead = session.createQuery("FROM Pacjent p WHERE p.pesel=:pesel", Pacjent.class)
                .setParameter("pesel", pesel).getSingleResult();

        session.close();
        return pacjentRead;
    }

    public void update (String imie, String nazwisko, String pesel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.createQuery("UPDATE Pacjent p SET p.imie=:imie, " +
                "p.nazwisko=:nazwisko, WHERE p.pesel=:pesel")
                .setParameter("imie", imie).setParameter("nazwisko", nazwisko)
                .setParameter("pesel", pesel).executeUpdate();

        tr.commit();
        session.close();
    }


    public void delete (Long ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Pacjent pacjent = new Pacjent();
        pacjent.setId(ID);
        session.delete(pacjent);
        tr.commit();
        session.close();
    }

    public void createOrUpdateUpo (OsobaUpowazniona osobaUpo, String pesel, int L) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Pacjent pacjentZBazyDanych = session.createQuery("FROM Pacjent p WHERE p.pesel=:pesel",
                Pacjent.class).setParameter("pesel", pesel).getSingleResult();

        if (L == 1) {
            pacjentZBazyDanych.setOsobaUpowazniona1(osobaUpo);
        } else if (L ==2) {
            pacjentZBazyDanych.setOsobaUpowazniona2(osobaUpo);
        } else if (L == 3) {
            pacjentZBazyDanych.setOsobaUpowazniona3(osobaUpo);
        }

        session.merge(pacjentZBazyDanych);
        tr.commit();
        session.close();
    }

    public boolean verifyUpo (OsobaUpowazniona osobaUpo, String pesel) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Pacjent pacjentDB = session.createQuery("FROM Pacjent p WHERE p.pesel=:pesel",
                Pacjent.class).setParameter("pesel", pesel).getSingleResult();
        boolean status = false;
        if (osobaUpo.equals(pacjentDB.getOsobaUpowazniona1())) {
            status = true;
        } else if (osobaUpo.equals(pacjentDB.getOsobaUpowazniona2())) {
            status = true;
        } else if (osobaUpo.equals(pacjentDB.getOsobaUpowazniona3())) {
            status = true;
        }

        session.close();
        return status;
    }

}


//    Każdy pacjent może upoważnić 3 osoby do wglądu do swojej dokumentacji medycznej (odpowiednio osoba1 UpoI, osoba2 UpoII, osoba3 UpoIII)
//
//        zadanie 1
//        Odwzoruj tabele w encji. Użyj do tego @Embedded/@Embeddable

//        zadanie 2
//        Dodaj klasę PacjentUpoDAO, która będzie miała metody:
//        -CRUD (create, read, update, delete)
//        -insertOrUpdate stwórz 3 metody (dla Upo 1-3) które będą przyjmowały obiekt OsobaUpo (z polami imie, nazwisko, nrDowodu); każda metoda będzie dodawała lub aktualizowała dane dla odpowiedniego upo; metoda powinna wstawiać automatycznie datę dodania
//
//        zadanie 3
//        Stwórz metode verfyUpo, która będzie przyjmowała obiekt OsobaUpo (z poprzedniego zadania) i będzie zwracał:
//        • true jeśli dana osoba jest upoważniona w którymkolwiek upoważnieniu od 1 do 3; należy sprawdzić wszystkie pola tzn imię, nazwisko i nr dowodu
//        • false w przeciwnym razie
