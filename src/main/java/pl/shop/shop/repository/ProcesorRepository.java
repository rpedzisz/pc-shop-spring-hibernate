package pl.shop.shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.shop.shop.entity.Procesor;

import java.util.List;

public interface ProcesorRepository extends CrudRepository<Procesor, Long> {
    public List<Procesor> findBySocketIgnoreCase(String socket);
    public List<Procesor> findByProducentIgnoreCase(String producent);

    public List<Procesor> findByIloscRdzeni(int cores);
}
