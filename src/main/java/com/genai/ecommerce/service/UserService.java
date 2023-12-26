package com.genai.ecommerce.service;

import com.genai.ecommerce.entity.User;
import com.genai.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OTPGeneratorService otpGeneratorService;




    public void changePassword(Long userId, String newPassword) throws Exception {
        // Step 1: Find the user by their ID
        Optional<User> optionalUser = userRepository.findById(userId);

        if (!optionalUser.isPresent()) {
            throw new Exception("User not found");
        }

        User user = optionalUser.get();

        // Step 2: Validate the new password (you can add more validation rules)
        if (newPassword == null || newPassword.isEmpty() || newPassword.length() < 8) {
            throw new Exception("Invalid password");
        }

        // Step 3: Hash the new password securely (you should use a password hashing library)
//        String hashedPassword = hashPassword(newPassword);

        // Step 4: Update the user's password in the database
        user.setPassword(newPassword);
        userRepository.save(user);
    }


}
