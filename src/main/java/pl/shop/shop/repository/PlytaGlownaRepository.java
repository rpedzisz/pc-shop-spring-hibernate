package pl.shop.shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.shop.shop.entity.PlytaGlowna;

import java.util.List;

public interface PlytaGlownaRepository extends CrudRepository<PlytaGlowna, Long> {
    List<PlytaGlowna> findBySocketIgnoreCase(String socket);

    List<PlytaGlowna> findByChipsetContainingIgnoreCase(String chipset);
}
