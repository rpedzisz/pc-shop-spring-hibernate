package pl.shop.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.shop.shop.entity.NapedOptyczny;
import pl.shop.shop.repository.NapedOptycznyRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class NapedOptycznyService {
    @Autowired
    private NapedOptycznyRepository NapedOptycznyRepository;

    public List<NapedOptyczny> findAll() {
        return (List<NapedOptyczny>)NapedOptycznyRepository.findAll();
    }
    public Optional<NapedOptyczny> findById(Long NapedOptycznyId) {return NapedOptycznyRepository.findById(NapedOptycznyId);}
    public NapedOptyczny createNapedOptycznyEntry(NapedOptyczny newNapedOptyczny) {
        return NapedOptycznyRepository.save(newNapedOptyczny);
    }
}

