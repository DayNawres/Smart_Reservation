package com.smartreservation.UserService.Controller;

import com.smartreservation.UserService.Payload.JwtResponse;
import com.smartreservation.UserService.Service.AuthService;
import com.smartreservation.UserService.Service.UserDetailsImpl;
import com.smartreservation.UserService.dto.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestParam("file")MultipartFile file,@RequestParam("firstname")String firstname,@RequestParam("lasttname")String lastname,@RequestParam("username")String username,@RequestParam("femail")String email,@RequestParam("password")String password) {
        return service.saveUser(file, firstname, lastname,  email, username,password);
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping("/token")
    public ResponseEntity<JwtResponse> getToken(@RequestBody AuthRequest authrequest) {
        String jwt=service.generateToken((authrequest.getUsername()));
        Authentication authenticate=authenticationManager.authenticate((new UsernamePasswordAuthenticationToken(authrequest.getUsername(),authrequest.getPassword())));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticate.getPrincipal();
        String roles = userDetails.getAuthorities().toString();
        if (authenticate.isAuthenticated())
        {return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                roles));}
        else {throw  new RuntimeException("invalid access");}
    }


    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}