package pl.shop.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.shop.shop.entity.Dysk;
import pl.shop.shop.repository.DyskRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class DyskService {
    @Autowired
    private DyskRepository DyskRepository;

    public Dysk createDyskEntry(Dysk newEntry) {
        return DyskRepository.save(newEntry);
    }

    public Optional<Dysk> findById(Long DyskId){
        return DyskRepository.findById(DyskId);
    }

    public List<Dysk> findAll(){
        return (List<Dysk>) DyskRepository.findAll();
    }



}
