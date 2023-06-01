package edu.jdc.swll.berld.Berld.model.mappers;

import edu.jdc.swll.berld.Berld.model.dtos.RoutineDTO;
import edu.jdc.swll.berld.Berld.model.entities.WorkPlan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoutineMapper {

    RoutineMapper INSTANCE = Mappers.getMapper(RoutineMapper.class);

    RoutineDTO mapFromEntity(WorkPlan routine);
}
