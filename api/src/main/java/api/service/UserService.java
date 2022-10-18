package api.service;

import api.dto.User;
import api.dto.UserRole;
import api.entity.UserEntity;
import api.repository.UserRepository;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;


@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(UUID userId) {
        return User.convert(userRepository.findFirstById(userId));
    }

    public List<User> getUserList() {
        return userRepository.findAll().stream().map(User::convert).toList();
    }

    public List<User> getUsersWithItems() {
        return userRepository.findAllWithItems().stream().map(User::convert).toList();
    }

    public void addUser(User user) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Set.of(new UserRole(UUID.fromString("7f74bb02-9f14-43ce-8b28-8c0c889d1558"), "USER")));
        userRepository.save(UserEntity.convert(user));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserEntity userEntity = userRepository.findByUsername(username);
            return User.convert(userEntity);
        } catch (AuthenticationException e) {
            throw new UsernameNotFoundException(String.format("User by username: %s does not exist", username));
        }

    }
}

