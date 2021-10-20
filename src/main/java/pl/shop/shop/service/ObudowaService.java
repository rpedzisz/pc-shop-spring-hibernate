package pl.shop.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.shop.shop.entity.Obudowa;
import pl.shop.shop.repository.ObudowaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class ObudowaService {
    @Autowired
    private ObudowaRepository ObudowaRepository;

    public List<Obudowa> findAll() {
        return (List<Obudowa>)ObudowaRepository.findAll();
    }
    public Optional<Obudowa> findById(Long ObudowaId) {return ObudowaRepository.findById(ObudowaId);}
    public Obudowa createObudowaEntry(Obudowa newObudowa) {
        return ObudowaRepository.save(newObudowa);
    }
}

