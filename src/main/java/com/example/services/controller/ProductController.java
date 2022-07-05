package com.example.services.controller;

import com.example.services.exception.handler.ResponseHandler;
import com.example.services.dto.ProductDTO;
import com.example.services.service.ProductService;
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
@RequestMapping("/api/product")
public class ProductController {
    private static final Logger log = LogManager.getLogger(ProductController.class);

    @Autowired
    public ProductService productService;
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
        List<ProductDTO> list = productService.getAllProducts();
        return ResponseHandler.generateResponse(list);
    }

    /**
     * GET  /product/:id : get the "id" product.
     *
     * @param id the id of the productDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the productDTO, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        log.debug("REST request to get ProductById : {}", id);
        ProductDTO productDTO = productService.findOne(id);
        return ResponseHandler.generateResponse(HttpStatus.FOUND,productDTO);

    }

    /**
     * DELETE  /delete/product/:id : delete the "id" product.
     *
     * @param id the id of the productDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional> delete(@PathVariable Long id) {
        log.debug("REST request to delete Product : {}", id);
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
    /**
     * POST  Create a new Product.
     *
     * @param productDTO the productDTO to create
     * @return the ResponseEntity with status 201 (Created)
     **/
    @PutMapping("/add")
    public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductDTO productDTO){
        log.debug("REST request to get getType : {}", productDTO.getId());
        ProductDTO result =  productService.save(productDTO);
        return ResponseHandler.generateResponse(HttpStatus.CREATED,result);

    }


}
