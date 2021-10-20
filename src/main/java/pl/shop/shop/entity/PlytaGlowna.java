package pl.shop.shop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="plytaGlowna")
public class PlytaGlowna {
    @Id
    @SequenceGenerator(name = "mb_sequence", initialValue = 15)
    @GeneratedValue(generator = "mb_sequence")
    private long plytaGlownaId;
    private String obrazek; // sciezka do obrazku
    private String producent;
    private String nazwa;
    private String socket; // join z procesorem
    private String typKsztaltu; //np ATX, microATX, join z obudową
    private String chipset;
    private String typPamieci; //np DDR4, join z ramem
    private int slotyPamieci; // np. 2, nie można przekroczyć przy dodawaniu
    private int maxObslugiwanaIloscPamieci; //też ilość ramu nie może przekroczyć
    private String obslugiwaneSzybkosciPamieci;
    @Column(name="sloty_pcie_x16")
    private int slotyPCIeX16;
    @Column(name="sloty_pcie_x8")
    private int slotyPCIeX8;
    @Column(name="sloty_pcie_x4")
    private int slotyPCIeX4;
    @Column(name="sloty_pcie_x1")
    private int slotyPCIeX1;
    @Column(name="sloty_msata")
    private int slotyMSata; // tu przy wyborze dysków
    @Column(name="sloty_sata")
    private int slotySata6Gb; // tu przy wyborze dysków
    @Column(name="sloty_m2")
    private int slotyM2;
    @Column(name="sloty_usb3")
    private int wejsciaUSB20;
    @Column(name="sloty_usb2")
    private int wejsciaUSB30;


    private float cena;
    @JsonIgnore
    @OneToMany (mappedBy = "plytaGlowna" , fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    @JsonBackReference
    private List<Komputer> komputer;

    public long getPlytaGlownaId() {
        return plytaGlownaId;
    }

    public void setPlytaGlownaId(long plytaGlownaId) {
        this.plytaGlownaId = plytaGlownaId;
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

    public String getTypKsztaltu() {
        return typKsztaltu;
    }

    public void setTypKsztaltu(String typKsztaltu) {
        this.typKsztaltu = typKsztaltu;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getTypPamieci() {
        return typPamieci;
    }

    public void setTypPamieci(String typPamieci) {
        this.typPamieci = typPamieci;
    }

    public int getSlotyPamieci() {
        return slotyPamieci;
    }

    public void setSlotyPamieci(int slotyPamieci) {
        this.slotyPamieci = slotyPamieci;
    }

    public int getMaxObslugiwanaIloscPamieci() {
        return maxObslugiwanaIloscPamieci;
    }

    public void setMaxObslugiwanaIloscPamieci(int maxObslugiwanaIloscPamieci) {
        this.maxObslugiwanaIloscPamieci = maxObslugiwanaIloscPamieci;
    }

    public String getObslugiwaneSzybkosciPamieci() {
        return obslugiwaneSzybkosciPamieci;
    }

    public void setObslugiwaneSzybkosciPamieci(String obslugiwaneSzybkosciPamieci) {
        this.obslugiwaneSzybkosciPamieci = obslugiwaneSzybkosciPamieci;
    }

    public int getSlotyPCIeX16() {
        return slotyPCIeX16;
    }

    public void setSlotyPCIeX16(int slotyPCIeX16) {
        this.slotyPCIeX16 = slotyPCIeX16;
    }

    public int getSlotyPCIeX8() {
        return slotyPCIeX8;
    }

    public void setSlotyPCIeX8(int slotyPCIeX8) {
        this.slotyPCIeX8 = slotyPCIeX8;
    }

    public int getSlotyPCIeX4() {
        return slotyPCIeX4;
    }

    public void setSlotyPCIeX4(int slotyPCIeX4) {
        this.slotyPCIeX4 = slotyPCIeX4;
    }

    public int getSlotyPCIeX1() {
        return slotyPCIeX1;
    }

    public void setSlotyPCIeX1(int slotyPCIeX1) {
        this.slotyPCIeX1 = slotyPCIeX1;
    }

    public int getSlotyMSata() {
        return slotyMSata;
    }

    public void setSlotyMSata(int slotyMSata) {
        this.slotyMSata = slotyMSata;
    }

    public int getSlotySata6Gb() {
        return slotySata6Gb;
    }

    public void setSlotySata6Gb(int slotySata6Gb) {
        this.slotySata6Gb = slotySata6Gb;
    }

    public int getSlotyM2() {
        return slotyM2;
    }

    public void setSlotyM2(int slotyM2) {
        this.slotyM2 = slotyM2;
    }

    public int getWejsciaUSB20() {
        return wejsciaUSB20;
    }

    public void setWejsciaUSB20(int wejsciaUSB20) {
        this.wejsciaUSB20 = wejsciaUSB20;
    }

    public int getWejsciaUSB30() {
        return wejsciaUSB30;
    }

    public void setWejsciaUSB30(int wejsciaUSB30) {
        this.wejsciaUSB30 = wejsciaUSB30;
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
