package com.example.services.mapper;

import com.example.services.dto.ProductsInDepotDTO;
import com.example.services.entity.ProductsInDepot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = {DepotMapper.class,ProductMapper.class})
public interface ProductsInDepotMapper {
    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="quantity", source="quantity"),
            @Mapping(source = "depot_id", target = "depot.id"),
            @Mapping(source = "product_id", target = "product.id"),
    })
    ProductsInDepot productsInDepotDTOtoProductsInDepot(ProductsInDepotDTO dto);
    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="quantity", source="quantity"),
            @Mapping(source = "depot.id", target = "depot_id"),
            @Mapping(source = "product.id", target = "product_id"),
    })
    ProductsInDepotDTO productsInDepotToProductsInDepotDTO(ProductsInDepot entity);
}
