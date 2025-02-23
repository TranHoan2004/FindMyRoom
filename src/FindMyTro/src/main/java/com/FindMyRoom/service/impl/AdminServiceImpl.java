package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.AdminDTO;
import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.model.Admin;
import com.FindMyRoom.model.Users;
import com.FindMyRoom.repository.AdminRepository;
import com.FindMyRoom.repository.impl.AdminRepositoryImpl;
import com.FindMyRoom.service.AdminService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repo;

    public AdminServiceImpl(AdminRepositoryImpl repo) {
        this.repo = repo;
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
        Iterable<Admin> users = repo.findAll();
        Optional<AdminDTO> list = Optional.empty();
        for (Admin admin : users) {
            list = Optional.ofNullable(convert(admin));
        }
        return list;
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
