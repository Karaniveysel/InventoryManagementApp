package com.example.services.service.serviceImpl;

import com.example.services.dto.ProductDTO;
import com.example.services.dto.ProductsInDepotDTO;
import com.example.services.dto.ProductsInDepotRequestDTO;
import com.example.services.entity.*;
import com.example.services.exception.ResourceException;
import com.example.services.mapper.ProductsInDepotMapper;
import com.example.services.repository.ProductsInDepotRepository;
import com.example.services.service.ProductService;
import com.example.services.service.ProductsInDepotService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ProductsInDepotServiceImpl implements ProductsInDepotService {
    private static final Logger log = LogManager.getLogger(ProductsInDepotServiceImpl.class);
    @Autowired
    ProductsInDepotRepository productsInDepotRepository;

    @Autowired
    ProductService productService;

    @Autowired
    ProductsInDepotMapper mapper;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<ProductsInDepotDTO> getAllProductsInDepoties() {
        return  productsInDepotRepository.findAll().stream().map(mapper::productsInDepotToProductsInDepotDTO).collect(Collectors.toList());
    }

    @Transactional
    public ProductsInDepotDTO save(ProductsInDepotDTO productsInDepotDTO) {
        ProductsInDepot productsInDepot=productsInDepotRepository.save(mapper.productsInDepotDTOtoProductsInDepot(productsInDepotDTO));
        return mapper.productsInDepotToProductsInDepotDTO(productsInDepot);
    }



    @Transactional
    public ProductsInDepotDTO findOne(Long id) {
        return productsInDepotRepository.findById(id).map(mapper::productsInDepotToProductsInDepotDTO).orElseThrow(()->new ResourceException("No Records Found"));
    }

    @Transactional
    public void delete(Long id) {
        productsInDepotRepository.deleteById(id);
    }

    @Transactional
    public List<ProductsInDepotRequestDTO> getProductsInDepotsByDtos(ProductsInDepotRequestDTO productsInDepotRequestDTO) {
        JPAQuery<Tuple> query = new JPAQuery(entityManager);
        QProductsInDepot qProductsInDepot = QProductsInDepot.productsInDepot;
        QDepot qDepot=QDepot.depot;
        QCategory qCategory=QCategory.category;
        BooleanBuilder where = new BooleanBuilder();

        Optional.ofNullable(productsInDepotRequestDTO.getDepot_definition()).ifPresent(x->{
            where.and(qProductsInDepot.depot.id.in(JPAExpressions.select(qDepot.id).from(qDepot).
                    where(qDepot.definition.like(Expressions.constant("%" + productsInDepotRequestDTO.getDepot_definition() + "%")))));

        });

        if(productsInDepotRequestDTO.getDepot_id()>0)
            where.and(qProductsInDepot.depot.id.eq(productsInDepotRequestDTO.getDepot_id()));

        if(productsInDepotRequestDTO.getProduct_id()>0)
            where.and(qProductsInDepot.product.id.eq(productsInDepotRequestDTO.getProduct_id()));

        if(productsInDepotRequestDTO.getCategory_id()>0)
            where.and(qProductsInDepot.product.category.id.eq(productsInDepotRequestDTO.getCategory_id()));

        Optional.ofNullable(productsInDepotRequestDTO.getRegion()).ifPresent(x->{
            where.and(qProductsInDepot.depot.id.in(JPAExpressions.select(qDepot.id).from(qDepot).
                    where(qDepot.region.like(Expressions.constant("%" + productsInDepotRequestDTO.getRegion() + "%")))));

        });

        Optional.ofNullable(productsInDepotRequestDTO.getCity()).ifPresent(x->{
            where.and(qProductsInDepot.depot.id.in(JPAExpressions.select(qDepot.id).from(qDepot).
                    where(qDepot.City.like(Expressions.constant("%" + productsInDepotRequestDTO.getCity() + "%")))));
        });

        Optional.ofNullable(productsInDepotRequestDTO.getCategory_definition()).ifPresent(x->{
            where.and(qProductsInDepot.product.category.id.in(JPAExpressions.select(qCategory.id).from(qCategory).
                where(qDepot.definition.like(Expressions.constant("%" + productsInDepotRequestDTO.getCategory_definition() + "%")))));
        });



        query.select(qProductsInDepot.id
                    ,qProductsInDepot.depot.definition
                    ,qProductsInDepot.depot.City
                    ,qProductsInDepot.depot.region
                    ,qProductsInDepot.quantity
                    ,qProductsInDepot.product.definition
                    ,qProductsInDepot.product.category.id
                ,qProductsInDepot.product.category.definition).from(qProductsInDepot).where(where);

        List<Tuple> result = query.fetch();
        List <ProductsInDepotRequestDTO> list =new ArrayList<>();
        if(CollectionUtils.isNotEmpty(result)) {
            for (Tuple tuple : result) {
                ProductsInDepotRequestDTO dto =new ProductsInDepotRequestDTO();
                dto.setId(tuple.get(0, Long.class));
                dto.setDepot_definition(tuple.get(1, String.class));
                dto.setCity(tuple.get(2, String.class));
                dto.setRegion(tuple.get(3, String.class));
                dto.setQuantity(tuple.get(4, Long.class));
                dto.setProduct_definition(tuple.get(5, String.class));
                dto.setCategory_id(tuple.get(6, Long.class));
                dto.setCategory_definition(tuple.get(7, String.class));
                list.add(dto);

            }
        }
        return list;
    }


    @Transactional
    public ProductsInDepotDTO productExtractionInDepotsByDto(ProductsInDepotDTO productsInDepotDTO) {
        if(productsInDepotDTO.getId()>0 && productsInDepotDTO.getProduct_id()>0 && productsInDepotDTO.getDepot_id()>0 && productsInDepotDTO.getQuantity()>0) {

            ProductsInDepotDTO dto = findOne(productsInDepotDTO.getId());
            if(dto.getQuantity()<productsInDepotDTO.getQuantity())
                throw new ResourceException("Belirtilen miktarda çıkarma yapılamaz.");

            productsInDepotDTO.setQuantity(dto.getQuantity()-productsInDepotDTO.getQuantity());
            dto=new ProductsInDepotDTO();
            dto=save(productsInDepotDTO);
            if(Controlthreshold(productsInDepotDTO.getProduct_id(),dto.getQuantity()))
                log.debug("Eşik Değerini altına düştüğü içi mail atıldı.");

        }else{
            throw new ResourceException("Depo, Ürün ve Miktar Bilgisi Girilmediği için bu işlem Gerçekleştirilemez.");
        }
        return productsInDepotDTO;
    }

    public boolean Controlthreshold(long val,long quantity){
        boolean retVal=false;
        ProductDTO productDTO=productService.findOne(val);
        if(productDTO!=null && productDTO.getThreshold()>quantity)
            retVal= true;
        return retVal;
    }

}
