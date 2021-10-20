package pl.shop.shop.repository;

import org.springframework.data.repository.CrudRepository;
import pl.shop.shop.entity.Klient;

import java.util.Optional;


public interface KlientRepository extends CrudRepository<Klient, Long> {
    Optional<Klient> findByUsernameAndPassword(String username, String password);

}

