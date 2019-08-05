package questionanswer.Service;

import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import questionanswer.Role;
import questionanswer.EntityAndRepository.User;
import questionanswer.EntityAndRepository.UserRepository;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public MailService mailService;
    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public boolean addUser(User user) {
        if (user.getUsername() != null && userRepository.findByUsername(user.getUsername()) == null) {
            Set<Role> roles = new HashSet<>();
            roles.add(Role.USER);
            user.setRoles(roles);
            user.setCode(UUID.randomUUID().toString());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            System.out.println(user);
            if (!StringUtils.isNullOrEmpty(user.getEmail())) {
                mailService.sendMessage(user.getEmail(), "Information", "Hi! http:/localhost:8080/activate/" + user.getCode());
            }
            return true;
        }

        return false;
    }


    public boolean checkActivation(String code) {
        User searchRezult = userRepository.findByCode(code);
        if (searchRezult == null) {
            return false;
        } else {
            searchRezult.setCode(null);
            userRepository.save(searchRezult);
            return true;
        }
    }

    public boolean checkUserData(User user, String username, String password, String email) {
        boolean checkData =false;
        if (username.isEmpty() || userRepository.findByUsername(username) != null) {


            System.out.println("Wrong username!");


        } else {
            user.setUsername(username);
            checkData=true;
        }
        if (!password.isEmpty())
            user.setPassword(password);
        else System.out.println("wrong password");


//                if (userRepository.findByEmail(email)==null && !userRepository.findByEmail(email).equals(user) && !StringUtils.isNullOrEmpty(user.getEmail())) {
//                    checkEmail = true;
        user.setEmail(email);
//                }
//                else {
//                    System.out.println("wrong email");
//                }

        userRepository.save(user);
//
//                if(checkEmail){
        user.setCode(UUID.randomUUID().toString());

        mailService.sendMessage(user.getEmail(), "Information", "Hi! http:/localhost:8080/activate/" + user.getCode());
//                }
        return checkData;
    }

    public String saveUserService(User user, String username, String password) {
        if (userRepository.findByUsername(username) == null) {
            user.setUsername(username);
        }
        if (password != null && password != user.getPassword()) {
            user.setPassword(passwordEncoder.encode(password));
        }
        userRepository.save(user);
        return "saveUserService";

    }

    public Iterable<User> listUserService() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

}
