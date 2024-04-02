package com.Boot;

public interface UserService {
    String forgotPassword(String email);
    void resetPassword(String token, String newPassword);
    String resgisterUser(User user);
    
    String login(String username,String password);
    
    //forget pword
    
   // User findByemail(String email);
}