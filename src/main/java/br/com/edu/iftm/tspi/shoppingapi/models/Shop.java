package br.com.edu.iftm.tspi.shoppingapi.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "shops")
public class Shop {
    @Id
    private String id;
    private String userId;
    private List<ProductItem> items;
    private Double total;
    private LocalDateTime date;
}
