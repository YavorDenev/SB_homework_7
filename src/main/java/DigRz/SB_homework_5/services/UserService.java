package DigRz.SB_homework_5.services;

import DigRz.SB_homework_5.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;

@Service
public interface UserService {
    public void saveUser(User user);
    public List<Object> isUserPresent(User user);
}
