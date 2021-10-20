package pl.shop.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.shop.shop.entity.Procesor;
import pl.shop.shop.repository.ProcesorRepository;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class ProcesorService {
    @Autowired
    private ProcesorRepository procesorRepository;
    

    public List<Procesor> findAll() {
        return (List<Procesor>)procesorRepository.findAll();
    }
    public Optional<Procesor> findById(Long procesorId) {return procesorRepository.findById(procesorId);}
    public List<Procesor> findBySocket(String socket) {return (List<Procesor>) procesorRepository.findBySocketIgnoreCase(socket);}
    public List<Procesor> findByProducent(String producent) {return (List<Procesor>) procesorRepository.findByProducentIgnoreCase(producent);}

    public List<Procesor> findByIloscRdzeni(int cores) {return (List<Procesor>) procesorRepository.findByIloscRdzeni(cores);}

    public Procesor createProcesorEntry(Procesor newProcesor) {
        return procesorRepository.save(newProcesor);
    }

    public boolean delete(Long id) {
        if (procesorRepository.findById(id)!=null) {
            procesorRepository.deleteById(id);
            return true;
        }
        else return false;
    }

}
