package pl.shop.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="procesor")
public class Procesor {
    @Id
    @SequenceGenerator(name = "procesor_sequence", initialValue = 15)
    @GeneratedValue(generator = "procesor_sequence")
    private long procesorId;
    private String obrazek; // sciezka do obrazku
    private String producent;
    private String nazwa;
    private String socket; // tu join z procesorem
    private int iloscRdzeni;
    private float taktowanie;
    @Column(name="tdp")
    private int TDP; // zliczane do wyboru zasilacza
    private int maksPamiec; // tego ram nie może przekroczyć
    @Column(name="l1")
    private String l1Cache;
    @Column(name="l2")
    private String l2Cache;
    @Column(name="l3")
    private String l3Cache;
    private String technologia;

    private float cena;
    @JsonIgnore
    @OneToMany (mappedBy = "procesor" , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JsonBackReference
    private List<Komputer> komputer;

    public long getProcesorId() {
        return procesorId;
    }

    public void setProcesorId(long procesorId) {
        this.procesorId = procesorId;
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

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getIloscRdzeni() {
        return iloscRdzeni;
    }

    public void setIloscRdzeni(int iloscRdzeni) {
        this.iloscRdzeni = iloscRdzeni;
    }

    public float getTaktowanie() {
        return taktowanie;
    }

    public void setTaktowanie(float taktowanie) {
        this.taktowanie = taktowanie;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int TDP) {
        this.TDP = TDP;
    }

    public int getMaksPamiec() {
        return maksPamiec;
    }

    public void setMaksPamiec(int maksPamiec) {
        this.maksPamiec = maksPamiec;
    }

    public String getL1Cache() {
        return l1Cache;
    }

    public void setL1Cache(String L1Cache) {
        l1Cache = L1Cache;
    }

    public String getL2Cache() {
        return l2Cache;
    }

    public void setL2Cache(String L2Cache) {
        l2Cache = L2Cache;
    }

    public String getL3Cache() {
        return l3Cache;
    }

    public void setL3Cache(String L3Cache) {
        l3Cache = L3Cache;
    }

    public String getTechnologia() {
        return technologia;
    }

    public void setTechnologia(String technologia) {
        this.technologia = technologia;
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
