package pl.shop.shop.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.shop.shop.entity.Komputer;
import pl.shop.shop.entity.Zasilacz;
import pl.shop.shop.service.KomputerService;
import pl.shop.shop.service.ZasilaczService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/zasilacz")
public class ZasilaczKontroler {
    @Autowired
    private ZasilaczService zasilaczService;

    @Autowired
    private KomputerService komputerService;

    @GetMapping(value="/rest/all", produces="application/json")
    public ResponseEntity<List<Zasilacz>> getAllZasilacz(){
        return ResponseEntity.ok(zasilaczService.findAll());
    }

    @PostMapping("/rest/add")
    public Zasilacz newZasilacz(@RequestBody Zasilacz newZasilacz) {
        return zasilaczService.createZasilaczEntry(newZasilacz);
    }




    @GetMapping("/list")
    public String Zasilaczlist(Model model) {
        List<Zasilacz> Zasilacz = zasilaczService.findAll();
        model.addAttribute("zasilacz", Zasilacz);
        return "zasilacz";
    }
    @RequestMapping(value = "/dodaj", method = RequestMethod.POST)
    public String Zasilaczdodaj(Model model, @RequestParam(value = "zasilaczId") Long zasilaczId, HttpSession session) {
        Long klientId = (Long) session.getAttribute("klientId");
        Komputer komputer;
        if(klientId != null) {
            komputer = komputerService.findByKlientIdAndZlozone(klientId, false).get(0);
            if(komputer != null){
                komputer.setZasilacz(zasilaczService.findById(zasilaczId).get());
                komputerService.createKomputerEntry(komputer);
                return "redirect:/komputer/skladanie";
            }

        }

        return "redirect:/logowanie";
    }




}
