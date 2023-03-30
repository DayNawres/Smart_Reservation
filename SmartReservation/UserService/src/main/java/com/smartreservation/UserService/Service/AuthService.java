package com.smartreservation.UserService.Service;

import com.smartreservation.UserService.Enum.RoleEnum;
import com.smartreservation.UserService.Model.Role;
import com.smartreservation.UserService.Model.User;
import com.smartreservation.UserService.Repository.UserRepository;
import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    JwtService jwtService;

    public String saveUser(MultipartFile file,String firstname,String lastname,String email,String username,String password) {
        User user=new User();
        String filename=StringUtils.cleanPath(file.getOriginalFilename());
        if (filename.contains(".."))
        {System.out.println(("not a valid file"));}
        try {
            user.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Role role=new Role(1,RoleEnum.ROLE_USER);


        user.setPassword(passwordEncoder.encode(password));
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setEmail(email);
        user.setEnabled(true);
        repository.save(user);
        return "user added to the system";
    }
    public String generateToken(String username){
        return jwtService.generateToken(username);
    }
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }

}