package com.example.services.mapper;

import com.example.services.dto.ProductsInDepotDTO;
import com.example.services.entity.Depot;
import com.example.services.entity.Product;
import com.example.services.entity.ProductsInDepot;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-05T09:04:07+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
@Component
public class ProductsInDepotMapperImpl implements ProductsInDepotMapper {

    @Override
    public ProductsInDepot productsInDepotDTOtoProductsInDepot(ProductsInDepotDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProductsInDepot productsInDepot = new ProductsInDepot();

        productsInDepot.setDepot( productsInDepotDTOToDepot( dto ) );
        productsInDepot.setProduct( productsInDepotDTOToProduct( dto ) );
        productsInDepot.setId( dto.getId() );
        productsInDepot.setQuantity( dto.getQuantity() );

        return productsInDepot;
    }

    @Override
    public ProductsInDepotDTO productsInDepotToProductsInDepotDTO(ProductsInDepot entity) {
        if ( entity == null ) {
            return null;
        }

        ProductsInDepotDTO productsInDepotDTO = new ProductsInDepotDTO();

        productsInDepotDTO.setId( entity.getId() );
        productsInDepotDTO.setQuantity( entity.getQuantity() );
        productsInDepotDTO.setDepot_id( entityDepotId( entity ) );
        productsInDepotDTO.setProduct_id( entityProductId( entity ) );

        return productsInDepotDTO;
    }

    protected Depot productsInDepotDTOToDepot(ProductsInDepotDTO productsInDepotDTO) {
        if ( productsInDepotDTO == null ) {
            return null;
        }

        Depot depot = new Depot();

        depot.setId( productsInDepotDTO.getDepot_id() );

        return depot;
    }

    protected Product productsInDepotDTOToProduct(ProductsInDepotDTO productsInDepotDTO) {
        if ( productsInDepotDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productsInDepotDTO.getProduct_id() );

        return product;
    }

    private long entityDepotId(ProductsInDepot productsInDepot) {
        if ( productsInDepot == null ) {
            return 0L;
        }
        Depot depot = productsInDepot.getDepot();
        if ( depot == null ) {
            return 0L;
        }
        long id = depot.getId();
        return id;
    }

    private long entityProductId(ProductsInDepot productsInDepot) {
        if ( productsInDepot == null ) {
            return 0L;
        }
        Product product = productsInDepot.getProduct();
        if ( product == null ) {
            return 0L;
        }
        long id = product.getId();
        return id;
    }
}
