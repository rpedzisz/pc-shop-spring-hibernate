package pl.shop.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="komputer")
public class Komputer {
    @Id
    @SequenceGenerator(name = "komputer_sequence", initialValue = 3)
    @GeneratedValue(generator = "komputer_sequence")
    private long komputerId;
    private boolean zlozone; // czy wszystkie czesci sa, jak tak to mozna dodac do koszyka

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="klient_id")
    private Klient klient;

    @ManyToOne
    @JoinColumn(name ="koszyk_id", nullable = true)
    private Koszyk koszyk;
    @ManyToOne
    @JoinColumn(name="zamowienie_id", nullable = true)
    private Zamowienie zamowienie;


    @ManyToOne
    @JoinColumn(name ="plyta_glowna_id", nullable = true)
    private PlytaGlowna plytaGlowna;

    @ManyToOne
    @JoinColumn(name ="procesor_id", nullable = true)
    private Procesor procesor;


    @ManyToMany
    @JoinTable(
            name = "komputer_ram",
            joinColumns = @JoinColumn(name = "komputerId"),
            inverseJoinColumns = @JoinColumn(name = "ramId")
    )
    private List<RAM> ram;

    @ManyToOne
    @JoinColumn(name ="zasilacz_id", nullable = true)
    private Zasilacz zasilacz;

    @ManyToOne
    @JoinColumn(name ="dysk_id", nullable = true)
    private Dysk dysk;

    @ManyToOne
    @JoinColumn(name ="karta_graficzna_id", nullable = true)
    private KartaGraficzna kartaGraficzna;

    @ManyToOne
    @JoinColumn(name ="naped_optyczny_id", nullable = true)
    private NapedOptyczny napedOptyczny;

    @ManyToOne
    @JoinColumn(name ="obudowa_id", nullable = true)
    private Obudowa obudowa;

    private float cena=0;

    public void obliczCene(){
        cena=0;
        for (int i=0; i<ram.size(); i++){
            if(ram.get(i) != null) {
                cena += ram.get(i).getCena();
            }

        }
        if(plytaGlowna != null) cena+=plytaGlowna.getCena();
        if(procesor != null) cena+=procesor.getCena();
        if(zasilacz != null) cena+=zasilacz.getCena();
        if(dysk != null) cena+=dysk.getCena();
        if(kartaGraficzna != null) cena+=kartaGraficzna.getCena();
        if(napedOptyczny != null) cena+=napedOptyczny.getCena();
        if(obudowa != null) cena+=obudowa.getCena();


    }



    public long getKomputerId() {
        return komputerId;
    }

    public void setKomputerId(long komputerId) {
        this.komputerId = komputerId;
    }

    public boolean isZlozone() {
        return zlozone;
    }

    public void setZlozone(boolean zlozone) {
        this.zlozone = zlozone;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Koszyk getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(Koszyk koszyk) {
        this.koszyk = koszyk;
    }

    public PlytaGlowna getPlytaGlowna() {
        return plytaGlowna;
    }

    public void setPlytaGlowna(PlytaGlowna plytaGlowna) {
        this.plytaGlowna = plytaGlowna;
    }

    public Procesor getProcesor() {
        return procesor;
    }

    public void setProcesor(Procesor procesor) {
        this.procesor = procesor;
    }

    public List<RAM> getRam() {
        return ram;
    }

    public void setRam(List<RAM> ram) {
        this.ram = ram;
    }

    public Zasilacz getZasilacz() {
        return zasilacz;
    }

    public void setZasilacz(Zasilacz zasilacz) {
        this.zasilacz = zasilacz;
    }

    public Dysk getDysk() {
        return dysk;
    }

    public void setDysk(Dysk dysk) {
        this.dysk = dysk;
    }

    public KartaGraficzna getKartaGraficzna() {
        return kartaGraficzna;
    }

    public void setKartaGraficzna(KartaGraficzna kartaGraficzna) {
        this.kartaGraficzna = kartaGraficzna;
    }

    public NapedOptyczny getNapedOptyczny() {
        return napedOptyczny;
    }

    public void setNapedOptyczny(NapedOptyczny napedOptyczny) {
        this.napedOptyczny = napedOptyczny;
    }

    public Obudowa getObudowa() {
        return obudowa;
    }

    public void setObudowa(Obudowa obudowa) {
        this.obudowa = obudowa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }
}
