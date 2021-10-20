package pl.shop.shop.restservice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeKontroler {

    @GetMapping("/index")
    public String getIndex(Model model, HttpSession session){

        return "index";
    }


    @GetMapping("/sesja")
    public String getSesja(Model model, HttpSession session){

        model.addAttribute("id", session.getId());
        model.addAttribute("sesja_klientId", session.getAttribute("klientId"));
        return "sesja";
    }



@GetMapping("/sesja/{klientId}")
    public String setSesja(Model model, HttpSession session, @PathVariable Long klientId){
    session.setAttribute("klientId", klientId);

    model.addAttribute("sesja_klientId", session.getAttribute("klientId"));
    return "sesja";
}





}
