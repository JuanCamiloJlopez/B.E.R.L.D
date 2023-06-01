package edu.jdc.swll.berld.Berld.service;

import edu.jdc.swll.berld.Berld.model.dtos.RoleDTO;
import edu.jdc.swll.berld.Berld.model.entities.Role;
import edu.jdc.swll.berld.Berld.model.enums.RoleType;
import edu.jdc.swll.berld.Berld.model.mappers.RoleMapper;
import edu.jdc.swll.berld.Berld.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements  RoleService{

    private static final String ROLE_CREATED_MESSAGE = "Role %s created";

    private final RoleRepository roleRepository;

    @Override
    public RoleDTO createRole(RoleDTO role) {
        Role roleCreated = roleRepository.save(RoleMapper.INSTANCE.mapToEntity(role));
        log.info(String.format(ROLE_CREATED_MESSAGE, role.getName()));
        return RoleMapper.INSTANCE.mapToDTO(roleCreated);
    }

    @Override
    public Optional<RoleDTO> findByName(RoleType name) {
        var roleOptional = roleRepository.findByName(name);
        return roleOptional.map(RoleMapper.INSTANCE::mapToDTO);
    }
}
