package edu.jdc.swll.berld.Berld.model.mappers;

import edu.jdc.swll.berld.Berld.model.dtos.InstructorDTO;
import edu.jdc.swll.berld.Berld.model.entities.Instructor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InstructorDtoMapper {

    public InstructorDTO mapFromEntity(Instructor instructor) {
        return InstructorDTO
                .builder()
                .id(instructor.getId())
                .lastname(instructor.getLastname())
                .name(instructor.getName())
                .build();
    }

    public Instructor mapToEntity(InstructorDTO instructor) {
        return Instructor
                .builder()
                .id(instructor.getId())
                .lastname(instructor.getLastname())
                .name(instructor.getName())
                .build();
    }
}


