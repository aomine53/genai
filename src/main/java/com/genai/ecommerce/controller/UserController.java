package com.genai.ecommerce.controller;

import com.genai.ecommerce.entity.User;
import com.genai.ecommerce.repository.UserRepository;
import com.genai.ecommerce.service.OTPGeneratorService;
import com.genai.ecommerce.service.TwilioService;
import com.genai.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api") // Define the endpoint path
public class UserController {

    @Autowired
    private UserRepository userRepository; // Inject your UserRepository

    @Autowired
    private UserService userService;

    @Autowired
    private OTPGeneratorService otpGeneratorService;

    @Autowired
    private TwilioService twilioService;

    @GetMapping("/")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public void sendLoginOtp(@RequestParam("username") String username, @RequestParam("password") String password){
        //Find user by username and password
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        if(!user.isPresent()){
            throw new RuntimeException("User not found");
        }
        String otp=otpGeneratorService.generateOTP();
        twilioService.sendOTP(user.get().getPhoneNumber(),otp);
    }

    @PutMapping("/{userId}/change-password")
    public ResponseEntity<?> changePassword(@PathVariable Long userId, @RequestBody String newPassword) {
        try {
            userService.changePassword(userId, newPassword);
            return ResponseEntity.ok("Password changed successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to change password: " + e.getMessage());
        }
    }
}

