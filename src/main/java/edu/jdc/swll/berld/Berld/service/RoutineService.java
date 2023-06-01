package edu.jdc.swll.berld.Berld.service;

import edu.jdc.swll.berld.Berld.model.dtos.RoutineDTO;
import edu.jdc.swll.berld.Berld.model.entities.Client;
import edu.jdc.swll.berld.Berld.model.entities.WorkPlan;
import edu.jdc.swll.berld.Berld.repository.WorkPlanRepository;

import java.util.Optional;

public interface RoutineService extends WorkPlanRepository {

    RoutineDTO addRoutine(RoutineDTO routine, Client client);

    Optional<WorkPlan> findByRoutineName(String name);

    Optional<RoutineDTO> searchRoutineById(Long id);

    RoutineDTO editRoutineById(Long id);
}
