package edu.jdc.swll.berld.Berld.service;

import edu.jdc.swll.berld.Berld.model.dtos.CourseDTO;
import edu.jdc.swll.berld.Berld.model.entities.Course;
import edu.jdc.swll.berld.Berld.model.mappers.CourseDtoMapper;
import edu.jdc.swll.berld.Berld.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService{

    private static final String COURSE_CREATED_MESSAGE = "Course %s created with id %d";
    private static final String COURSE_EDITED_MESSAGE = "Course %s edited with id %d";
    private static final String COURSE_NOT_FOUND_MESSAGE = "Course %s not found";
    private static final String COURSE_FOUND_MESSAGE = "Course {} found in the database";


    private final CourseRepository courseRepository;

    @Override
    @Transactional
    public CourseDTO addCourse(CourseDTO course) {
        var courseOptional = courseRepository.findById(course.getId());
        if(courseOptional.isEmpty()){
            var errorMessage = String.format(COURSE_NOT_FOUND_MESSAGE, course.getName());
            log.error(errorMessage);
            throw new UsernameNotFoundException(errorMessage);
        }
        course.setDescription(course.getDescription());
        course.setName(course.getName());
        course.setSchedule(course.getSchedule());
        var courseCreated = courseRepository.save(CourseDtoMapper.mapToEntity(course));
        log.info(String.format(COURSE_CREATED_MESSAGE, course.getName(), courseCreated.getId()));
        return CourseDtoMapper.mapFromEntity(courseCreated);
    }

    //@Override
    //public Optional<Course> findByCourseName(String name) {
      //  var courseOptional = courseRepository.findByCourseName(name);
       // if(courseOptional.isEmpty()){
        //    var errorMessage = String.format(COURSE_NOT_FOUND_MESSAGE, name);
         //   log.error(errorMessage);
          //  throw new UsernameNotFoundException(errorMessage);
        //}
        //return courseOptional;
    //}

    //@Override
    //public Optional<CourseDTO> searchCourseById(Long id) {
     //   var courseOptional = courseRepository.findById(id);
      //  return courseOptional.map(CourseDtoMapper::mapFromEntity);
    //}

    //@Override
    //public CourseDTO editCourseById(Long id) {
      // var courseOptional = courseRepository.findById(id);
        //if(courseOptional.isEmpty()){
          //  var errorMessage = String.format(COURSE_NOT_FOUND_MESSAGE, courseOptional.get().getName());
           // log.error(errorMessage);
            //throw new UsernameNotFoundException(errorMessage);
        //}
        //courseOptional.get().setDescription(courseOptional.get().getDescription());
        //courseOptional.get().setName(courseOptional.get().getName());
        //courseOptional.get().setSchedule(courseOptional.get().getSchedule());
        //var courseEdited = courseRepository.save(courseOptional.get());
        //log.info(String.format(COURSE_EDITED_MESSAGE, courseEdited.getName(), courseEdited.getId()));
        //return CourseDtoMapper.mapFromEntity(courseEdited);
    //}


    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Course> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Course> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Course entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Course> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Course> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Course> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Course> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Course> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Course> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Course> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Course getOne(Long aLong) {
        return null;
    }

    @Override
    public Course getById(Long aLong) {
        return null;
    }

    @Override
    public Course getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Course> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Course> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Course> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Course> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Course> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Course> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Course, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

}
