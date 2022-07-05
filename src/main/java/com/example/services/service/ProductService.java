package com.example.services.service;


import com.example.services.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public  interface ProductService {
    /**
     * Get all the Products.
     *
     * @return the list of entities
     */
    List<ProductDTO> getAllProducts();

    /**
     * Save a Product.
     *
     * @param productDTO the entity to save
     * @return the persisted entity
     */
    ProductDTO save(ProductDTO productDTO);

    /**
     * Get the "id" productDTO.
     *
     * @param id the id of the entity
     * @return the entity
     */
    ProductDTO findOne(Long id);

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

}
