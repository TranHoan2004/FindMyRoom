package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.model.Users;
import com.FindMyRoom.repository.UserRepository;
import com.FindMyRoom.repository.impl.UserRepositoryImpl;
import com.FindMyRoom.service.UserService;
import com.FindMyRoom.utils.CurrentDate;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepositoryImpl repo, BCryptPasswordEncoder encoder) {
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
    public void addAnNewAccount(@NotNull UserDTO userDTO) throws ParseException {
        userDTO.setCreatedDate(CurrentDate.getCurrentDate());
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

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UserDTO users = getUserDTOByEmail(email);
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        if (users == null) {
//            throw new UsernameNotFoundException("Email is not existing");
//        }
//        System.out.println(users.toString());
//        authorities.add(new SimpleGrantedAuthority(users.getRole().name()));
//        return new User(users.getEmail(), users.getPassword(), authorities);
//    }

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
