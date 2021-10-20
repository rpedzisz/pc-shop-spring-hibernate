package pl.shop.shop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.shop.shop.entity.Koszyk;
import pl.shop.shop.repository.KoszykRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class KoszykService {
    @Autowired
    private KoszykRepository koszykRepository;
    public Koszyk createKoszykEntry(Koszyk newEntry){
        return koszykRepository.save(newEntry);
    }
    public List<Koszyk> findAll(){
        return (List<Koszyk>) koszykRepository.findAll();
    }
    public Optional<Koszyk> findById(Long koszykId){
        return koszykRepository.findById(koszykId);
    }
    public Optional<Koszyk> findByKlientId(Long klientId){return  koszykRepository.findByKlientKlientId(klientId);}



}
