package edu.jdc.swll.berld.Berld.service;

import edu.jdc.swll.berld.Berld.model.dtos.GroupDTO;
import edu.jdc.swll.berld.Berld.model.entities.Group;
import edu.jdc.swll.berld.Berld.repository.GroupRepository;

import java.util.Optional;

public interface GroupService extends GroupRepository {

    GroupDTO addGroup(GroupDTO group);

   // Optional<Group> findByGroupName(String name);

    Optional<GroupDTO> searchGroupById(Long id);

    GroupDTO editCourseById(Long id);
}
