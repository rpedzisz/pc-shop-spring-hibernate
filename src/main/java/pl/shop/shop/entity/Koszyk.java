package pl.shop.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="koszyk")
public class Koszyk {
    @Id
    @SequenceGenerator(name = "koszyk_sequence", initialValue = 2)
    @GeneratedValue(generator = "koszyk_sequence")
    private long koszykId;

    @OneToOne
    @JoinColumn(name = "klientId")
    private Klient klient;

    @OneToMany (mappedBy = "koszyk" , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JsonBackReference
    private List<Komputer> komputer;


    private float cena=0;

    public void obliczCeneRazem(){
        cena=0;
        if(komputer.size() > 0){
            for(int i = 0; i< komputer.size(); i++){
                cena += komputer.get(i).getCena();
            }

        }

    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public List<Komputer> getKomputer() {
        return komputer;
    }

    public void setKomputer(List<Komputer> komputer) {
        this.komputer = komputer;
    }

    private boolean ukonczone;

    public long getKoszykId() {
        return koszykId;
    }

    public void setKoszykId(long koszykId) {
        this.koszykId = koszykId;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public boolean isUkonczone() {
        return ukonczone;
    }

    public void setUkonczone(boolean ukonczone) {
        this.ukonczone = ukonczone;
    }
}
