package edu.jdc.swll.berld.Berld.model.mappers;

import edu.jdc.swll.berld.Berld.model.dtos.CourseDTO;
import edu.jdc.swll.berld.Berld.model.entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO mapFromEntity(Course course);
}
