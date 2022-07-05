package com.example.services.service.serviceImpl;

import com.example.services.dto.ProductDTO;
import com.example.services.entity.Product;
import com.example.services.exception.ResourceException;
import com.example.services.mapper.ProductMapper;
import com.example.services.repository.ProductRepository;
import com.example.services.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LogManager.getLogger(ProductServiceImpl.class);
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper mapper;


    @Transactional
    public List<ProductDTO> getAllProducts() {
        return  productRepository.findAll().stream().map(mapper::productToProductDTO).collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO save(ProductDTO productDTO) {
        Product product=productRepository.save(mapper.productDTOtoProduct(productDTO));
        return mapper.productToProductDTO(product);
    }

    @Transactional
    public ProductDTO findOne(Long id) {
        return productRepository.findById(id).map(mapper::productToProductDTO).orElseThrow(()->new ResourceException("No Records Found"));
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }


}
