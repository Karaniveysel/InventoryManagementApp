package com.example.services.mapper;

import com.example.services.dto.DepotDTO;
import com.example.services.entity.Depot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface DepotMapper {
    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="definition", source="definition")
    })
    Depot depotDTOtoDepot(DepotDTO dto);
    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="definition", source="definition")
    })
    DepotDTO depotToDepotDTO(Depot entity);
}
