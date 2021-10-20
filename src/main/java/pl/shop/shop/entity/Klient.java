package pl.shop.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="klient")
public class Klient {
    @Id
    @SequenceGenerator(name = "klient_sequence", initialValue = 6)
    @GeneratedValue(generator = "klient_sequence")
    private long klientId;
    private String imie;
    private String nazwisko;
    private String adres;
    private String miasto;
    private String nrKartaKredytowa;
    private String username;
    private String password;
    private boolean admin = false;
    @OneToMany(mappedBy = "klient",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Zamowienie> zamowienie;

    public List<Zamowienie> getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(List<Zamowienie> zamowienie) {
        this.zamowienie = zamowienie;
    }

    @OneToMany (mappedBy = "klient" , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JsonBackReference
    private List<Komputer> komputer;

    @OneToOne(mappedBy = "klient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Koszyk koszyk;


    public String getNrKartaKredytowa() {
        return nrKartaKredytowa;
    }


    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getKlientId() {
        return klientId;
    }

    public void setKlientId(long klientId) {
        this.klientId = klientId;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public void setnrKartaKredytowa(String nrKartaKredytowa) {
        this.nrKartaKredytowa = nrKartaKredytowa;
    }

    public List<Komputer> getKomputer() {
        return komputer;
    }

    public void setKomputer(List<Komputer> komputer) {
        this.komputer = komputer;
    }

    public Koszyk getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(Koszyk koszyk) {
        this.koszyk = koszyk;
    }
}
