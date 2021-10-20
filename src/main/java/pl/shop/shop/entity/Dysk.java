package pl.shop.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dysk")
public class Dysk {
    @Id
    @SequenceGenerator(name = "dysk_sequence", initialValue = 15)
    @GeneratedValue(generator = "dysk_sequence")
    private long dyskId;
    private String obrazek; // sciezka do obrazku
    private String producent;
    private String nazwa;
    private int pojemnosc; // 2tb
    private String typ; //7200rpm lub SSD
    private int cache; // w mb
    private String wspolczynnikKsztaltu; // np. 3.5 cala join z obudową
    private String interfejs; // np SATA 6Gb, albo mSata join z plytą główną



    private float cena;
    @JsonIgnore
    @OneToMany (mappedBy = "dysk" , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JsonBackReference
    private List<Komputer> komputer;

    public long getDyskId() {
        return dyskId;
    }

    public void setDyskId(long dyskId) {
        this.dyskId = dyskId;
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

    public float getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    public String getWspolczynnikKsztaltu() {
        return wspolczynnikKsztaltu;
    }

    public void setWspolczynnikKsztaltu(String wspolczynnikKsztaltu) {
        this.wspolczynnikKsztaltu = wspolczynnikKsztaltu;
    }

    public String getInterfejs() {
        return interfejs;
    }

    public void setInterfejs(String interfejs) {
        this.interfejs = interfejs;
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
