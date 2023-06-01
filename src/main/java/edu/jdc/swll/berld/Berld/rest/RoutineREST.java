package edu.jdc.swll.berld.Berld.rest;

import edu.jdc.swll.berld.Berld.model.entities.WorkPlan;
import edu.jdc.swll.berld.Berld.service.RoutineService;
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
@RequestMapping("/routine")
@Slf4j
public class RoutineREST {

    private final RoutineService routineService;

    @PostMapping("/add")
    public ResponseEntity<?> addRoutine(@RequestBody WorkPlan routine){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/routine/add").toUriString());
        var routineCreated = routineService.save(routine);
        return (ResponseEntity.created(uri).body(routineCreated));
    }

}
