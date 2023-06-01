package edu.jdc.swll.berld.Berld.service;

import edu.jdc.swll.berld.Berld.model.dtos.RoleDTO;
import edu.jdc.swll.berld.Berld.model.enums.RoleType;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RoleService {
    RoleDTO createRole(RoleDTO role);
    Optional<RoleDTO> findByName(RoleType name);
}
