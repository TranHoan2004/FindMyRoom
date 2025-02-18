package com.FindMyRoom.service;

import com.FindMyRoom.dto.UserDTO;
import com.FindMyRoom.service.impl.UserServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInformationService implements UserDetailsService {
    private final UserService service;

    public UserInformationService(UserServiceImpl service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDTO users = service.getUserDTOByEmail(email);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (users == null) {
            throw new UsernameNotFoundException("Email is not existing");
        }
        email = users.getEmail();
        String password = users.getPassword();
        authorities.add(new SimpleGrantedAuthority(users.getRole().name()));
        return new User(email, password, authorities);
    }
}
