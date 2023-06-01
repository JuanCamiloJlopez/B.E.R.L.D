package edu.jdc.swll.berld.Berld.model.mappers;

import edu.jdc.swll.berld.Berld.model.dtos.CourseDTO;
import edu.jdc.swll.berld.Berld.model.entities.Course;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CourseDtoMapper {

    public CourseDTO mapFromEntity(Course course) {
        return CourseDTO
                .builder()
                .name(course.getName())
                .description(course.getDescription())
                .schedule(course.getSchedule())
                .id(course.getId())
                .build();
    }

    public Course mapToEntity(CourseDTO course) {
        return Course
                .builder()
                .name(course.getName())
                .description(course.getDescription())
                .schedule(course.getSchedule())
                .id(course.getId())
                .build();
    }


}
