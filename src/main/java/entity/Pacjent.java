package entity;

import javax.persistence.*;

    @Entity
    @Table(name = "pacjent")
    public class Pacjent {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        private long id;
        @Column
        private String imie;
        @Column
        private String nazwisko;
        @Column
        private String pesel;

        //mapuje dla Upo1 z klasy OsobaUpowazniona
        @Embedded
        private OsobaUpowazniona osobaUpowazniona1;

        //mapowanie dla Upo2
        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "imieUp", column = @Column(name = "imieUp2")),
                @AttributeOverride(name = "nazwiskoUp", column = @Column(name = "nazwiskoUp2")),
                @AttributeOverride(name = "nrDowoduUp", column = @Column(name = "nrDowUp2")),
                @AttributeOverride(name = "dataDodania", column = @Column(name = "dataDodaniaUp2")),
        })
        private OsobaUpowazniona osobaUpowazniona2;

        //mapowanie dla Upo3
        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "imieUp", column = @Column(name = "imieUp3")),
                @AttributeOverride(name = "nazwiskoUp", column = @Column(name = "nazwiskoUp3")),
                @AttributeOverride(name = "nrDowoduUp", column = @Column(name = "nrDowUp3")),
                @AttributeOverride(name = "dataDodania", column = @Column(name = "dataDodaniaUp3")),
        })
        private OsobaUpowazniona osobaUpowazniona3;


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getImie() {
            return imie;
        }

        public void setImie(String imie) {
            this.imie = imie;
        }

        public String getNazwisko() {
            return nazwisko;
        }

        public void setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
        }

        public String getPesel() {
            return pesel;
        }

        public void setPesel(String pesel) {
            this.pesel = pesel;
        }

        public OsobaUpowazniona getOsobaUpowazniona1() {
            return osobaUpowazniona1;
        }

        public void setOsobaUpowazniona1(OsobaUpowazniona osobaUpowazniona1) {
            this.osobaUpowazniona1 = osobaUpowazniona1;
        }

        public OsobaUpowazniona getOsobaUpowazniona2() {
            return osobaUpowazniona2;
        }

        public void setOsobaUpowazniona2(OsobaUpowazniona osobaUpowazniona2) {
            this.osobaUpowazniona2 = osobaUpowazniona2;
        }

        public OsobaUpowazniona getOsobaUpowazniona3() {
            return osobaUpowazniona3;
        }

        public void setOsobaUpowazniona3(OsobaUpowazniona osobaUpowazniona3) {
            this.osobaUpowazniona3 = osobaUpowazniona3;
        }
    }
