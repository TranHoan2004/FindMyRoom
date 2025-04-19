package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.request.UserRequestDTO;
import com.FindMyRoom.dto.response.UserResponseDTO;
import com.FindMyRoom.mapping.UserMapping;
import com.FindMyRoom.model.Users;
import com.FindMyRoom.model.utils.Role;
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
    private final UserMapping mapping;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public UserServiceImpl(UserRepository repo, BCryptPasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
        this.mapping = new UserMapping();
    }

    @Override
    public List<String> getAllEmails() throws Exception {
        List<String> emails = repo.getEmails();
        if (emails.isEmpty()) {
            throw new Exception("Not found");
        }
        return emails;
    }

    @Override
    public UserResponseDTO getUserDTOByEmail(String email) throws Exception {
        logger.info("getUserDTOByEmail");
        Users users = repo.getByEmail(email);
        if (users == null) {
            throw new Exception("User not found");
        }
        return mapping.convert(users);
    }

    @Override
    public void addAnNewAccount(@NotNull UserRequestDTO userDTO) {
        logger.info("addAnNewAccount");
        Users users = mapping.convert(userDTO);
        users.setCreatedDate(LocalDate.now());
        users.setPassword(encoder.encode(userDTO.getPassword()));
        users.setStatus(true);
        users.setRole(Role.ROLE_USER);
        repo.save(users);
    }

    @Override
    public void updateUserDTO(String email, String password) throws Exception {
        logger.info("updateUserDTO");
        Users users = repo.getByEmail(email);
        if (users == null) {
            throw new Exception("User not found");
        }
        // update users information
        users.setPassword(encoder.encode(password));

        // update
        repo.save(users);
    }

    @Override
    public Optional<UserResponseDTO> getAllUserDTOs() throws Exception {
        logger.info("getAllUserDTOs");
        Iterable<Users> list = repo.findAll();
        if (!list.iterator().hasNext()) {
            throw new Exception("No results");
        }
        Optional<UserResponseDTO> optionalUser = Optional.empty();
        for (Users user : list) {
            optionalUser = Optional.of(mapping.convert(user));
        }
        return optionalUser;
    }

    @Override
    public boolean isPhoneNumberExisting(String phoneNumber) {
        logger.info("isPhoneNumberExisting");
        return repo.existsByPhoneNumber(phoneNumber);
    }
}
