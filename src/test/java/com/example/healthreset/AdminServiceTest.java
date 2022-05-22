package com.example.healthreset;

import com.example.healthreset.model.Admin;
import com.example.healthreset.repository.AdminRepository;
import com.example.healthreset.service.AdminService;
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
public class AdminServiceTest {

    @InjectMocks
    private AdminService adminService;

    @Mock
    private AdminRepository adminRepository;

    Dummy dummy = new Dummy();

    @Test
    public void loginTestNonExistentUsername(){
        when(adminRepository
                .findByUsername(dummy.getNonExistentUsernameAdminDTO().getUsername()))
                .thenReturn(Optional.empty());
        String returnedString =
                adminService.login(
                        dummy.getNonExistentUsernameAdminDTO().getUsername(),
                        dummy.getNonExistentUsernameAdminDTO().getPassword());
        assertEquals("username_error", returnedString);
    }

    @Test
    public void loginTestIncorrectPassword(){
        Admin expectedAdminFoundByUsername = dummy.getExpectedAdmin();
        when(adminRepository
                .findByUsername(dummy.getIncorrectPasswordExistentAdminDTO().getUsername()))
                .thenReturn(Optional.of(expectedAdminFoundByUsername));
        String returnedString =
                adminService.login(
                        dummy.getIncorrectPasswordExistentAdminDTO().getUsername(),
                        dummy.getIncorrectPasswordExistentAdminDTO().getPassword());
        assertEquals("password_error", returnedString);
    }

    @Test
    public void loginTestSuccess(){
        UsersMapper adminMapper =  new UsersMapper();
        Admin expectedAdmin = adminMapper.convertDTOtoAdmin(dummy.getExistentAdminDTO());

        when(adminRepository.findByUsername(dummy.getExistentAdminDTO().getUsername()))
                .thenReturn(Optional.of(expectedAdmin));
        String returnedString = adminService.login(
                dummy.getExistentAdminDTO().getUsername(),
                dummy.getExistentAdminDTO().getPassword());
        assertEquals("ok", returnedString);
    }
}
