package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.model.Users;
import com.FindMyRoom.repository.UserRepository;
import com.FindMyRoom.service.UserService;
import com.FindMyRoom.utils.CurrentDate;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<String> getAllEmails() {
        return userRepository.getEmails();
    }

    @Override
    public UserDTO getUserDTOByEmail(String email) {
        Users users = userRepository.getByEmail(email);
        return convert(users);
    }

    @Override
    public void addAnNewAccount(@NotNull UserDTO userDTO) throws ParseException {
        userDTO.setCreatedDate(CurrentDate.getCurrentDate());
        userDTO.setStatus(true);
        userRepository.save(convert(userDTO));
    }

    @Override
    public void updateUserDTO(@NotNull UserDTO userDTO) {
        UserDTO user = convert(userRepository.getByEmail(userDTO.getEmail()));
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(convert(user));
    }

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
                .build();
    }

}
