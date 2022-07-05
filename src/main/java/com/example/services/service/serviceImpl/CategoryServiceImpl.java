package com.example.services.service.serviceImpl;

import com.example.services.dto.CategoryDTO;
import com.example.services.entity.Category;
import com.example.services.exception.ResourceException;
import com.example.services.mapper.CategoryMapper;
import com.example.services.repository.CategoryRepository;
import com.example.services.service.CategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger log = LogManager.getLogger(CategoryServiceImpl.class);
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper mapper;


    @Transactional
    public List<CategoryDTO> getAllCategoryies() {
        return  categoryRepository.findAll().stream().map(mapper::categoryToCategoryDTO).collect(Collectors.toList());
    }

    @Transactional
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category=categoryRepository.save(mapper.categoryDTOtoCategory(categoryDTO));
        return mapper.categoryToCategoryDTO(category);
    }

    @Transactional
    public CategoryDTO findOne(Long id) {
        return categoryRepository.findById(id).map(mapper::categoryToCategoryDTO).orElseThrow(()->new ResourceException("No Records Found"));
    }

    @Transactional
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }


}
