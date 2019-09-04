package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;
import java.util.Objects;

@Embeddable
    public class OsobaUpowazniona {
        @Column (name = "imieUp1")
        private String imieUp;
        @Column (name = "nazwiskoUp1")
        private String nazwiskoUp;
        @Column (name = "nrDowUp1")
        private String nrDowoduUp;
        @Column (name = "dataDodaniaUp1")
        private Date dataDodania;

    public String getImieUp() {
        return imieUp;
    }

    public void setImieUp(String imieUp) {
        this.imieUp = imieUp;
    }

    public String getNazwiskoUp() {
        return nazwiskoUp;
    }

    public void setNazwiskoUp(String nazwiskoUp) {
        this.nazwiskoUp = nazwiskoUp;
    }

    public String getNrDowoduUp() {
        return nrDowoduUp;
    }

    public void setNrDowoduUp(String nrDowoduUp) {
        this.nrDowoduUp = nrDowoduUp;
    }

    public Date getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Date dataDodania) {
        this.dataDodania = dataDodania;
    }


    @Override
    public String toString() {
        return "OsobaUpowazniona{" +
                "imieUp='" + imieUp + '\'' +
                ", nazwiskoUp='" + nazwiskoUp + '\'' +
                ", nrDowoduUp='" + nrDowoduUp + '\'' +
                ", dataDodania=" + dataDodania +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OsobaUpowazniona osobaUpowazniona = (OsobaUpowazniona) o;
        return Objects.equals(imieUp, osobaUpowazniona.imieUp) &&
                Objects.equals(nazwiskoUp, osobaUpowazniona.nazwiskoUp) &&
                Objects.equals(nrDowoduUp, osobaUpowazniona.nrDowoduUp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imieUp, nazwiskoUp, nrDowoduUp);
    }
}
