package com.example.services.controller;

import com.example.services.dto.DepotDTO;
import com.example.services.dto.ProductsInDepotDTO;
import com.example.services.dto.ProductsInDepotRequestDTO;
import com.example.services.exception.handler.ResponseHandler;
import com.example.services.service.ProductsInDepotService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productsInDepot")
public class ProductsInDepotController {
    private static final Logger log = LogManager.getLogger(ProductsInDepotController.class);

    @Autowired
    public ProductsInDepotService productsInDepotService;
    /**
     * GET
     *
     *  to search
     * @returnthe ResponseEntity with status 200 (OK) and Remove vehicle mapping
     * @throws Exception
     */
    @GetMapping ("/getAll")
    public ResponseEntity<List> getAll(){
        log.debug("REST request to get getId : {}");
        List<ProductsInDepotDTO> list = productsInDepotService.getAllProductsInDepoties();
        return ResponseHandler.generateResponse(list);
    }

    /**
     * GET  /productsInDepot/:id : get the "id" productsInDepot.
     *
     * @param id the id of the productsInDepotDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the productsInDepotDTO, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductsInDepotDTO> getProductsInDepotById(@PathVariable Long id) {
        log.debug("REST request to get ProductsInDepot : {}", id);
        ProductsInDepotDTO productsInDepotDTO = productsInDepotService.findOne(id);
        return ResponseHandler.generateResponse(HttpStatus.FOUND,productsInDepotDTO);
    }

    /**
     * DELETE  /delete/productsInDepot/:id : delete the "id" productsInDepot.
     *
     * @param id the id of the productsInDepotDto to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional> delete(@PathVariable Long id) {
        log.debug("REST request to delete ProductsInDepot : {}", id);
        productsInDepotService.delete(id);
        return ResponseHandler.generateResponse(null);
    }
    /**
     * POST  Create a new ProductsInDepot.
     *
     * @param productsInDepotDTO the productsInDepotDto to create
     * @return the ResponseEntity with status 201 (Created)
     **/
    @PutMapping("/add")
    public ResponseEntity<ProductsInDepotDTO> save(@Valid @RequestBody ProductsInDepotDTO productsInDepotDTO){
        log.debug("REST request to get getType : {}", productsInDepotDTO.getId());
        ProductsInDepotDTO result =  productsInDepotService.save(productsInDepotDTO);
        return ResponseHandler.generateResponse(HttpStatus.CREATED,result);

    }

    /**
     * POST  /productsInDepot/getByDto
     * @param productsInDepotRequestDTO
     * @return the ResponseEntity with status 200 (OK) and with body the productsInDepotDTO, or with status 404 (Not Found)
     */
    @PostMapping("/getProductsInDepotsByDto")
    public ResponseEntity<List<ProductsInDepotRequestDTO>> getProductsInDepotsByDto(@RequestBody ProductsInDepotRequestDTO productsInDepotRequestDTO){
        log.debug("REST request to get getType : {}", productsInDepotRequestDTO.getId());
        List<ProductsInDepotRequestDTO> result =  productsInDepotService.getProductsInDepotsByDtos(productsInDepotRequestDTO);
        return ResponseHandler.generateResponse(HttpStatus.OK,result);

    }

    /**
     * POST  /productsInDepot/getByDto
     * @param productsInDepotDTO
     * @return the ResponseEntity with status 200 (OK) and with body the productsInDepotDTO, or with status 404 (Not Found)
     */
    @PostMapping("/productExtractionInDepotsByDto")
    public ResponseEntity<ProductsInDepotDTO> productExtractionInDepotsByDto(@RequestBody ProductsInDepotDTO productsInDepotDTO){
        log.debug("REST request to get getType : {}", productsInDepotDTO.getId());
        ProductsInDepotDTO result =  productsInDepotService.productExtractionInDepotsByDto(productsInDepotDTO);
        return ResponseHandler.generateResponse(HttpStatus.OK,result);

    }





}
