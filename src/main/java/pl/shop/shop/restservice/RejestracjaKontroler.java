package pl.shop.shop.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.shop.shop.entity.Klient;
import pl.shop.shop.entity.Koszyk;
import pl.shop.shop.service.KlientService;
import pl.shop.shop.service.KoszykService;


@Controller
public class RejestracjaKontroler {
    @Autowired
    private KlientService klientService;
    @Autowired
    private KoszykService koszykService;
    @GetMapping("/rejestracja")
    public String getRegisterPage(Model model){
        model.addAttribute("klient", new Klient()); // przekazanie obiektu Klienta pod nazwe "klient"
        return "rejestracja";
    }

    @PostMapping("/rejestracja")
    public String registerUser(@ModelAttribute Klient klient){
        klient.setAdmin(false);
        klientService.createKlientEntry(klient);
        Koszyk koszyk = new Koszyk();
        koszyk.setKlient(klient);
        koszykService.createKoszykEntry(koszyk);

        return "rejestracja";
    }



}