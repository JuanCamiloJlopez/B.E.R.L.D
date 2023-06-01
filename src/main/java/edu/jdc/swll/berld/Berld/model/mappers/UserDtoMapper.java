package edu.jdc.swll.berld.Berld.model.mappers;

import edu.jdc.swll.berld.Berld.model.dtos.UserDTO;
import edu.jdc.swll.berld.Berld.model.entities.User;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.stream.Collectors;

@UtilityClass
public class UserDtoMapper {

    public UserDTO mapFromEntity(User user) {
        return UserDTO
                .builder()
                .password(user.getPassword())
                .email(user.getEmail())
                .username(user.getUsername())
                .id(user.getId())
                .roles(CollectionUtils.isEmpty(user.getRoles())
                        ? Collections.emptyList()
                        : user.getRoles().stream().map(RoleDtoMapper::mapToDTO).collect(Collectors.toList()))
                .build();
    }

    public User mapToEntity(UserDTO user) {
        return User
                .builder()
                .password(user.getPassword())
                .email(user.getEmail())
                .username(user.getUsername())
                .id(user.getId())
                .roles(CollectionUtils.isEmpty(user.getRoles())
                        ? Collections.emptyList()
                        : user.getRoles().stream().map(RoleDtoMapper::mapToEntity).collect(Collectors.toList()))
                .build();
    }


}
