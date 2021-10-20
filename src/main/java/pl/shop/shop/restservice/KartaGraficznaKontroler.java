package pl.shop.shop.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.shop.shop.entity.KartaGraficzna;
import pl.shop.shop.entity.Komputer;
import pl.shop.shop.service.KartaGraficznaService;
import pl.shop.shop.service.KomputerService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/gpu")
public class KartaGraficznaKontroler {
    @Autowired
    private KartaGraficznaService kartaGraficznaService;

    @Autowired
    private KomputerService komputerService;

    @GetMapping(value="/rest/all", produces = "application/json")
    ResponseEntity<List<KartaGraficzna>> findAll(){
        return ResponseEntity.ok(kartaGraficznaService.findAll());
    }
    @GetMapping(value="/rest/memory/{memory}", produces = "application/json")
    ResponseEntity<List<KartaGraficzna>> findByMemory(@PathVariable String memory){
        return ResponseEntity.ok(kartaGraficznaService.findByMemory(memory));
    }
    @GetMapping(value="/rest/producent/{producent}", produces = "application/json")
    ResponseEntity<List<KartaGraficzna>> findByProducent(@PathVariable String producent){
        return ResponseEntity.ok(kartaGraficznaService.findByProducent(producent));
    }
    @GetMapping(value="/rest/length/{length}", produces = "application/json")
    ResponseEntity<List<KartaGraficzna>> findByDlugosc(@PathVariable float dlugosc){
        return ResponseEntity.ok(kartaGraficznaService.findByDlugosc(dlugosc));
    }
    @PostMapping("/rest/add")
    public KartaGraficzna newKartaGraficzna(@RequestBody KartaGraficzna newKartaGraficzna) {

        return kartaGraficznaService.createKartaGraficznaEntry(newKartaGraficzna);
    }


    @GetMapping("/list")
    public String GPUlist(Model model) {
        List<KartaGraficzna> kartaGraficzna = kartaGraficznaService.findAll();
        model.addAttribute("kartaGraficzna", kartaGraficzna);
        return "karta_graficzna";
    }
    @RequestMapping(value = "/dodaj", method = RequestMethod.POST)
    public String kartaGraficznadodaj(Model model, @RequestParam(value = "kartaGraficznaId") Long kartaGraficznaId, HttpSession session) {
        Long klientId = (Long) session.getAttribute("klientId");
        Komputer komputer;
        if(klientId != null) {
            komputer = komputerService.findByKlientIdAndZlozone(klientId, false).get(0);
            if(komputer != null){
                komputer.setKartaGraficzna(kartaGraficznaService.findById(kartaGraficznaId).get());
                komputerService.createKomputerEntry(komputer);
                return "redirect:/komputer/skladanie";
            }

        }

        return "redirect:/logowanie";
    }



}
