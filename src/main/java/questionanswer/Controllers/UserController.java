package questionanswer.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import questionanswer.EntityAndRepository.User;
import questionanswer.EntityAndRepository.UserRepository;
import questionanswer.Service.UserService;

import java.util.Map;

@Controller
public class UserController {


    @Autowired
    public UserService userService;

    @Autowired
    public UserRepository userRepository;

//    @GetMapping("/user")
//    public String listUser(Map<String, Object> model) {
//        model.put("users", userService.listUserService());
//        return "listUser";
//    }

//    @PostMapping("/user")
//    public String saveUser(@RequestParam("id") User user, @RequestParam String username, @RequestParam String password, Map<String, Object> model) {
//        userService.saveUserService(user, username, password);
//        return "redirect:/user";
//    }

    @GetMapping("/edit_profile")
    public String editProfile(@AuthenticationPrincipal User user, Map<String, Object> model) {
        model.put("user",user);
        return "edit_profile";
    }

    @PostMapping("/edit_profile")
    public String saveProfile(@AuthenticationPrincipal User user, @RequestParam String username, @RequestParam String password, @RequestParam String email, Model model) {
//        userService.checkUserData(user, username, password, email);
        if (userService.checkUserData(user, username, password, email)){
            model.addAttribute("rezult","Successfull save");
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            model.addAttribute("email", email);
            return "redirect:/main";
        }
        else{
            model.addAttribute("rezult","Unsuccessfull save");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("password", user.getPassword());
            model.addAttribute("email", user.getEmail());
            return "edit_profile";
        }
    }

    @GetMapping("/profile")
    public String viewProfile(@AuthenticationPrincipal User user, Map<String, Object> model) {
        model.put("username", user.getUsername());
        model.put("password", user.getPassword());
        model.put("email", user.getEmail());
        model.put("address", user.getAddress());
        model.put("firstname", user.getFirstname());
        model.put("lastname", user.getLastname());
        model.put("country", user.getCountry());
        model.put("city", user.getCity());
        return "profile";
    }

//    @GetMapping("/profile/{answer.username}")
//    public String viewUser(@PathVariable("answer.username") String usernameAnswer, Map<String, Object> model) {
//        Iterable<User> user= (Iterable<User>) userRepository.findByUsername(usernameAnswer);
//        model.put("username", ((User) user).getUsername());
//        model.put("password", ((User) user).getPassword());
//        model.put("email", ((User) user).getEmail());
//        model.put("address", ((User) user).getAddress());
//        model.put("firstname", ((User) user).getFirstname());
//        model.put("lastname", ((User) user).getLastname());
//        model.put("country", ((User) user).getCountry());
//        model.put("city", ((User) user).getCity());
//        System.out.println(user);
//            return "profile";
//    }

    @GetMapping("/profile/{user.id}")
    public String viewUser2(@PathVariable("user.id") User user, Map<String, Object> model) {
//        User user= userRepository.findByUsername(usernameQuestion);
//        model.put("username", ((User) user).getUsername());
//        model.put("password", ((User) user).getPassword());
//        model.put("email", ((User) user).getEmail());
//        model.put("address", ((User) user).getAddress());
//        model.put("firstname", ((User) user).getFirstname());
//        model.put("lastname", ((User) user).getLastname());
//        model.put("country", ((User) user).getCountry());
//        model.put("city", ((User) user).getCity());
//        System.out.println(user);
        return "profile";
    }

}

