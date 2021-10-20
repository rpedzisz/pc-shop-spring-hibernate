package pl.shop.shop.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.shop.shop.entity.Komputer;
import pl.shop.shop.entity.NapedOptyczny;
import pl.shop.shop.service.KomputerService;
import pl.shop.shop.service.NapedOptycznyService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/naped")
public class NapedOptycznyKontroler {
    @Autowired
    private NapedOptycznyService NapedOptycznyService;

    @Autowired
    private KomputerService komputerService;

    @GetMapping(value="/rest/all", produces="application/json")
    public ResponseEntity<List<NapedOptyczny>> getAllNapedOptyczny(){
        return ResponseEntity.ok(NapedOptycznyService.findAll());
    }

    @PostMapping("/rest/add")
    public NapedOptyczny newNapedOptyczny(@RequestBody NapedOptyczny newNapedOptyczny) {
        return NapedOptycznyService.createNapedOptycznyEntry(newNapedOptyczny);
    }




    @GetMapping("/list")
    public String NapedOptycznylist(Model model) {
        List<NapedOptyczny> NapedOptyczny = NapedOptycznyService.findAll();
        model.addAttribute("napedOptyczny", NapedOptyczny);
        return "naped_optyczny";
    }
    @RequestMapping(value = "/dodaj", method = RequestMethod.POST)
    public String NapedOptycznydodaj(Model model, @RequestParam(value = "napedOptycznyId") Long NapedOptycznyId, HttpSession session) {
        Long klientId = (Long) session.getAttribute("klientId");
        Komputer komputer;
        if(klientId != null) {
            komputer = komputerService.findByKlientIdAndZlozone(klientId, false).get(0);
            if(komputer != null){
                komputer.setNapedOptyczny(NapedOptycznyService.findById(NapedOptycznyId).get());
                komputerService.createKomputerEntry(komputer);
                return "redirect:/komputer/skladanie";
            }

        }

        return "redirect:/logowanie";
    }




}
