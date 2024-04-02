package com.Boot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public String forgotPassword(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            // Generate and send password reset link
            String token = generateToken(); // Implement this method to generate a unique token
            String resetLink = "http://yourwebsite.com/reset?token=" + token;
            emailService.sendEmail(email, "Password Reset", "Click the link to reset your password: " + resetLink);
        } else {
            // Handle case when email is not registered
        }
		return email;
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        // Implement password reset logic using token
    }

    private String generateToken() {
        // Implement token generation logic
        return null;
    }

	@Override
	public String resgisterUser(User user) {
		userRepository.save(user);
		
	return " register succsssfull ";
		
	}

	@Override
	public String login(String username, String password) {
	Optional<User> u=	userRepository.findByUsernameAndPassword(username, password);
	if(u.isPresent()) {
		User u1=u.get();
		return "login successfull";
	}
	return "invalid credentials";
	}

	
}