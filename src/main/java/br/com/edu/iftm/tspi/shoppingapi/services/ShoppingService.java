package br.com.edu.iftm.tspi.shoppingapi.services;

import br.com.edu.iftm.tspi.shoppingapi.exceptions.ResourceNotFoundException;
import br.com.edu.iftm.tspi.shoppingapi.models.Shop;
import br.com.edu.iftm.tspi.shoppingapi.models.dto.ShopDTO;
import br.com.edu.iftm.tspi.shoppingapi.repositories.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShoppingService {
    private final ShopRepository repository;

    public List<ShopDTO> getAll() {
        return repository.findAll().stream().map(ShopDTO::convert).toList();
    }

    public ShopDTO findById(String id) {
        Shop shop = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return ShopDTO.convert(shop);
    }

    public List<ShopDTO> getByUser(String userId) {
        return repository.findByUserId(userId).stream().map(ShopDTO::convert).toList();
    }

    public List<ShopDTO> getByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findByDateBetween(startDate, endDate).stream().map(ShopDTO::convert).toList();
    }

    public ShopDTO findByProductIdentifier(String productIdentifier) {
        Shop shop = repository.findByItemsProductIdentifier(productIdentifier);
        if (shop == null) throw new ResourceNotFoundException();
        return ShopDTO.convert(shop);
    }

    public List<ShopDTO> getByFilters(LocalDateTime startDate, LocalDateTime endDate, Double minValue) {
    List<Shop> shops = repository.findByDateBetweenAndTotalGreaterThanEqual(startDate, endDate, minValue);
    if (shops.isEmpty()) {
        throw new ResourceNotFoundException();
    }

    return shops.stream().map(ShopDTO::convert).collect(Collectors.toList());
}


    public ShopDTO save(ShopDTO dto) {
        Shop shop = ShopDTO.convert(dto);
        shop.setDate(LocalDateTime.now());
        return ShopDTO.convert(repository.save(shop));
    }

    public List<ShopDTO> getReportByDate(LocalDateTime dataInicio, LocalDateTime dataFim) {
    List<Shop> shops = repository.findByDateBetween(dataInicio, dataFim);
    return shops.stream().map(ShopDTO::convert).toList();
}


}
