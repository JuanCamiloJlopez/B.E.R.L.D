package edu.jdc.swll.berld.Berld.model.mappers;

import edu.jdc.swll.berld.Berld.model.dtos.RoleDTO;
import edu.jdc.swll.berld.Berld.model.entities.Role;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RoleDtoMapper {

    public RoleDTO mapToDTO(Role role) {
        return RoleDTO
                .builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public Role mapToEntity(RoleDTO role) {
        return Role
                .builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

}
