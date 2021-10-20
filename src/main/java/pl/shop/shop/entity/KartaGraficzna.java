package pl.shop.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="kartaGraficzna")
public class KartaGraficzna {
    @Id
    @SequenceGenerator(name = "gpu_sequence", initialValue = 15)
    @GeneratedValue(generator = "gpu_sequence")
    private long kartaGraficznaId;
    private String obrazek; // sciezka do obrazku
    private String producent;
    private String nazwa;
    private int rozmiarPamieci; // w MB
    private String typPamieci;
    private int taktowanieProcesora; //w MHZ
    private int taktowaniePamieci; //w MHZ
    private String interfejs; //PCIe x16 join do płyty
    private float dlugosc; //do obudowy w mm
    @Column(name = "tdp")
    private int TDP; // w Watach
    private String zasilanieZewnetrzne;


    private float cena;
    @JsonIgnore
    @OneToMany (mappedBy = "kartaGraficzna" , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JsonBackReference
    private List<Komputer> komputer;

    public long getKartaGraficznaId() {
        return kartaGraficznaId;
    }


    public void setKartaGraficznaId(long kartaGraficznaId) {
        this.kartaGraficznaId = kartaGraficznaId;
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

    public int getRozmiarPamieci() {
        return rozmiarPamieci;
    }

    public void setRozmiarPamieci(int rozmiarPamieci) {
        this.rozmiarPamieci = rozmiarPamieci;
    }

    public String getTypPamieci() {
        return typPamieci;
    }

    public void setTypPamieci(String typPamieci) {
        this.typPamieci = typPamieci;
    }

    public int getTaktowanieProcesora() {
        return taktowanieProcesora;
    }

    public void setTaktowanieProcesora(int taktowanieProcesora) {
        this.taktowanieProcesora = taktowanieProcesora;
    }

    public int getTaktowaniePamieci() {
        return taktowaniePamieci;
    }

    public void setTaktowaniePamieci(int taktowaniePamieci) {
        this.taktowaniePamieci = taktowaniePamieci;
    }

    public String getInterfejs() {
        return interfejs;
    }

    public void setInterfejs(String interfejs) {
        this.interfejs = interfejs;
    }

    public float getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(float dlugosc) {
        this.dlugosc = dlugosc;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int TDP) {
        this.TDP = TDP;
    }

    public String getZasilanieZewnetrzne() {
        return zasilanieZewnetrzne;
    }

    public void setZasilanieZewnetrzne(String zasilanieZewnetrzne) {
        this.zasilanieZewnetrzne = zasilanieZewnetrzne;
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
