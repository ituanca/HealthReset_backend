package com.example.healthreset;

import com.example.healthreset.model.RegularUser;
import com.example.healthreset.model.Specialist;
import com.example.healthreset.repository.RegularUserRepository;
import com.example.healthreset.repository.SpecialistRepository;
import com.example.healthreset.service.RegularUserService;
import com.example.healthreset.service.SpecialistService;
import com.example.healthreset.utils.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpecialistServiceTest {

    @InjectMocks
    private SpecialistService specialistService;

    @Mock
    private SpecialistRepository specialistRepository;

    Dummy dummy = new Dummy();

    @Test
    public void loginTestNonExistentUsername(){
        when(specialistRepository
                .findByUsername(dummy.getNonExistentUsernameSpecialistDTO().getUsername()))
                .thenReturn(Optional.empty());
        String returnedString =
                specialistService.login(
                        dummy.getNonExistentUsernameSpecialistDTO().getUsername(),
                        dummy.getNonExistentUsernameSpecialistDTO().getPassword());
        assertEquals("username_error", returnedString);
    }

    @Test
    public void loginTestIncorrectPassword(){
        Specialist expectedSpecialist = dummy.getExpectedSpecialist();
        when(specialistRepository
                .findByUsername(dummy.getIncorrectPasswordExistentSpecialistDTO().getUsername()))
                .thenReturn(Optional.of(expectedSpecialist));
        String returnedString =
                specialistService.login(
                        dummy.getIncorrectPasswordExistentSpecialistDTO().getUsername(),
                        dummy.getIncorrectPasswordExistentSpecialistDTO().getPassword());
        assertEquals("password_error", returnedString);
    }

    @Test
    public void loginTestSuccess(){
        UsersMapper specialistMapper = new UsersMapper();
        Specialist specialist = specialistMapper.convertDTOtoSpecialist(dummy.getExistentSpecialistDTO());

        when(specialistRepository.findByUsername(dummy.getExistentSpecialistDTO().getUsername()))
                .thenReturn(Optional.of(specialist));
        String returnedString = specialistService.login(
                dummy.getExistentSpecialistDTO().getUsername(),
                dummy.getExistentSpecialistDTO().getPassword());
        assertEquals("ok", returnedString);
    }


}
