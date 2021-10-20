package pl.shop.shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.shop.shop.entity.Zamowienie;

import java.util.List;

public interface ZamowienieRepository extends CrudRepository <Zamowienie, Long> {
    List<Zamowienie> findAllByKlientKlientId(Long id);
}
