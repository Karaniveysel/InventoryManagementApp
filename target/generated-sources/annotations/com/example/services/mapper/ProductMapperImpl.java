package com.example.services.mapper;

import com.example.services.dto.ProductDTO;
import com.example.services.entity.Category;
import com.example.services.entity.Product;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-05T09:39:05+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product productDTOtoProduct(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( productDTOToCategory( dto ) );
        product.setId( dto.getId() );
        product.setDefinition( dto.getDefinition() );
        product.setThreshold( String.valueOf( dto.getThreshold() ) );
        product.setStatus( dto.getStatus() );

        return product;
    }

    @Override
    public ProductDTO productToProductDTO(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( entity.getId() );
        productDTO.setDefinition( entity.getDefinition() );
        if ( entity.getThreshold() != null ) {
            productDTO.setThreshold( Long.parseLong( entity.getThreshold() ) );
        }
        productDTO.setCategory_id( entityCategoryId( entity ) );
        productDTO.setStatus( entity.getStatus() );

        return productDTO;
    }

    protected Category productDTOToCategory(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( productDTO.getCategory_id() );

        return category;
    }

    private long entityCategoryId(Product product) {
        if ( product == null ) {
            return 0L;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return 0L;
        }
        long id = category.getId();
        return id;
    }
}
