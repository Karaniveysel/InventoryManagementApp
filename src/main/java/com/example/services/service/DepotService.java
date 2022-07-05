package com.example.services.service;


import com.example.services.dto.DepotDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  interface DepotService {
    /**
     * Get all the Depots.
     *
     * @return the list of entities
     */
    List<DepotDTO> getAllDepots();

    /**
     * Save a Depot.
     *
     * @param depotDTO the entity to save
     * @return the persisted entity
     */
    DepotDTO save(DepotDTO depotDTO);

    /**
     * Get the "id" depotDTO.
     *
     * @param id the id of the entity
     * @return the entity
     */
    DepotDTO findOne(Long id);

    /**
     * Delete the "id" depot.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

}
