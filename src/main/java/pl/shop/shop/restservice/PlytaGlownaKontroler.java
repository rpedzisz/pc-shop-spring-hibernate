package pl.shop.shop.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.shop.shop.entity.Komputer;
import pl.shop.shop.entity.PlytaGlowna;
import pl.shop.shop.service.KomputerService;
import pl.shop.shop.service.PlytaGlownaService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/mobo")
public class PlytaGlownaKontroler {
    @Autowired
    private PlytaGlownaService plytaGlownaService;

    @Autowired
    private KomputerService komputerService;

    @GetMapping(value="/rest/all", produces="application/json")
    ResponseEntity<List<PlytaGlowna>> findAll(){
        return ResponseEntity.ok(plytaGlownaService.findAll());
    }
    @GetMapping(value="/rest/socket/{socket}", produces="application/json")
    ResponseEntity<List<PlytaGlowna>> findBySocket(@PathVariable String socket){
        return ResponseEntity.ok(plytaGlownaService.findBySocket(socket));
    }
    @GetMapping(value="/rest/chipset/{chipset}", produces="application/json")
    ResponseEntity<List<PlytaGlowna>> findByChipset(@PathVariable String chipset){
        return ResponseEntity.ok(plytaGlownaService.findByChipset(chipset));
    }

    @GetMapping("/list")
    public String MOBOlist(Model model) {
        List<PlytaGlowna> plytaGlowna = plytaGlownaService.findAll();
        model.addAttribute("plytaGlowna", plytaGlowna);
        return "plyta_glowna";
    }
    @RequestMapping(value = "/dodaj", method = RequestMethod.POST)
    public String plytaGlownadodaj(Model model, @RequestParam(value = "plytaGlownaId") Long plytaGlownaId, HttpSession session) {
        Long klientId = (Long) session.getAttribute("klientId");
        Komputer komputer;
        if(klientId != null) {
            komputer = komputerService.findByKlientIdAndZlozone(klientId, false).get(0);
            if(komputer != null){
                komputer.setPlytaGlowna(plytaGlownaService.findById(plytaGlownaId).get());
                komputerService.createKomputerEntry(komputer);
                return "redirect:/komputer/skladanie";
            }

        }

        return "redirect:/logowanie";
    }




}
