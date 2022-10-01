package api.service;

import api.dto.User;
import api.entity.UserEntity;
import api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(UUID userId) {
        return User.convert(userRepository.findFirstById(userId));
    }

    public void addUser(User user) {
        userRepository.save(UserEntity.convert(user));
    }
}
