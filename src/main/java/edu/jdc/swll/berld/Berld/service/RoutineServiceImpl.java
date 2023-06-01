package edu.jdc.swll.berld.Berld.service;

import edu.jdc.swll.berld.Berld.model.dtos.RoutineDTO;
import edu.jdc.swll.berld.Berld.model.entities.Client;
import edu.jdc.swll.berld.Berld.model.entities.WorkPlan;
import edu.jdc.swll.berld.Berld.model.mappers.RoutineDtoMapper;
import edu.jdc.swll.berld.Berld.repository.WorkPlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoutineServiceImpl implements RoutineService {

    private static final String ROUTINE_NOT_FOUND_MESSAGE = "Routine %s not found";
    private static final String ROUTINE_CREATED_MESSAGE = "Routine created with id %d";
    private static final String ROUTINE_EDITED_MESSAGE = "Routine %s edited with id %d";
    private final WorkPlanRepository workPlanRepository;

    @Override
    @Transactional
    public RoutineDTO addRoutine(RoutineDTO routine, Client client) {
        var routineOptional = workPlanRepository.findById(routine.getId());
        if(routineOptional.isEmpty()){
            var errorMessage = String.format(ROUTINE_NOT_FOUND_MESSAGE, routine.getId());
            log.error(errorMessage);
            throw new UsernameNotFoundException(errorMessage);
        }
        routine.setDescription(routine.getDescription());
        client.setId(routine.getId());
        var routineCreated = workPlanRepository.save(RoutineDtoMapper.mapToEntity(routine));
        log.info(String.format(ROUTINE_CREATED_MESSAGE,  routineCreated.getId()));
        return RoutineDtoMapper.mapFromEntity(routineCreated);
    }

    @Override
    public Optional<WorkPlan> findByRoutineName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<RoutineDTO> searchRoutineById(Long id) {
        return Optional.empty();
    }

    @Override
    public RoutineDTO editRoutineById(Long id) {
        return null;
    }

    @Override
    public List<WorkPlan> findAll() {
        return null;
    }

    @Override
    public List<WorkPlan> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<WorkPlan> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<WorkPlan> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(WorkPlan entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends WorkPlan> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends WorkPlan> S save(S entity) {
        return null;
    }

    @Override
    public <S extends WorkPlan> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<WorkPlan> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends WorkPlan> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends WorkPlan> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<WorkPlan> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public WorkPlan getOne(Long aLong) {
        return null;
    }

    @Override
    public WorkPlan getById(Long aLong) {
        return null;
    }

    @Override
    public WorkPlan getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends WorkPlan> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends WorkPlan> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends WorkPlan> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends WorkPlan> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends WorkPlan> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends WorkPlan> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends WorkPlan, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
