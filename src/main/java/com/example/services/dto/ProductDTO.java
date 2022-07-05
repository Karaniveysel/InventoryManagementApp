package com.example.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    long id;
    String definition;
    long category_id;
    long threshold;
    long count;
    String status;


}
