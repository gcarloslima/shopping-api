package br.com.edu.iftm.tspi.shoppingapi.controllers;

import br.com.edu.iftm.tspi.shoppingapi.models.dto.ShopDTO;
import br.com.edu.iftm.tspi.shoppingapi.services.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/shopping")
@RequiredArgsConstructor
public class ShoppingController {
    private final ShoppingService service;

    @GetMapping
    public ResponseEntity<List<ShopDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ShopDTO> save(@RequestBody ShopDTO shopDTO) {
        return new ResponseEntity<>(service.save(shopDTO), HttpStatus.CREATED);
    }

    @GetMapping("/shopByUser")
    public ResponseEntity<List<ShopDTO>> getByUser(@RequestParam String userId) {
        return ResponseEntity.ok(service.getByUser(userId));
    }

    @GetMapping("/shopByDate")
    public ResponseEntity<List<ShopDTO>> getByDate(@RequestParam LocalDateTime startDate,
                                                   @RequestParam LocalDateTime endDate) {
        return ResponseEntity.ok(service.getByDate(startDate, endDate));
    }

    @GetMapping("/product/{productIdentifier}")
    public ResponseEntity<ShopDTO> findByProductIdentifier(@PathVariable String productIdentifier) {
        return ResponseEntity.ok(service.findByProductIdentifier(productIdentifier));
    }

    @GetMapping("/shopping/search")
    public ResponseEntity<List<ShopDTO>> getByFilters(
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate,
            @RequestParam Double minValue) {
        return ResponseEntity.ok(service.getByFilters(startDate, endDate, minValue));
    }

    @GetMapping("/shopping/report")
    public ResponseEntity<List<ShopDTO>> getReportByDate(
            @RequestParam LocalDateTime dataInicio,
            @RequestParam LocalDateTime dataFim) {
        return ResponseEntity.ok(service.getReportByDate(dataInicio, dataFim));
    }


}
