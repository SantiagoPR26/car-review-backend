package dev.uni.infrastructure.adapter;

import dev.uni.domain.entities.User;
import dev.uni.domain.services.UserService;
import dev.uni.infrastructure.repository.user.UserDto;
import dev.uni.infrastructure.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class UserAdapter implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        int id = autoIncrement();
        User user = new User(id, userDto.getName(), userDto.getLastName(), userDto.getUsername(),
                userDto.getEmail(), userDto.getPassword());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getOne(int id) {
        return null;
    }

    private int autoIncrement() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ? 1 : users.stream().max(Comparator.comparing(User::getId)).get().getId() + 1;
    }
}
