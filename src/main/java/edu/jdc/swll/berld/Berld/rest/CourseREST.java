package edu.jdc.swll.berld.Berld.rest;

import edu.jdc.swll.berld.Berld.model.entities.Course;
import edu.jdc.swll.berld.Berld.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
@Slf4j
public class CourseREST {

    @Autowired
    private final CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody Course course){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/course/add").toUriString());
        var courseCreated = courseService.save(course);
        return (ResponseEntity.created(uri).body(courseCreated));
    }

    //@GetMapping("/findByName")
    //public ResponseEntity<?> findByCourseName(@PathVariable String name){
      //  URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/course/findByName").toUriString());
        //var courseCreated = courseService.save(course);
        //return (ResponseEntity.created(uri).body(courseCreated));
    //}

}
