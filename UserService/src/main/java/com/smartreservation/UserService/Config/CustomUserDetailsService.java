package com.smartreservation.UserService.Config;

import com.smartreservation.UserService.Model.User;
import com.smartreservation.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=repository.findByUsername(username);
        return user.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found with name :" + username));
    }
}
