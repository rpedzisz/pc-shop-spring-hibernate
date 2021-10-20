package pl.shop.shop.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.shop.shop.entity.Komputer;
import pl.shop.shop.entity.Obudowa;
import pl.shop.shop.service.KomputerService;
import pl.shop.shop.service.ObudowaService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/obudowa")
public class ObudowaKontroler {
    @Autowired
    private ObudowaService ObudowaService;

    @Autowired
    private KomputerService komputerService;

    @GetMapping(value="/rest/all", produces="application/json")
    public ResponseEntity<List<Obudowa>> getAllObudowa(){
        return ResponseEntity.ok(ObudowaService.findAll());
    }

    @PostMapping("/rest/add")
    public Obudowa newObudowa(@RequestBody Obudowa newObudowa) {
        return ObudowaService.createObudowaEntry(newObudowa);
    }




    @GetMapping("/list")
    public String Obudowalist(Model model) {
        List<Obudowa> Obudowa = ObudowaService.findAll();
        model.addAttribute("obudowa", Obudowa);
        return "obudowa";
    }
    @RequestMapping(value = "/dodaj", method = RequestMethod.POST)
    public String Obudowadodaj(Model model, @RequestParam(value = "obudowaId") Long ObudowaId, HttpSession session) {
        Long klientId = (Long) session.getAttribute("klientId");
        Komputer komputer;
        if(klientId != null) {
            komputer = komputerService.findByKlientIdAndZlozone(klientId, false).get(0);
            if(komputer != null){
                komputer.setObudowa(ObudowaService.findById(ObudowaId).get());
                komputerService.createKomputerEntry(komputer);
                return "redirect:/komputer/skladanie";
            }

        }

        return "redirect:/logowanie";
    }




}
