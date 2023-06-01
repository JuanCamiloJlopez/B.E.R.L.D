package edu.jdc.swll.berld.Berld.service;

import edu.jdc.swll.berld.Berld.model.dtos.GroupDTO;
import edu.jdc.swll.berld.Berld.model.entities.Group;
import edu.jdc.swll.berld.Berld.model.mappers.GroupDtoMapper;
import edu.jdc.swll.berld.Berld.repository.GroupRepository;
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
public class GroupServiceImpl implements GroupService{

    private static final String GROUP_NOT_FOUND_MESSAGE = "Group %s not found";
    private static final String GROUP_CREATED_MESSAGE = "Group %s created with id %d";
    private static final String GROUP_EDITED_MESSAGE = "Gruop %s edited with id %d";
    private final GroupRepository groupRepository;


    @Override
    @Transactional
    public GroupDTO addGroup(GroupDTO group) {
        var groupOptional = groupRepository.findById(group.getId());
        if(groupOptional.isEmpty()){
            var errorMessage = String.format(GROUP_NOT_FOUND_MESSAGE, group.getId());
            log.error(errorMessage);
            throw new UsernameNotFoundException(errorMessage);
        }
        group.setDescription(group.getDescription());
        group.setName(group.getName());
        var groupCreated = groupRepository.save(GroupDtoMapper.mapToEntity(group));
        log.info(String.format(GROUP_CREATED_MESSAGE, groupOptional.get().getName(), groupCreated.getId()));
        return GroupDtoMapper.mapFromEntity(groupCreated);
    }

   // @Override
    //public Optional<Group> findByGroupName(String name) {
      ////if(groupOptional.isEmpty()){
          //  var errorMessage = String.format(GROUP_NOT_FOUND_MESSAGE, name);
           // log.error(errorMessage);
            //throw new UsernameNotFoundException(errorMessage);
       //}
        //return groupOptional;
    //}

    @Override
    public Optional<GroupDTO> searchGroupById(Long id) {
        var groupOptional = groupRepository.findById(id);
        return groupOptional.map(GroupDtoMapper::mapFromEntity);
    }

    @Override
    public GroupDTO editCourseById(Long id) {
        var groupOptional = groupRepository.findById(id);
        if(groupOptional.isEmpty()){
            var errorMessage = String.format(GROUP_NOT_FOUND_MESSAGE, groupOptional.get().getName());
            log.error(errorMessage);
            throw new UsernameNotFoundException(errorMessage);
        }
        groupOptional.get().setDescription(groupOptional.get().getDescription());
        groupOptional.get().setName(groupOptional.get().getName());
        var groupEdited = groupRepository.save(groupOptional.get());
        log.info(String.format(GROUP_EDITED_MESSAGE, groupEdited.getName(), groupEdited.getId()));
        return GroupDtoMapper.mapFromEntity(groupEdited);
    }

    @Override
    public List<Group> findAll() {
        return null;
    }

    @Override
    public List<Group> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Group> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Group> findAllById(Iterable<Long> longs) {
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
    public void delete(Group entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Group> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Group> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Group> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Group> findById(Long aLong) {
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
    public <S extends Group> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Group> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Group> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Group getOne(Long aLong) {
        return null;
    }

    @Override
    public Group getById(Long aLong) {
        return null;
    }

    @Override
    public Group getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Group> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Group> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Group> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Group> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Group> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Group> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Group, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
