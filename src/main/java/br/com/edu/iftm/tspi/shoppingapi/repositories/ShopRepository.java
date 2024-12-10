package br.com.edu.iftm.tspi.shoppingapi.repositories;

import br.com.edu.iftm.tspi.shoppingapi.models.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String> {
    List<Shop> findByUserId(String userId);

    List<Shop> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Shop> findByDateBetweenAndTotalGreaterThanEqual(
        LocalDateTime startDate,
        LocalDateTime endDate,
        Double value
    );

    Shop findByItemsProductIdentifier(String productIdentifier);
}
