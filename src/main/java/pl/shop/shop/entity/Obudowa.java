package pl.shop.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="obudowa")
public class Obudowa {
    @Id
    @SequenceGenerator(name = "case_sequence", initialValue = 15)
    @GeneratedValue(generator = "case_sequence")
    private long obudowaId;
    private String obrazek; // sciezka do obrazku
    private String producent;
    private String nazwa;
    private String kolor;
    private String typKsztaltu; // ATX, microATX
    private float maxDlugoscGrafiki; // tu też trzeba uważać xd np 280.3mm
    @Column(name="sloty_25")
    private int sloty25Cala;
    @Column(name="sloty_35")
    private int sloty35Cala;

    private float cena;
    @JsonIgnore
    @OneToMany (mappedBy = "obudowa" , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JsonBackReference
    private List<Komputer> komputer;

    public long getObudowaId() {
        return obudowaId;
    }

    public void setObudowaId(long obudowaId) {
        this.obudowaId = obudowaId;
    }

    public String getObrazek() {
        return obrazek;
    }

    public void setObrazek(String obrazek) {
        this.obrazek = obrazek;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public String getTypKsztaltu() {
        return typKsztaltu;
    }

    public void setTypKsztaltu(String typKsztaltu) {
        this.typKsztaltu = typKsztaltu;
    }

    public float getMaxDlugoscGrafiki() {
        return maxDlugoscGrafiki;
    }

    public void setMaxDlugoscGrafiki(float maxDlugoscGrafiki) {
        this.maxDlugoscGrafiki = maxDlugoscGrafiki;
    }

    public int getSloty25Cala() {
        return sloty25Cala;
    }

    public void setSloty25Cala(int sloty25Cala) {
        this.sloty25Cala = sloty25Cala;
    }

    public int getSloty35Cala() {
        return sloty35Cala;
    }

    public void setSloty35Cala(int sloty35Cala) {
        this.sloty35Cala = sloty35Cala;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
    @JsonIgnore
    public List<Komputer> getKomputer() {
        return komputer;
    }
    @JsonIgnore
    public void setKomputer(List<Komputer> komputer) {
        this.komputer = komputer;
    }
}
