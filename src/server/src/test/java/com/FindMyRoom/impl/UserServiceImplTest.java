package com.FindMyRoom.impl;

import com.FindMyRoom.model.Users;
import com.FindMyRoom.model.utils.Role;
import com.FindMyRoom.repository.UserRepository;
import com.FindMyRoom.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository repo;

    @InjectMocks
    private UserServiceImpl service;

    @Test
    void getAllEmails() {
        List<String> list = List.of("email1", "email2", "email3");
        when(repo.getEmails()).thenReturn(list);

        try {
            List<String> result = repo.getEmails();
            assertNotNull(result);
            assertEquals(3, result.size());
            verify(repo, times(1)).getEmails();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void deleteUser() {
        List<Users> list = new ArrayList<>(List.of(
                Users.builder()
                        .id(1L)
                        .email("email1")
                        .password("password1")
                        .fullname("fullname1")
                        .phoneNumber("0912345678")
                        .gender(true)
                        .imgURL(new byte[]{1, 2, 3})
                        .status(true)
                        .createdDate(LocalDate.now())
                        .role(Role.ROLE_USER)
                        .build(),
                Users.builder()
                        .id(2L)
                        .email("email2")
                        .password("password2")
                        .fullname("fullname2")
                        .phoneNumber("0943265678")
                        .gender(true)
                        .imgURL(new byte[]{1, 2, 3})
                        .status(true)
                        .createdDate(LocalDate.now())
                        .role(Role.ROLE_ADMIN)
                        .build()
        ));
        try {
            when(repo.findAll()).thenReturn(list);
            doAnswer(invocation -> {
                Long idToDelete = invocation.getArgument(0);
                list.removeIf(u -> u.getId().equals(idToDelete));
                return null;
            }).when(repo).deleteById(anyLong());

            repo.deleteById(1L);

            when(repo.findAll()).thenReturn(list);
            assertEquals(1, repo.findAll().size());
            List<Users> result = repo.findAll();
            for (Users user : result) {
                System.out.println(user.getEmail());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getUserDTOByEmail() {
    }

    @Test
    void addAnNewAccount() {
    }

    @Test
    void updateUserDTO() {
    }

    @Test
    void getAllUserDTOs() {
    }

    @Test
    void isPhoneNumberExisting() {
    }
}
