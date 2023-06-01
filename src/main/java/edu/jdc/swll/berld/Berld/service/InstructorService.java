package edu.jdc.swll.berld.Berld.service;

import edu.jdc.swll.berld.Berld.model.dtos.InstructorDTO;
import edu.jdc.swll.berld.Berld.model.entities.Instructor;
import edu.jdc.swll.berld.Berld.repository.InstructorRepository;

import java.util.Optional;

public interface InstructorService extends InstructorRepository {

    InstructorDTO addInstructor(InstructorDTO instructor);

    Optional<Instructor> findByInstructorName(String name);

    Optional<InstructorDTO> searchById(Long id);

    InstructorDTO editInstructorById(Long id);
}
