package edu.jdc.swll.berld.Berld.service;

import edu.jdc.swll.berld.Berld.model.dtos.InstructorDTO;
import edu.jdc.swll.berld.Berld.model.entities.Instructor;
import edu.jdc.swll.berld.Berld.model.mappers.InstructorDtoMapper;
import edu.jdc.swll.berld.Berld.repository.InstructorRepository;
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
public class InstructorServiceImpl implements InstructorService{

    private static final String INSTRUCTOR_NOT_FOUND_MESSAGE = "Routine %s not found";
    private static final String INSTRUCTOR_CREATED_MESSAGE = "Routine %s created with id %d";
    private static final String ROUTINE_EDITED_MESSAGE = "Routine %s edited with id %d";

    private final InstructorRepository instructorRepository;

    @Override
    @Transactional
    public InstructorDTO addInstructor(InstructorDTO instructor) {
        var instructorOptional = instructorRepository.findById(instructor.getId());
        if(instructorOptional.isEmpty()){
            var errorMessage = String.format(INSTRUCTOR_NOT_FOUND_MESSAGE, instructor.getName(), instructor.getId());
            log.error(errorMessage);
            throw new UsernameNotFoundException(errorMessage);
        }
        instructor.setName(instructor.getName());
        instructor.setLastname(instructor.getLastname());
        var routineCreated = instructorRepository.save(InstructorDtoMapper.mapToEntity(instructor));
        log.info(String.format(INSTRUCTOR_CREATED_MESSAGE,  routineCreated.getId()));
        return InstructorDtoMapper.mapFromEntity(routineCreated);
    }

    @Override
    public Optional<Instructor> findByInstructorName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<InstructorDTO> searchById(Long id) {
        return Optional.empty();
    }

    @Override
    public InstructorDTO editInstructorById(Long id) {
        return null;
    }

    @Override
    public List<Instructor> findAll() {
        return null;
    }

    @Override
    public List<Instructor> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Instructor> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Instructor> findAllById(Iterable<Long> longs) {
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
    public void delete(Instructor entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Instructor> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Instructor> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Instructor> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Instructor> findById(Long aLong) {
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
    public <S extends Instructor> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Instructor> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Instructor> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Instructor getOne(Long aLong) {
        return null;
    }

    @Override
    public Instructor getById(Long aLong) {
        return null;
    }

    @Override
    public Instructor getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Instructor> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Instructor> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Instructor> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Instructor> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Instructor> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Instructor> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Instructor, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
