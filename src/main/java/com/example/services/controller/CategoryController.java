package com.example.services.controller;

import com.example.services.dto.CategoryDTO;
import com.example.services.exception.handler.ResponseHandler;
import com.example.services.service.CategoryService;
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
@RequestMapping("/api/category")
public class CategoryController {
    private static final Logger log = LogManager.getLogger(CategoryController.class);

    @Autowired
    public CategoryService categoryService;
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
        List<CategoryDTO> list = categoryService.getAllCategoryies();
        return ResponseHandler.generateResponse(list);
    }

    /**
     * GET  /category/:id : get the "id" category.
     *
     * @param id the id of the categoryDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the categoryDTO, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        log.debug("REST request to get Category : {}", id);
        CategoryDTO categoryDTO = categoryService.findOne(id);
        return ResponseHandler.generateResponse(HttpStatus.FOUND,categoryDTO);
    }

    /**
     * DELETE  /delete/category/:id : delete the "id" category.
     *
     * @param id the id of the categoryDto to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional> delete(@PathVariable Long id) {
        log.debug("REST request to delete Category : {}", id);
        categoryService.delete(id);
        return ResponseHandler.generateResponse(null);
    }
    /**
     * POST  Create a new Category.
     *
     * @param categoryDTO the categoryDto to create
     * @return the ResponseEntity with status 201 (Created)
     **/
    @PutMapping("/add")
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO categoryDTO){
        log.debug("REST request to get getType : {}", categoryDTO.getId());
        CategoryDTO result =  categoryService.save(categoryDTO);
        return ResponseHandler.generateResponse(HttpStatus.CREATED,result);

    }






}
