package pl.shop.shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.shop.shop.entity.Koszyk;

import java.util.Optional;


public interface KoszykRepository extends CrudRepository<Koszyk, Long> {
    Optional<Koszyk> findByKlientKlientId(Long klientId);

}
