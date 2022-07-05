package com.example.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsInDepotDTO {
    long id;
    long depot_id;
    long product_id;
    long quantity;



}
