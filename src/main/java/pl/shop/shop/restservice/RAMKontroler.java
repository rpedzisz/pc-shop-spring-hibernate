package pl.shop.shop.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.shop.shop.entity.Komputer;
import pl.shop.shop.entity.RAM;
import pl.shop.shop.service.KomputerService;
import pl.shop.shop.service.RAMService;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/ram")
public class RAMKontroler {
    @Autowired
    private RAMService ramService;
    @Autowired
    private KomputerService komputerService;

    @GetMapping(value="/all", produces="application/json")
    public ResponseEntity<List<RAM>> findAll() {
        return ResponseEntity.ok((List<RAM>) ramService.findAll());
    }
    @GetMapping(value="/type/{type}", produces="application/json")
    public ResponseEntity<List<RAM>> findByTyp(@PathVariable String type){
        return ResponseEntity.ok((List<RAM>) ramService.findByTyp(type));
    }
    @GetMapping(value="/clock/{clock}", produces="application/json")
    public ResponseEntity<List<RAM>> findByTaktowanie(@PathVariable int clock){
        return ResponseEntity.ok((List<RAM>) ramService.findByTaktowanie(clock));
    }
    @GetMapping(value="/memory/{memory}", produces="application/json")
    public ResponseEntity<List<RAM>> findByRozmiarPamieci(@PathVariable int memory){
        return ResponseEntity.ok((List<RAM>) ramService.findByRozmiarPamieci(memory));
    }
    @GetMapping(value="/type/{type}/clock/{clock}", produces="application/json")
    public ResponseEntity<List<RAM>> findByTypPamieciAndTaktowanie(@PathVariable String type, @PathVariable int clock){
        return ResponseEntity.ok((List<RAM>) ramService.findByTypPamieciAndTaktowanie(type,clock));
    }
    @GetMapping(value="/type/{type}/clock/{clock}/memory/{memory}", produces="application/json")
    public ResponseEntity<List<RAM>> findByTypPamieciAndTaktowanieAndPamiec(@PathVariable String type, @PathVariable int clock, @PathVariable int memory){
        return ResponseEntity.ok((List<RAM>) ramService.findByTypPamieciAndTaktowanieAndRozmiarPamieci(type,clock, memory));
    }
    @PostMapping("/add")
    public RAM newRAM(@RequestBody RAM newRAM) {

        return ramService.createRAMEntry(newRAM);
    }

    @GetMapping("/list")
    public String RAMlist(Model model) {
        List<RAM> ram = ramService.findAll();
        model.addAttribute("ram", ram);
        return "ram";
    }

    @RequestMapping(value = "/dodaj", method = RequestMethod.POST)
    public String RAMdodaj(Model model, @RequestParam(value = "ram_Id") Long ramId, HttpSession session) {
        Long klientId = (Long) session.getAttribute("klientId");
        Komputer komputer;
        if(klientId != null) {
            komputer = komputerService.findByKlientIdAndZlozone(klientId, false).get(0);
            if(komputer != null){
                komputer.getRam().add(ramService.findById(ramId).get());
                komputerService.createKomputerEntry(komputer);
                return "redirect:/komputer/skladanie";
            }

        }


        return "redirect:/logowanie";
    }






}
