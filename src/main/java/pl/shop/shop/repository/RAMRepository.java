package pl.shop.shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.shop.shop.entity.RAM;

import java.util.List;

public interface RAMRepository extends CrudRepository<RAM, Long> {
    List<RAM> findByTypPamieciIgnoreCase(String type);

    List<RAM> findByTaktowanie(int clock);

    List<RAM> findByRozmiarPamieci(int memory);

    List<RAM> findByTypPamieciIgnoreCaseAndTaktowanie(String type, int clock);

    List<RAM> findByTypPamieciIgnoreCaseAndTaktowanieAndRozmiarPamieci(String type, int clock, int memory);
}
