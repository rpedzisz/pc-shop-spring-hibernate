package pl.shop.shop.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.shop.shop.entity.Klient;
import pl.shop.shop.service.KlientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/klient")
public class KlientKontroler {
    @Autowired
    private KlientService klientService;



    @GetMapping(value = "/rest/all", produces = "application/json")
    public ResponseEntity<List<Klient>> getAllClients() {
        return ResponseEntity.ok(klientService.findAll());
    }

    @GetMapping(value = "/rest/{id}", produces = "application/json")
    public ResponseEntity<Klient> getClientById(@PathVariable Long id) {
        Optional<Klient> klient = klientService.findById(id);
        return ResponseEntity.ok(klient.get());
    }

    @PostMapping("/rest/add")
    public Klient newClient(@RequestBody Klient newKlient) {

        return klientService.createKlientEntry(newKlient);
    }




}