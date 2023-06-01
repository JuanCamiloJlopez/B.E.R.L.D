package edu.jdc.swll.berld.Berld.repository;

import edu.jdc.swll.berld.Berld.model.entities.Course;
import edu.jdc.swll.berld.Berld.model.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    //Optional<Group> findByGroupName(String name);
}
