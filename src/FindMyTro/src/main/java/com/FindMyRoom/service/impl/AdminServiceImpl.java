package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.AdminDTO;
import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.model.Admin;
import com.FindMyRoom.model.Users;
import com.FindMyRoom.repository.AdminRepository;
import com.FindMyRoom.repository.impl.AdminRepositoryImpl;
import com.FindMyRoom.service.AdminService;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final EntityManager entityManager;

    @Autowired
    public AdminServiceImpl(AdminRepositoryImpl adminRepository, EntityManager em) {
        this.adminRepository = adminRepository;
        this.entityManager = em;
    }

    @Override
    public List<String> getAllEmails() throws Exception {
        return null;
    }

    @Override
    public AdminDTO getAdminDTOByID(long id) throws Exception {
        return null;
    }

    @Override
    public Optional<AdminDTO> getAllAdminDTOs() {
        Session session = entityManager.unwrap(Session.class);
        Optional<Admin> users = session.createQuery("from Admin", Admin.class).uniqueResultOptional();
        return users.map(this::convert);
    }

    @Nullable
    private AdminDTO convert(@NotNull Admin admin) {
        Users user = admin.getUser();
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .createdDate(user.getCreatedDate())
                .fullname(user.getFullname())
                .gender(user.getGender())
                .imgURL(user.getImgURL())
                .phoneNumber(String.valueOf(user.getPhoneNumber()))
                .status(user.getStatus())
                .build();
        return AdminDTO.builder()
                .user(userDTO)
                .build();
    }
}
