package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.request.UserRequestDTO;
import com.FindMyRoom.dto.response.UserResponseDTO;
import com.FindMyRoom.mapping.UserMapping;
import com.FindMyRoom.model.Users;
import com.FindMyRoom.model.utils.Role;
import com.FindMyRoom.repository.UserRepository;
import com.FindMyRoom.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository repo;
    BCryptPasswordEncoder encoder;
    UserMapping mapping;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public UserServiceImpl(UserRepository repo, BCryptPasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
        this.mapping = new UserMapping();
    }

    @Override
    public List<String> getAllEmails() {
        List<String> emails = repo.getEmails();
        if (emails.isEmpty()) {
            throw new EntityNotFoundException("There are no emails in the database");
        }
        return emails;
    }

    @Override
    public UserResponseDTO getUserDTOByEmail(String email) {
        logger.info("getUserDTOByEmail");
        Users users = repo.getByEmail(email);
        if (users == null) {
            throw new EntityNotFoundException("User not found");
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
    public void updateUserDTO(String email, String password) {
        logger.info("updateUserDTO");
        Users users = repo.getByEmail(email);
        if (users == null) {
            throw new EntityNotFoundException("User not found");
        }
        // update users information
        users.setPassword(encoder.encode(password));

        // update
        repo.save(users);
    }

    @Override
    public Optional<UserResponseDTO> getAllUserDTOs() {
        logger.info("getAllUserDTOs");
        Iterable<Users> list = repo.findAll();
        if (!list.iterator().hasNext()) {
            throw new EntityNotFoundException("There are no Users in the database");
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

    @Override
    public void deleteUser(String email) {
        Users user = repo.getByEmail(email);
        if (user == null) {
            throw new EntityNotFoundException("User not found");
        }
        repo.deleteById(user.getId());
    }
}
