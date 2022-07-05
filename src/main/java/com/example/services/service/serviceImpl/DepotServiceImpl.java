package com.example.services.service.serviceImpl;

import com.example.services.dto.DepotDTO;
import com.example.services.entity.Depot;

import com.example.services.entity.QDepot;
import com.example.services.enums.StatusType;
import com.example.services.exception.ResourceException;

import com.example.services.mapper.DepotMapper;
import com.example.services.repository.DepotRepository;
import com.example.services.service.DepotService;
import com.querydsl.jpa.impl.JPAQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DepotServiceImpl implements DepotService {
    private static final Logger log = LogManager.getLogger(DepotServiceImpl.class);
    @Autowired
    DepotRepository depotRepository;

    @Autowired
    DepotMapper mapper;


    @Transactional
    public List<DepotDTO> getAllDepots() {
        return  depotRepository. findAll().stream().map(mapper::depotToDepotDTO).collect(Collectors.toList());
    }

    @Transactional
    public DepotDTO save(DepotDTO depotDTO) {
        Depot depot=depotRepository.save(mapper.depotDTOtoDepot(depotDTO));
        return mapper.depotToDepotDTO(depot);
    }

    @Transactional
    public DepotDTO findOne(Long id) {
        return depotRepository.findById(id).map(mapper::depotToDepotDTO).orElseThrow(()->new ResourceException("Depo Kaydı Bulanamadı.."));
    }

    @Transactional
    public void delete(Long id) {
         depotRepository.deleteById(id);
    }




}
