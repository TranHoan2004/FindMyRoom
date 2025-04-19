package com.FindMyRoom.service.impl;

import com.FindMyRoom.repository.UserRepository;
import com.FindMyRoom.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceImplTest {
    @Mock
    private UserRepository repo;

    @InjectMocks
    private UserServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllEmails() {
        when(repo.getEmails()).thenReturn(List.of("email1", "email2", "email3"));
        List<String> list = null;
        try {
            list = service.getAllEmails();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list);
    }
}
