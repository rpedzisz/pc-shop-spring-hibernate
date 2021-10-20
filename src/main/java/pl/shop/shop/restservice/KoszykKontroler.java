package pl.shop.shop.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.shop.shop.entity.Klient;
import pl.shop.shop.entity.Komputer;
import pl.shop.shop.entity.Koszyk;
import pl.shop.shop.service.KlientService;
import pl.shop.shop.service.KomputerService;
import pl.shop.shop.service.KoszykService;

import javax.servlet.http.HttpSession;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/koszyk")
public class KoszykKontroler {
    @Autowired
    private KoszykService koszykService;

    @Autowired
    private KlientService klientService;

    @Autowired
    private KomputerService komputerService;

    @GetMapping(value = "/rest/all", produces = "application/json")
    public ResponseEntity<List<Koszyk>> getAllCarts(){
        return ResponseEntity.ok(koszykService.findAll());
    }
    @GetMapping(value = "/rest/{id}", produces = "application/json")
    public ResponseEntity<Koszyk> getCartById(@PathVariable Long id){
        Optional<Koszyk> koszyk = koszykService.findById(id);
        return ResponseEntity.ok(koszyk.get());
    }

    @GetMapping(value = "/list")
    public String getCustomerCart(HttpSession session, Model model){


        Long klientId = (Long) session.getAttribute("klientId");
        if (klientId != null) {
            Optional<Koszyk> koszyk = koszykService.findByKlientId(klientId);
            List<Komputer> komputery = koszyk.get().getKomputer();

            koszyk.get().obliczCeneRazem();
            model.addAttribute("koszyk", koszyk.get());
            model.addAttribute("komputery", komputery);

            return "koszyk";
        }

        return "redirect:/logowanie";
    }



    @RequestMapping (value = "/dodaj")
    public String addToCart(HttpSession session){
        Long klientId = (Long) session.getAttribute("klientId");

        Komputer komputer = komputerService.findByKlientIdAndZlozone(klientId, false).get(0);
        if(
                (komputer.getRam().size() !=0)  &&
                (komputer.getDysk() != null)    &&
                (komputer.getKartaGraficzna() != null) &&
                (komputer.getNapedOptyczny()!= null) &&
                (komputer.getObudowa() != null) &&
                (komputer.getPlytaGlowna() != null) &&
                (komputer.getProcesor() != null) &&
                (komputer.getZasilacz() != null) &&
                (komputer.getKoszyk() == null)


        ){
            komputer.setZlozone(true);
            komputer.setKoszyk(koszykService.findByKlientId(klientId).get());
            komputerService.createKomputerEntry(komputer);

            return "redirect:/koszyk/list";
        }


        return "redirect:/komputer/skladanie";
    }

    @RequestMapping (value = "/usun", method = RequestMethod.POST)
    public String removeFromCart(HttpSession session, @RequestParam(name = "delete") String delete){
        Long klientId = (Long) session.getAttribute("klientId");
        Komputer komputer = komputerService.findById(Long.parseLong(delete)).get();
        if(komputer.getKlient().getKlientId() == klientId) {
            komputer.setKoszyk(null);
            komputer.setKlient(null);
            komputerService.createKomputerEntry(komputer);
            komputerService.deleteById(Long.parseLong(delete));
        }
            return "redirect:/koszyk/list";

    }

















}
