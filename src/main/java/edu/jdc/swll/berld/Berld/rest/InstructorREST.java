package edu.jdc.swll.berld.Berld.rest;

import edu.jdc.swll.berld.Berld.model.entities.Instructor;
import edu.jdc.swll.berld.Berld.service.InstructorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructor")
@Slf4j
public class InstructorREST {

private final InstructorService instructorService;

    @PostMapping("/add")
    public ResponseEntity<?> addInstructor(@RequestBody Instructor instructor){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/instructor/add").toUriString());
        var InstructorCreated = instructorService.save(instructor);
        return (ResponseEntity.created(uri).body(InstructorCreated));
    }
}
