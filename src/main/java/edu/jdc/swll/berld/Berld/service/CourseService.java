package edu.jdc.swll.berld.Berld.service;


import edu.jdc.swll.berld.Berld.model.dtos.CourseDTO;
import edu.jdc.swll.berld.Berld.model.entities.Course;
import edu.jdc.swll.berld.Berld.repository.CourseRepository;

import java.util.Optional;

public interface CourseService extends CourseRepository {

    CourseDTO addCourse(CourseDTO course);

    //Optional<Course> findByCourseName(String name);
//CourseDTO editCourseById(Long id);

}
