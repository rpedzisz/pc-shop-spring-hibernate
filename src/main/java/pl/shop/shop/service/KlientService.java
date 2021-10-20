package pl.shop.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.shop.shop.entity.Klient;
import pl.shop.shop.repository.KlientRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class KlientService {
    @Autowired
    private KlientRepository KlientRepository;

    public Klient createKlientEntry(Klient newEntry) {
        return KlientRepository.save(newEntry);
    }

    public List<Klient> findAll(){
        return (List<Klient>) KlientRepository.findAll();
    }

    public Optional<Klient> findById(Long KlientId){
        return KlientRepository.findById(KlientId);
    }

    public Optional<Klient> findByUsernameAndPassword(String username, String password){
        return KlientRepository.findByUsernameAndPassword(username,password);
    }
}
