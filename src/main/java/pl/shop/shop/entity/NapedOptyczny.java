package pl.shop.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="napedOptyczny")
public class NapedOptyczny {
    @Id
    @SequenceGenerator(name = "naped_sequence", initialValue = 15)
    @GeneratedValue(generator = "naped_sequence")
    private long napedOptycznyId;
    private String obrazek; // sciezka do obrazku
    private String producent;
    private String nazwa;
    private String interfejs;
    private float typKsztaltu; //np 5.25 cala
    private int cache;
    private int szybkosc;

    private float cena;
    @JsonIgnore
    @OneToMany (mappedBy = "napedOptyczny" , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JsonBackReference
    private List<Komputer> komputer;


    public float getTypKsztaltu() {
        return typKsztaltu;
    }

    public void setTypKsztaltu(float typKsztaltu) {
        this.typKsztaltu = typKsztaltu;
    }

    public long getNapedOptycznyId() {
        return napedOptycznyId;
    }

    public void setNapedOptycznyId(long napedOptyczny_id) {
        this.napedOptycznyId = napedOptyczny_id;
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

    public String getInterfejs() {
        return interfejs;
    }

    public void setInterfejs(String interfejs) {
        this.interfejs = interfejs;
    }


    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    public int getSzybkosc() {
        return szybkosc;
    }

    public void setSzybkosc(int szybkosc) {
        this.szybkosc = szybkosc;
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
