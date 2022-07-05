package com.example.services.dto;


import com.example.services.entity.ProductsInDepot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepotDTO {
    long id;
    String definition;
    String address;
    String region;
    String City;



}
