// LoginController.java
package com.Boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Updated to return "register"
    }
    
//    
//    @GetMapping("/forgot-password")
//    public String showForgotPasswordForm() {
//        return "forgot_password";
//    }
//    
//    @PostMapping("/forgot-password")
//    public ModelAndView processForgotPassword(@RequestParam("email") String email) {
//        String message = userService.forgotPassword(email);
//        return new ModelAndView("forgot_password", "message", message);
    

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user,RedirectAttributes attr) {
        String res=userService.resgisterUser(user);
        attr.addFlashAttribute("result", res);
        return "redirect:/login"; // Redirect to login page after successful registration
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,RedirectAttributes attr) {
        // Implement login logic
    	 String res=userService.login(username, password);
    	 System.out.println(username+""+password);
    //	map.put("res", res);
    	attr.addFlashAttribute("res", res);
    	System.out.println(res);
        return "redirect:/login";
    }

    @GetMapping("/forgot-password")
    public String showForgotPasswordPage() {
    	
    	
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {
        userService.forgotPassword(email);
        return "redirect:/login";
    }
}
