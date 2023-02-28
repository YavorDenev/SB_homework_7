package DigRz.SB_homework_5.services;

import DigRz.SB_homework_5.authorisation.MyUserDetails;
import DigRz.SB_homework_5.entities.User;
import DigRz.SB_homework_5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void saveUser(User user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
//        user.setRole(Role.ROLE_USER);
        userRepo.save(user);
    }

    @Override
    public List<Object> isUserPresent(User user) {
        boolean userExists = false;
        String message = null;
        User u  = userRepo.getUserByUsername(user.getUsername());
        if(u != null){
            userExists = true;
            message = "Username Already Present!";
        }

        return Arrays.asList(userExists, message);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = userRepo.getUserByUsername(username);
        if (user==null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return new MyUserDetails(user);
    }

}
