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

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
public class LogowanieKontroler {
    @Autowired
    private KlientService klientService;

    @GetMapping("/logowanie")
    public String getLoginPage(Model model, HttpSession session){
        Long klientId = (Long) session.getAttribute("klientId");

        Klient klient = new Klient();

        model.addAttribute("klientId", klientId);
        model.addAttribute("klient", klient);
        return "logowanie";
    }

    @GetMapping("/wylogowanie")
    public String getLogoutPage(Model model, HttpSession session){

        session.setAttribute("klientId", null);

        return "redirect:/logowanie";
    }




    @PostMapping("/logowanie")
    public String getLoginPage(Model model, @ModelAttribute Klient klient, HttpSession session){
        model.addAttribute("klient", new Klient());
        Optional<Klient> klient1 = klientService.findByUsernameAndPassword(klient.getUsername(), klient.getPassword());
        if(klient1.isPresent()){
            session.setAttribute("klientId", klient1.get().getKlientId());
            return "redirect:/komputer/skladanie";
        }

        return "redirect:/logowanie";

    }









}