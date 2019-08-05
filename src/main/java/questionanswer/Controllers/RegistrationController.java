package questionanswer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import questionanswer.EntityAndRepository.User;
import questionanswer.Service.UserService;

import java.util.*;


@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration( Map<String, Object> model){
        return "registration";
    }

    @PostMapping ("/registration")
    public String addUser(@RequestParam String username, @RequestParam String password, @RequestParam String email, Model model) {
        User user=new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        System.out.println(user);
        if (userService.addUser(user)) {
            model.addAttribute("message", "Successfull registration");
            return "redirect:/login";
        }
        model.addAttribute("message", "Unsuccessfull registration");
        return "registration";
    }
    @GetMapping ("/activation/{code}")
    public String activation(@PathVariable String code, Model model){

        if (userService.checkActivation(code)){
            model.addAttribute("message","Successfull registration");
        }
        else{
            model.addAttribute("message","Unsuccessfull registration");
        }
        return "login";
    }

}