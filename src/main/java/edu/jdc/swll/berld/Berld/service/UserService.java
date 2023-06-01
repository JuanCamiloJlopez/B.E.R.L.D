package edu.jdc.swll.berld.Berld.service;

import edu.jdc.swll.berld.Berld.model.dtos.UserDTO;
import edu.jdc.swll.berld.Berld.model.enums.RoleType;
import edu.jdc.swll.berld.Berld.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserService extends UserRepository {

    UserDTO createUser(UserDTO user);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void assignRoleToUser(String userName, RoleType roleType);
    Optional<UserDTO> findByUserName(String userName);
}

