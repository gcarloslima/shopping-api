package br.com.edu.iftm.tspi.shoppingapi.models.dto;

import br.com.edu.iftm.tspi.shoppingapi.models.ProductItem;
import br.com.edu.iftm.tspi.shoppingapi.models.Shop;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShopDTO {
    private String id;
    private String userId;
    private List<ProductItem> items;
    private Double total;
    private LocalDateTime date;

    public static ShopDTO convert(Shop shop) {
        ShopDTO dto = new ShopDTO();
        dto.setId(shop.getId());
        dto.setUserId(shop.getUserId());
        dto.setItems(shop.getItems());
        dto.setTotal(shop.getTotal());
        dto.setDate(shop.getDate());
        return dto;
    }

    public static Shop convert(ShopDTO dto) {
        Shop shop = new Shop();
        shop.setId(dto.getId());
        shop.setUserId(dto.getUserId());
        shop.setItems(dto.getItems());
        shop.setTotal(dto.getTotal());
        shop.setDate(dto.getDate());
        return shop;
    }
}
