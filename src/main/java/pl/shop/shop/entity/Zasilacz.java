package pl.shop.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="zasilacz")
public class Zasilacz {
    @Id
    @SequenceGenerator(name = "psu_sequence", initialValue = 15)
    @GeneratedValue(generator = "psu_sequence")
    private long zasilaczId;
    private String obrazek; // sciezka do obrazku
    private String producent;
    private String nazwa;
    private String typKsztaltu;
    private int moc; // musi być większe niż grafika + procesor
    @Column(name="eps")
    private int zlaczaEps;
    @Column(name="pcie_plus")
    private int zlaczaPcie6Plus2;
    @Column(name="sata")
    private int zlaczaSata;
    @Column(name="molex")
    private int zlaczaMolex4Pin;

    private float cena;
    @JsonIgnore
    @OneToMany (mappedBy = "zasilacz" , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JsonBackReference
    private List<Komputer> komputer;

    public long getZasilaczId() {
        return zasilaczId;
    }

    public void setZasilaczId(long zasilaczId) {
        this.zasilaczId = zasilaczId;
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

    public String getTypKsztaltu() {
        return typKsztaltu;
    }

    public void setTypKsztaltu(String typKsztaltu) {
        this.typKsztaltu = typKsztaltu;
    }

    public int getMoc() {
        return moc;
    }

    public void setMoc(int moc) {
        this.moc = moc;
    }

    public int getZlaczaEps() {
        return zlaczaEps;
    }

    public void setZlaczaEps(int zlaczaEps) {
        this.zlaczaEps = zlaczaEps;
    }

    public int getZlaczaPcie6Plus2() {
        return zlaczaPcie6Plus2;
    }

    public void setZlaczaPcie6Plus2(int zlaczaPcie6Plus2) {
        this.zlaczaPcie6Plus2 = zlaczaPcie6Plus2;
    }

    public int getZlaczaSata() {
        return zlaczaSata;
    }

    public void setZlaczaSata(int zlaczaSata) {
        this.zlaczaSata = zlaczaSata;
    }

    public int getZlaczaMolex4Pin() {
        return zlaczaMolex4Pin;
    }

    public void setZlaczaMolex4Pin(int zlaczaMolex4Pin) {
        this.zlaczaMolex4Pin = zlaczaMolex4Pin;
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
