package com.example.healthreset;

import com.example.healthreset.model.RegularUser;
import com.example.healthreset.repository.RegularUserRepository;
import com.example.healthreset.service.RegularUserService;
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
public class RegularUserServiceTest {

    @InjectMocks
    private RegularUserService regularUserService;

    @Mock
    private RegularUserRepository regularUserRepository;

    Dummy dummy = new Dummy();

    @Test
    public void checkIfValidTrueTest(){
        when(regularUserRepository.findByEmail(dummy.getNewRegularUserDTO().getEmail())).thenReturn(Optional.empty());
        when(regularUserRepository.findByUsername(dummy.getNewRegularUserDTO().getUsername())).thenReturn(Optional.empty());
        String returnedString =
                regularUserService.checkIfValid(
                        dummy.getNewRegularUserDTO().getEmail(),
                        dummy.getNewRegularUserDTO().getUsername());
        assertEquals("ok", returnedString);
    }

    @Test
    public void checkIfValidExistentUsernameTest(){
        when(regularUserRepository
                .findByEmail(dummy.getNewRegularUserDTO().getEmail()))
                .thenReturn(Optional.empty());
        when(regularUserRepository
                .findByUsername(dummy.getNewRegularUserDTO().getUsername()))
                .thenReturn(Optional.of(dummy.getExpectedRegularUser()));
        String returnedString =
                regularUserService.checkIfValid(
                        dummy.getNewRegularUserDTO().getEmail(),
                        dummy.getNewRegularUserDTO().getUsername());
        assertEquals("username_exists", returnedString);
    }

    @Test
    public void checkIfValidExistentEmailTest(){
        when(regularUserRepository
                .findByEmail(dummy.getNewRegularUserDTOExistentEmail().getEmail()))
                .thenReturn(Optional.of(dummy.getExpectedRegularUser()));
        String returnedString =
                regularUserService.checkIfValid(
                        dummy.getExpectedRegularUser().getEmail(),
                        dummy.getExpectedRegularUser().getUsername());
        assertEquals("email_exists", returnedString);
    }

    @Test
    public void checkIfValidInvalidEmailTest(){
        String returnedString =
                regularUserService.checkIfValid(
                        dummy.getNewRegularUserDTOInvalidEmail().getEmail(),
                        dummy.getNewRegularUserDTOInvalidEmail().getUsername());
        assertEquals("invalid_email", returnedString);
    }

    @Test
    public void loginTestNonExistentUsername(){
        when(regularUserRepository
                .findByUsername(dummy.getNonExistentUsernameRegularUserDTO().getUsername()))
                .thenReturn(Optional.empty());
        String returnedString =
                regularUserService.login(
                        dummy.getNonExistentUsernameRegularUserDTO().getUsername(),
                        dummy.getNonExistentUsernameRegularUserDTO().getPassword());
        assertEquals("username_error", returnedString);
    }

    @Test
    public void loginTestIncorrectPassword(){
       RegularUser expectedRegularUser = dummy.getExpectedRegularUser();
        when(regularUserRepository
                .findByUsername(dummy.getIncorrectPasswordExistentRegularUserDTO().getUsername()))
                .thenReturn(Optional.of(expectedRegularUser));
        String returnedString =
                regularUserService.login(
                        dummy.getIncorrectPasswordExistentRegularUserDTO().getUsername(),
                        dummy.getIncorrectPasswordExistentRegularUserDTO().getPassword());
        assertEquals("password_error", returnedString);
    }

    @Test
    public void loginTestSuccess(){
        UsersMapper regularUsersMapper = new UsersMapper();
        RegularUser regularUser = regularUsersMapper.convertDTOtoRegularUser(dummy.getExistentRegularUserDTO());

        when(regularUserRepository.findByUsername(dummy.getExistentRegularUserDTO().getUsername()))
                .thenReturn(Optional.of(regularUser));
        String returnedString = regularUserService.login(
                dummy.getExistentRegularUserDTO().getUsername(),
                dummy.getExistentRegularUserDTO().getPassword());
        assertEquals("ok", returnedString);
    }

}
