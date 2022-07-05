package com.example.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsInDepotRequestDTO {
    long id;
    long depot_id;
    long product_id;
    long category_id;
    long quantity;
    String region;
    String City;
    String category_definition;
    String depot_definition;
    String product_definition;



}
