package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.model.User;
import com.FindMyRoom.repository.UserRepository;
import com.FindMyRoom.service.UserService;
import com.FindMyRoom.utils.CurrentDate;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<String> getAllEmails() {
        return userRepository.getEmails();
    }

    @Override
    public UserDTO getUserDTOByEmail(String email) {
        User users = userRepository.getByEmail(email);
        return convert(users);
    }

    @Override
    public void addAnNewAccount(UserDTO userDTO) throws ParseException {
        if (userDTO != null) {
            userDTO.setCreatedDate(CurrentDate.getCurrentDate());
            userDTO.setStatus(true);
            userRepository.save(convert(userDTO));
        }
    }

    private UserDTO convert(@NotNull User user) {
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

    private User convert(@NotNull UserDTO user) {
        return User.builder()
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
