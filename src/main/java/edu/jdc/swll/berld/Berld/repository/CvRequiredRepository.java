package edu.jdc.swll.berld.Berld.repository;

import edu.jdc.swll.berld.Berld.model.entities.CvRequired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRequiredRepository extends JpaRepository<CvRequired, Long> {
}
