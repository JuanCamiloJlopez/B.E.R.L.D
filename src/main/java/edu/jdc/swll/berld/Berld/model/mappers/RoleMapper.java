package edu.jdc.swll.berld.Berld.model.mappers;

import edu.jdc.swll.berld.Berld.model.dtos.RoleDTO;
import edu.jdc.swll.berld.Berld.model.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDTO mapToDTO(Role role);

    Role mapToEntity(RoleDTO role);

}
