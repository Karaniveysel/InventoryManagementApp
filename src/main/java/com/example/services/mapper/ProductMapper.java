package com.example.services.mapper;

import com.example.services.dto.ProductDTO;
import com.example.services.entity.Category;
import com.example.services.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring",uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="definition", source="definition"),
            @Mapping(target="threshold", source="threshold"),
            @Mapping(source = "category_id", target = "category.id")
    })
    Product productDTOtoProduct(ProductDTO dto);
    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="definition", source="definition"),
            @Mapping(target="threshold", source="threshold"),
            @Mapping(source = "category.id", target = "category_id")
    })
    ProductDTO productToProductDTO(Product entity);
}
