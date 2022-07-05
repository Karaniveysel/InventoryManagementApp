package com.example.services.mapper;

import com.example.services.dto.CategoryDTO;
import com.example.services.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="definition", source="definition"),
    })
    Category categoryDTOtoCategory(CategoryDTO dto);
    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="definition", source="definition")
    })
    CategoryDTO categoryToCategoryDTO(Category entity);
}
