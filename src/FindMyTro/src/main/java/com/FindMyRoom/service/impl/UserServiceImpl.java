package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.model.Users;
import com.FindMyRoom.repository.UserRepository;
import com.FindMyRoom.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public UserServiceImpl(UserRepository repo, BCryptPasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @Override
    public List<String> getAllEmails() {
        return repo.getEmails();
    }

    @Override
    public UserDTO getUserDTOByEmail(String email) {
        Users users = repo.getByEmail(email);
        return users == null ? null : convert(users);
    }

    @Override
    public void addAnNewAccount(@NotNull UserDTO userDTO) {
        userDTO.setCreatedDate(LocalDate.now());
        userDTO.setStatus(true);
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        repo.save(convert(userDTO));
    }

    @Override
    public void updateUserDTO(@NotNull UserDTO userDTO) {
        UserDTO user = convert(repo.getByEmail(userDTO.getEmail()));
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        repo.save(convert(userDTO));
    }

    @Override
    public Optional<UserDTO> getAllUserDTOs() throws Exception {
        Iterable<Users> list = repo.findAll();
        if (!list.iterator().hasNext()) {
            throw new Exception("No results");
        }
        Optional<UserDTO> optionalUser = Optional.empty();
        for (Users user : list) {
            optionalUser = Optional.of(convert(user));
        }
        return optionalUser;
    }

    // <editor-fold> desc="convert entity"
    private UserDTO convert(@NotNull Users user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .createdDate(user.getCreatedDate())
                .fullname(user.getFullname())
                .gender(user.getGender())
                .imgURL(user.getImgURL())
                .phoneNumber(String.valueOf(user.getPhoneNumber()))
                .status(user.getStatus())
                .role(user.getRole())
                .build();
    }

    private Users convert(@NotNull UserDTO user) {
        return Users.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .createdDate(user.getCreatedDate())
                .fullname(user.getFullname())
                .gender(user.getGender())
                .imgURL(user.getImgURL())
                .phoneNumber(String.valueOf(user.getPhoneNumber()))
                .status(user.getStatus())
                .role(user.getRole())
                .build();
    }
    // </editor-fold>
}
