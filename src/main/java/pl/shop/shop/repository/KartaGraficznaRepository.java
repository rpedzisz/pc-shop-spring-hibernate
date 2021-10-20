package pl.shop.shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.shop.shop.entity.KartaGraficzna;

import java.util.List;


public interface KartaGraficznaRepository extends CrudRepository<KartaGraficzna, Long> {


    List<KartaGraficzna> findByTypPamieciIgnoreCase(String memory);

    List<KartaGraficzna> findByProducentIgnoreCase(String producent);

    List<KartaGraficzna> findByDlugosc(float dlugosc);
}