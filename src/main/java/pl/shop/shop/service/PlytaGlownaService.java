package pl.shop.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.shop.shop.entity.PlytaGlowna;
import pl.shop.shop.repository.PlytaGlownaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class PlytaGlownaService {
    @Autowired
    private PlytaGlownaRepository plytaGlownaRepository;
    public List<PlytaGlowna> findAll() {
        return (List<PlytaGlowna>) plytaGlownaRepository.findAll();
    }
    public Optional<PlytaGlowna> findById(Long plytaId) {return plytaGlownaRepository.findById(plytaId);}
    public List<PlytaGlowna> findBySocket(String socket) {
        return plytaGlownaRepository.findBySocketIgnoreCase(socket);
    }

    public List<PlytaGlowna> findByChipset(String chipset) {
        return plytaGlownaRepository.findByChipsetContainingIgnoreCase(chipset);
    }
}
