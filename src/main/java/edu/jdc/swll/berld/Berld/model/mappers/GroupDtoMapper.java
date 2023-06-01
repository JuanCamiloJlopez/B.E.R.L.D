package edu.jdc.swll.berld.Berld.model.mappers;

import edu.jdc.swll.berld.Berld.model.dtos.GroupDTO;
import edu.jdc.swll.berld.Berld.model.entities.Group;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GroupDtoMapper {

    public GroupDTO mapFromEntity(Group group) {
        return GroupDTO
                .builder()
                .id(group.getId())
                .description(group.getDescription())
                .build();
    }

    public Group mapToEntity(GroupDTO group) {
        return Group
                .builder()
                .id(group.getId())
                .description(group.getDescription())
                .build();
    }

}
