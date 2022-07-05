package com.example.services.service;

import com.example.services.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    /**
     * Get all the Categorys.
     *
     * @return the list of entities
     */
    List<CategoryDTO> getAllCategoryies();

    /**
     * Save a Category.
     *
     * @param productDTO the entity to save
     * @return the persisted entity
     */
    CategoryDTO save(CategoryDTO productDTO);

    /**
     * Get the "id" productDTO.
     *
     * @param id the id of the entity
     * @return the entity
     */
    CategoryDTO findOne(Long id);

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
