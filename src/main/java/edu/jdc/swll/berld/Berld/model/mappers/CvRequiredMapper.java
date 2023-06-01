package edu.jdc.swll.berld.Berld.model.mappers;

import edu.jdc.swll.berld.Berld.model.dtos.CvRequiredDTO;
import edu.jdc.swll.berld.Berld.model.entities.CvRequired;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CvRequiredMapper {

    CvRequiredMapper INSTANCE = Mappers.getMapper(CvRequiredMapper.class);

    CvRequiredDTO mapFromEntity(CvRequired cvRequired);
}
