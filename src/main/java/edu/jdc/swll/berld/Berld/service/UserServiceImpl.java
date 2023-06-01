package edu.jdc.swll.berld.Berld.service;

import edu.jdc.swll.berld.Berld.model.dtos.UserDTO;
import edu.jdc.swll.berld.Berld.model.entities.User;
import edu.jdc.swll.berld.Berld.model.enums.RoleType;
import edu.jdc.swll.berld.Berld.model.mappers.UserDtoMapper;
import edu.jdc.swll.berld.Berld.repository.RoleRepository;
import edu.jdc.swll.berld.Berld.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private static final String USER_CREATED_MESSAGE = "User %s created with id %d";
    private static final String ROLE_ASSIGNED_MESSAGE = "Role %s assigned to user %s";
    private static final String USER_NOT_FOUND_MESSAGE = "User %s not found";
    private static final String USER_FOUND_MESSAGE = "User {} found in the database";

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAll(Sort sort) {
        return userRepository.findAll(sort);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<User> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends User> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public <S extends User> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<User> findById(Long aLong) {
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
    public <S extends User> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<User> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public User getOne(Long aLong) {
        return null;
    }

    @Override
    public User getById(Long aLong) {
        return null;
    }

    @Override
    public User getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends User> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends User> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var userCreated = userRepository.save(UserDtoMapper.mapToEntity(user));
        log.info(String.format(USER_CREATED_MESSAGE, user.getUsername(), userCreated.getId()));
        return UserDtoMapper.mapFromEntity(userCreated);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userOptional = userRepository.findByUsername(username);
        if(userOptional.isEmpty()){
            var errorMessage = String.format(USER_NOT_FOUND_MESSAGE, username);
            log.error(errorMessage);
            throw new UsernameNotFoundException(errorMessage);
        }
        var user = userOptional.get();
        log.info(USER_FOUND_MESSAGE, username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName().name())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }


    @Override
    @Transactional
    public void assignRoleToUser(String userName, RoleType roleType) {
        var userOptional= userRepository.findByUsername(userName);
        userOptional.ifPresent(user->{
            var roleOptional=  roleRepository.findByName(roleType);
            roleOptional.ifPresent(role -> user.getRoles().add(role));
            log.info(String.format(ROLE_ASSIGNED_MESSAGE, roleType.name(), user.getUsername()));
        });
    }

    @Override
    public Optional<UserDTO> findByUserName(String userName) {
        var userOptional = userRepository.findByUsername(userName);
        return userOptional.map(UserDtoMapper::mapFromEntity);
    }
}
