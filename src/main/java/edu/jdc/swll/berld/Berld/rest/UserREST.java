package edu.jdc.swll.berld.Berld.rest;

import edu.jdc.swll.berld.Berld.model.dtos.RoleRequestDTO;
import edu.jdc.swll.berld.Berld.model.entities.User;
import edu.jdc.swll.berld.Berld.model.enums.RoleType;
import edu.jdc.swll.berld.Berld.service.UserService;
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
import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserREST {

    private static final String ERROR_ROLE_TO_USER = "Role {} doesn't exists";

    private static final String LOGGING_ERROR_MESSAGE = "Error logging in: {}";
    private static final String MASK = "*****";
    @Autowired
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/add").toUriString());
        var userCreated = userService.save(user);
        userCreated.setPassword(MASK);
        return (ResponseEntity.created(uri).body(userCreated));
    }

    @PostMapping("/addRole")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleRequestDTO roleRequest){
        if(Arrays.stream(RoleType.values()).noneMatch(roleType -> roleType.name().equals(roleRequest.getRoleName()))){
            log.error(ERROR_ROLE_TO_USER, roleRequest.getRoleName());
            return (ResponseEntity.badRequest().body("Invalid Role"));
        }
        userService.assignRoleToUser(roleRequest.getUserName(), RoleType.valueOf(roleRequest.getRoleName()));
        return (ResponseEntity.ok().build());
    }

}
