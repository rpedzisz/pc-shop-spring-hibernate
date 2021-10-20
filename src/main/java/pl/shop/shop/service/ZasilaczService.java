package pl.shop.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.shop.shop.entity.Zasilacz;
import pl.shop.shop.repository.ZasilaczRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class ZasilaczService {
    @Autowired
    private ZasilaczRepository zasilaczRepository;

    public List<Zasilacz> findAll() {
        return (List<Zasilacz>)zasilaczRepository.findAll();
    }
    public Optional<Zasilacz> findById(Long ZasilaczId) {return zasilaczRepository.findById(ZasilaczId);}
    public Zasilacz createZasilaczEntry(Zasilacz newZasilacz) {
        return zasilaczRepository.save(newZasilacz);
    }
}
