package com.example.services.mapper;

import com.example.services.dto.DepotDTO;
import com.example.services.entity.Depot;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-05T09:04:07+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
@Component
public class DepotMapperImpl implements DepotMapper {

    @Override
    public Depot depotDTOtoDepot(DepotDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Depot depot = new Depot();

        depot.setId( dto.getId() );
        depot.setDefinition( dto.getDefinition() );
        depot.setAddress( dto.getAddress() );
        depot.setRegion( dto.getRegion() );
        depot.setCity( dto.getCity() );

        return depot;
    }

    @Override
    public DepotDTO depotToDepotDTO(Depot entity) {
        if ( entity == null ) {
            return null;
        }

        DepotDTO depotDTO = new DepotDTO();

        depotDTO.setId( entity.getId() );
        depotDTO.setDefinition( entity.getDefinition() );
        depotDTO.setAddress( entity.getAddress() );
        depotDTO.setRegion( entity.getRegion() );
        depotDTO.setCity( entity.getCity() );

        return depotDTO;
    }
}
