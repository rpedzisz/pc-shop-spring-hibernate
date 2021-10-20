package pl.shop.shop.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.shop.shop.entity.Klient;
import pl.shop.shop.entity.Komputer;
import pl.shop.shop.entity.RAM;
import pl.shop.shop.service.KlientService;
import pl.shop.shop.service.KomputerService;
import pl.shop.shop.service.RAMService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/komputer")
public class KomputerKontroler {
    @Autowired
    private KomputerService KomputerService;
    @Autowired
    private KlientService klientService;
    @Autowired
    private RAMService ramService;



    @GetMapping(value = "/rest/all", produces = "application/json")
    public ResponseEntity<List<Komputer>> getAllKomputer() {
        return ResponseEntity.ok(KomputerService.findAll());
    }

    @GetMapping(value = "/rest/{id}", produces = "application/json")
    public ResponseEntity<Komputer> getKomputerById(@PathVariable Long id) {
        Optional<Komputer> Komputer = KomputerService.findById(id);
        return ResponseEntity.ok(Komputer.get());
    }


    @GetMapping(value = "/rest/zlozone/{klientid}", produces = "application/json")
    public ResponseEntity<List<Komputer>> getKomputerByKlientIdZlozone(@PathVariable Long klientid) {
        List<Komputer> komputery = KomputerService.findByKlientIdAndZlozone(klientid, true);

        return ResponseEntity.ok(komputery);
    }

    @GetMapping(value = "/rest/niezlozone/{klientid}", produces = "application/json")
    public ResponseEntity<List<Komputer>> getKomputerForKlient(@PathVariable Long klientid) {
        List<Komputer> komputery = KomputerService.findByKlientIdAndZlozone(klientid, false);



        return ResponseEntity.ok(komputery);
    }

    @PostMapping("/rest/add")
    public Komputer newKomputer(@RequestBody Komputer newKomputer) {

        return KomputerService.createKomputerEntry(newKomputer);
    }



    @GetMapping(value = "/skladanie", produces = "application/json")
    public String getKomputerForKlientTemplate( Model model, HttpSession session) {
        Long klientid = (Long) session.getAttribute("klientId");
        if (klientid != null) {
            List<Komputer> komputery = KomputerService.findByKlientIdAndZlozone(klientid, false);
            Komputer komputer;
            List<RAM> ram = new ArrayList<RAM>();

            if (!komputery.isEmpty()) {
                komputer = komputery.get(0);
                komputer.obliczCene();
                ram = komputer.getRam();
                KomputerService.createKomputerEntry(komputer);


            } else {
                komputer = new Komputer();

                Optional<Klient> klient = klientService.findById(klientid);
                komputer.setKlient(klient.get());
                komputer.setZlozone(false);
                komputer.setCena(0);
                komputer.setRam(ram);
                KomputerService.createKomputerEntry(komputer);


            }



            model.addAttribute("komputer", komputer);
            model.addAttribute("ram", ram);
            return "komputer";

        }
        return "redirect:/logowanie";
    }

    @RequestMapping(value = "/skladanie/usun", method = RequestMethod.POST)
    public String usunCzesci(Model model, HttpSession session, @RequestParam(name = "delete") String delete){
        Long klientId = (Long) session.getAttribute("klientId");

       Komputer komputer = KomputerService.findByKlientIdAndZlozone(klientId, false).get(0);

        if(delete.equals("dysk"))
        {
            komputer.setDysk(null);
        }
        if(delete.equals("plyta_glowna"))
        {
            komputer.setPlytaGlowna(null);
        }
        if(delete.equals("karta_graficzna"))
        {
            komputer.setKartaGraficzna(null);
        }
        if(delete.equals("procesor"))
        {
            komputer.setProcesor(null);
        }
        if(delete.equals("naped_optyczny"))
        {
            komputer.setNapedOptyczny(null);
        }
        if(delete.equals("zasilacz"))
        {
            komputer.setZasilacz(null);
        }
        if(delete.equals("obudowa"))
        {
            komputer.setObudowa(null);
        }

        komputer.obliczCene();
        KomputerService.createKomputerEntry(komputer);


        model.addAttribute("komputer", komputer);
        return "redirect:/komputer/skladanie";
    }

    @RequestMapping(value = "/skladanie/usunram", method = RequestMethod.POST)
    public String usunRam(Model model, HttpSession session, @RequestParam(name = "delete_ram") String delete){
        Long klientId = (Long) session.getAttribute("klientId");

        Komputer komputer = KomputerService.findByKlientIdAndZlozone(klientId, false).get(0);
        List<RAM> ram = komputer.getRam();

        if(ram != null) {
            if (ram.size() > 0) {
                ram.remove(Integer.parseInt(delete));
                komputer.setRam(ram);
            } else {
                komputer.setRam(null);
            }
        }




        KomputerService.createKomputerEntry(komputer);


        model.addAttribute("komputer", komputer);
        return "redirect:/komputer/skladanie";
    }






}