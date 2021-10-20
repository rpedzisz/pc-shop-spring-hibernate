package pl.shop.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.shop.shop.entity.Zamowienie;
import pl.shop.shop.repository.ZamowienieRepository;

import java.util.List;

@Service
@Component
public class ZamowienieService {
    @Autowired
    private ZamowienieRepository zamowienieRepository;
    public Zamowienie createZamowienie(Zamowienie newZamowienie){
        return zamowienieRepository.save(newZamowienie);
    }
    public List<Zamowienie> findAll(){
        return (List<Zamowienie>) zamowienieRepository.findAll();
    }
    public List<Zamowienie> findAllByKlientId(Long id){
        return zamowienieRepository.findAllByKlientKlientId(id);
    }
}
