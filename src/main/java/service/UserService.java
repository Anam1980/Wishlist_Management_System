package service;

import Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void login(User user) {
        userRepository.save(user);
        return;
    }
}
