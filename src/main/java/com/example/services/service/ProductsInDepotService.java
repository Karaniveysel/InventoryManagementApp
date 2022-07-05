package com.example.services.service;

import com.example.services.dto.ProductsInDepotDTO;
import com.example.services.dto.ProductsInDepotRequestDTO;

import java.util.List;

public interface ProductsInDepotService {

    /**
     * Get all the ProductsInDepots.
     *
     * @return the list of entities
     */
    List<ProductsInDepotDTO> getAllProductsInDepoties();

    /**
     * Save a ProductsInDepot.
     *
     * @param productDTO the entity to save
     * @return the persisted entity
     */
    ProductsInDepotDTO save(ProductsInDepotDTO productDTO);

    /**
     * Get the "id" productDTO.
     *
     * @param id the id of the entity
     * @return the entity
     */
    ProductsInDepotDTO findOne(Long id);

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity
     */
    void delete(Long id);


    /**
     * POST  /productsInDepot/getByDto
     * @param productsInDepotRequestDTO
     * @return the ResponseEntity with status 200 (OK) and with body the productsInDepotDTOs, or with status 404 (Not Found)
     */
    List<ProductsInDepotRequestDTO> getProductsInDepotsByDtos(ProductsInDepotRequestDTO productsInDepotRequestDTO);

   ProductsInDepotDTO productExtractionInDepotsByDto(ProductsInDepotDTO productsInDepotDTO);
}
