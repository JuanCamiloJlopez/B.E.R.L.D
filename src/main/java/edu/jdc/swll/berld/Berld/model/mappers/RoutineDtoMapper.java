package edu.jdc.swll.berld.Berld.model.mappers;

import edu.jdc.swll.berld.Berld.model.dtos.RoutineDTO;
import edu.jdc.swll.berld.Berld.model.entities.WorkPlan;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RoutineDtoMapper {

    public RoutineDTO mapFromEntity(WorkPlan workPlan) {
        return RoutineDTO
                .builder()
                .id(workPlan.getId())
                .description(workPlan.getDescription())
                .build();
    }

    public WorkPlan mapToEntity(RoutineDTO workPlan) {
        return WorkPlan
                .builder()
                .id(workPlan.getId())
                .description(workPlan.getDescription())
                .build();
    }
}
