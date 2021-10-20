package pl.shop.shop.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.shop.shop.entity.Komputer;
import pl.shop.shop.entity.Dysk;
import pl.shop.shop.service.KomputerService;
import pl.shop.shop.service.DyskService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/dysk")
public class DyskKontroler {
    @Autowired
    private DyskService DyskService;

    @Autowired
    private KomputerService komputerService;

    @GetMapping(value="/rest/all", produces="application/json")
    public ResponseEntity<List<Dysk>> getAllDysk(){
        return ResponseEntity.ok(DyskService.findAll());
    }

    @PostMapping(value = "/rest/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dysk> newDysk(@RequestBody Dysk newDysk) {
        return ResponseEntity.ok(DyskService.createDyskEntry(newDysk));
    }




    @GetMapping("/list")
    public String Dysklist(Model model) {
        List<Dysk> Dysk = DyskService.findAll();
        model.addAttribute("dysk", Dysk);
        return "dysk";
    }
    @RequestMapping(value = "/dodaj", method = RequestMethod.POST)
    public String Dyskdodaj(Model model, @RequestParam(value = "dyskId") Long DyskId, HttpSession session) {
        Long klientId = (Long) session.getAttribute("klientId");
        Komputer komputer;
        if(klientId != null) {
            komputer = komputerService.findByKlientIdAndZlozone(klientId, false).get(0);
            if(komputer != null){
                komputer.setDysk(DyskService.findById(DyskId).get());
                komputerService.createKomputerEntry(komputer);
                return "redirect:/komputer/skladanie";
            }

        }

        return "redirect:/logowanie";
    }




}
