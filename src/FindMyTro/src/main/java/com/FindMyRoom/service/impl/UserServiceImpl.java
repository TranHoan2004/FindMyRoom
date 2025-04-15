package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.mapping.UserMapping;
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
    private final UserMapping mapping;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public UserServiceImpl(UserRepository repo, BCryptPasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
        this.mapping = new UserMapping();
    }

    @Override
    public List<String> getAllEmails() {
        return repo.getEmails();
    }

    @Override
    public UserDTO getUserDTOByEmail(String email) throws Exception {
        logger.info("getUserDTOByEmail");
        Users users = repo.getByEmail(email);
        if (users == null) {
            throw new Exception("User not found");
        }
        return mapping.convert(users);
    }

    @Override
    public void addAnNewAccount(@NotNull UserDTO userDTO) {
        logger.info("addAnNewAccount");
        userDTO.setCreatedDate(LocalDate.now());
        userDTO.setStatus(true);
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        repo.save(mapping.convert(userDTO));
    }

    @Override
    public void updateUserDTO(@NotNull UserDTO userDTO) {
        logger.info("updateUserDTO");
        Users users = repo.getByEmail(userDTO.getEmail());

        // update users information
        users.setPhoneNumber(userDTO.getPhoneNumber());
        users.setEmail(userDTO.getEmail());
        users.setPassword(userDTO.getPassword());

        // update
        repo.save(users);
    }

    @Override
    public Optional<UserDTO> getAllUserDTOs() throws Exception {
        logger.info("getAllUserDTOs");
        Iterable<Users> list = repo.findAll();
        if (!list.iterator().hasNext()) {
            throw new Exception("No results");
        }
        Optional<UserDTO> optionalUser = Optional.empty();
        for (Users user : list) {
            optionalUser = Optional.of(mapping.convert(user));
        }
        return optionalUser;
    }

    @Override
    public boolean isEmailExist(String email) {
        logger.info("is email existing?");
        return repo.existsByEmail(email);
    }
}
