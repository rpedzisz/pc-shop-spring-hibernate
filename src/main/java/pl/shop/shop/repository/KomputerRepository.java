package pl.shop.shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.shop.shop.entity.Komputer;

import java.util.List;
import java.util.Optional;


public interface KomputerRepository extends CrudRepository<Komputer, Long> {

List<Komputer> findByKlientKlientIdAndZlozone(Long klientId, boolean zlozone);
Optional<Komputer> findByKlientKlientId(Long klientId);

}