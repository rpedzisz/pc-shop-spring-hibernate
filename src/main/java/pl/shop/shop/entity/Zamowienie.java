package pl.shop.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="zamowienie")
public class Zamowienie {
    @Id
    @SequenceGenerator(name = "zamowienie_sequence")
    @GeneratedValue(generator = "zamowienie_sequence")
    private long zamowienieId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date dataZamowienia;
    @OneToMany (mappedBy = "zamowienie" , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JsonBackReference
    private List<Komputer> komputerList;
    @ManyToOne
    @JoinColumn(name ="klient_id")
    private Klient klient;

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }



    public long getZamowienieId() {
        return zamowienieId;
    }

    public void setZamowienieId(long zamowienieId) {
        this.zamowienieId = zamowienieId;
    }

    public Date getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(Date dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public List<Komputer> getKomputerList() {
        return komputerList;
    }

    public void setKomputerList(List<Komputer> komputerList) {
        this.komputerList = komputerList;
    }
}
