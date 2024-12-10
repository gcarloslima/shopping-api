package br.com.edu.iftm.tspi.shoppingapi.models;

import lombok.Data;

@Data
public class ProductItem {
    private String productIdentifier;
    private Integer quantity;
    private Double price;
}
