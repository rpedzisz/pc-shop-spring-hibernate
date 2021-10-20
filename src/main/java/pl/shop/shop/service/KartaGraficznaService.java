package pl.shop.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.shop.shop.entity.KartaGraficzna;
import pl.shop.shop.repository.KartaGraficznaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class KartaGraficznaService {
    @Autowired
    private KartaGraficznaRepository kartaGraficznaRepository;

    public List<KartaGraficzna> findAll() {
        return (List<KartaGraficzna>) kartaGraficznaRepository.findAll();
    }
    public Optional<KartaGraficzna> findById(Long KartaGraficznaId) {return kartaGraficznaRepository.findById(KartaGraficznaId);}

    public List<KartaGraficzna> findByMemory(String memory) {
        return kartaGraficznaRepository.findByTypPamieciIgnoreCase(memory);
    }

    public List<KartaGraficzna> findByProducent(String producent) {
        return kartaGraficznaRepository.findByProducentIgnoreCase(producent);
    }

    public List<KartaGraficzna> findByDlugosc(float dlugosc) {
        return kartaGraficznaRepository.findByDlugosc(dlugosc);
    }

    public KartaGraficzna createKartaGraficznaEntry(KartaGraficzna newKartaGraficzna) {
        return kartaGraficznaRepository.save(newKartaGraficzna);
    }
}
