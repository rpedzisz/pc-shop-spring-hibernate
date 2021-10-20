package pl.shop.shop.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.shop.shop.entity.Komputer;
import pl.shop.shop.entity.Procesor;
import pl.shop.shop.service.KomputerService;
import pl.shop.shop.service.ProcesorService;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.util.List;

@Controller
@RequestMapping("/cpu")
public class ProcesorKontroler {
    @Autowired
    private ProcesorService procesorService;

    @Autowired
    private KomputerService komputerService;

    @GetMapping(value="/rest/all", produces="application/json")
    public ResponseEntity<List<Procesor>> getAllProcesor(){
        return ResponseEntity.ok(procesorService.findAll());
    }

    @GetMapping(value="/rest/socket/{socket}", produces="application/json")
    public ResponseEntity<List<Procesor>> getAllProcesorBySocket(@PathVariable String socket){
        return ResponseEntity.ok(procesorService.findBySocket(socket));
    }
    @GetMapping(value="/rest/producent/{producent}", produces="application/json")
    public ResponseEntity<List<Procesor>> getAllProcesorByProducent(@PathVariable String producent){
        return ResponseEntity.ok(procesorService.findByProducent(producent));}
    @GetMapping(value="/rest/cores/{cores}", produces="application/json")
    public ResponseEntity<List<Procesor>> getAllProcesorByCores(@PathVariable int cores){
        return ResponseEntity.ok(procesorService.findByIloscRdzeni(cores));}
    @PostMapping(value = "/rest/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Procesor> newProcesor(@RequestBody Procesor newProcesor) {

        return ResponseEntity.ok(procesorService.createProcesorEntry(newProcesor));
    }
    @DeleteMapping("/rest/delete/{id}")
    public ResponseEntity<Long> deleteCpu(@PathVariable Long id){
        boolean isRemoved = procesorService.delete(id);
        if(!isRemoved){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(id, HttpStatus.OK);
    }
    @RequestMapping(value="/rest/put/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Procesor> updateProcesor(@PathVariable("id") long id, @RequestBody Procesor procesor){
        return ResponseEntity.ok(procesorService.createProcesorEntry(procesor));
    }




    @GetMapping("/list")
    public String CPUlist(Model model) {
        List<Procesor> procesor = procesorService.findAll();
        model.addAttribute("procesor", procesor);
        return "procesor";
    }
    @RequestMapping(value = "/dodaj", method = RequestMethod.POST)
    public String Procesordodaj(Model model, @RequestParam(value = "procesorId") Long procesorId, HttpSession session) {
        Long klientId = (Long) session.getAttribute("klientId");
        Komputer komputer;
        if(klientId != null) {
            komputer = komputerService.findByKlientIdAndZlozone(klientId, false).get(0);
            if(komputer != null){
                komputer.setProcesor(procesorService.findById(procesorId).get());
                komputerService.createKomputerEntry(komputer);
                return "redirect:/komputer/skladanie";
            }

        }

        return "redirect:/logowanie";
    }




}
