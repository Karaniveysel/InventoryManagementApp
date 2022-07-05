package com.example.services.controller;


import com.example.services.exception.handler.ResponseHandler;
import com.example.services.dto.DepotDTO;
import com.example.services.service.DepotService;
import io.swagger.annotations.Api;
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
@RequestMapping("/api/depot")
public class DepotController {
    private static final Logger log = LogManager.getLogger(DepotController.class);

    @Autowired
    public DepotService depotService;



    /**
     * GET
     *
     *  to search
     * @returnthe ResponseEntity with status 200 (OK) and Remove vehicle mapping
     * @throws Exception
     */
    @GetMapping ("/getAll")
    @ApiOperation(value = "Getting all method in the Depot ")
    public ResponseEntity<List> getAll(){
        log.debug("REST request to get getId : {}");
        List<DepotDTO> list = depotService.getAllDepots();
        return ResponseHandler.generateResponse(list);
    }

    /**
     * GET  /depot/:id : get the "id" depot.
     *
     * @param id the id of the depotDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the depotDTO, or with status 404 (Not Found)
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Depot getting by id")
    public ResponseEntity<DepotDTO> getDepotById(@PathVariable Long id) {
        log.debug("REST request to get by id : {}", id);
        DepotDTO depotDTO = depotService.findOne(id);
        return ResponseHandler.generateResponse(HttpStatus.FOUND,depotDTO);

    }

    /**
     * DELETE  /delete/depot/:id : delete the "id" depot.
     *
     * @param id the id of the depotDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Depot deleting method")
    public ResponseEntity<Optional> deleteTinfTarife(@PathVariable Long id) {
        log.debug("REST request to delete Depot : {}", id);
        depotService.delete(id);
        return ResponseHandler.generateResponse(null);
    }
    /**
     * POST  Create a new Depot.
     *
     * @param depotDTO the depotDTO to create
     * @return the ResponseEntity with status 201 (Created)
     **/
    @PutMapping("/add")
    @ApiOperation(value = "New Depot adding method")
    public ResponseEntity<DepotDTO> save(@Valid @RequestBody DepotDTO depotDTO){
        log.debug("REST request to get getType : {}", depotDTO.getId());
        DepotDTO result =  depotService.save(depotDTO);
        return ResponseHandler.generateResponse(HttpStatus.CREATED,result);

    }









}
