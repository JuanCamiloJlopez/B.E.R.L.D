package edu.jdc.swll.berld.Berld.service;

import edu.jdc.swll.berld.Berld.model.dtos.UserDTO;
import edu.jdc.swll.berld.Berld.model.entities.User;
import edu.jdc.swll.berld.Berld.repository.RoleRepository;
import edu.jdc.swll.berld.Berld.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    public static final String ENCODED_STRING = "encodedString";
    public static final String PASSWORD = "asdf1234";

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    //SUT
    @InjectMocks
    private UserServiceImpl userService;


    @Test
    void shouldCreateUserTest() {
        var userToCreate = getUserDto();
        var userEntity = getUserEntity();

        Mockito.when(passwordEncoder.encode(PASSWORD)).thenReturn(ENCODED_STRING);
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(userEntity);

        var userCreated = userService.createUser(userToCreate);
        Assertions.assertEquals(userCreated.getEmail(), userToCreate.getEmail());
    }

    private static User getUserEntity() {
        return User
                .builder()
                .email("email@email.com")
                .username("testGuy")
                .password(PASSWORD)
                .build();
    }

    private static UserDTO getUserDto() {
        return UserDTO
                .builder()
                .email("email@email.com")
                .username("testGuy")
                .password(PASSWORD)
                .build();
    }


}
