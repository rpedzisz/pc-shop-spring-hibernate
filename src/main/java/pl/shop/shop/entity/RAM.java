package pl.shop.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ram")
public class RAM {
    @Id
    @SequenceGenerator(name = "ram_sequence", initialValue = 15)
    @GeneratedValue(generator = "ram_sequence")
    private long ramId;
    private String obrazek; // sciezka do obrazku
    private String nazwa;
    private String producent;
    private int rozmiarPamieci; //np 16GB
    private int taktowanie; //np 3200
    private String typPamieci; //np DDR4
    @Column(name="cas")
    private int CAS;
    private float napiecie;
    private String timingi;

    private float cena;
    @JsonIgnore
    @ManyToMany(mappedBy = "ram")
    @JsonBackReference
    private List<Komputer> komputer;

    public long getRamId() {
        return ramId;
    }

    public void setRamId(long ramId) {
        this.ramId = ramId;
    }

    public String getObrazek() {
        return obrazek;
    }

    public void setObrazek(String obrazek) {
        this.obrazek = obrazek;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public int getRozmiarPamieci() {
        return rozmiarPamieci;
    }

    public void setRozmiarPamieci(int rozmiarPamieci) {
        this.rozmiarPamieci = rozmiarPamieci;
    }

    public int getTaktowanie() {
        return taktowanie;
    }

    public void setTaktowanie(int taktowanie) {
        this.taktowanie = taktowanie;
    }

    public String getTypPamieci() {
        return typPamieci;
    }

    public void setTypPamieci(String typPamieci) {
        this.typPamieci = typPamieci;
    }

    public int getCAS() {
        return CAS;
    }

    public void setCAS(int CAS) {
        this.CAS = CAS;
    }

    public float getNapiecie() {
        return napiecie;
    }

    public void setNapiecie(float napiecie) {
        this.napiecie = napiecie;
    }

    public String getTimingi() {
        return timingi;
    }

    public void setTimingi(String timingi) {
        this.timingi = timingi;
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
