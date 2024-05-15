package dev.uni.application;

import dev.uni.domain.entities.User;
import dev.uni.domain.services.UserService;
import dev.uni.infrastructure.repository.user.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserApplication {

    private final UserService userService;

    public User saveUser(User user) {
        UserDto userDto = new UserDto(user.getName(), user.getLastName(), user.getUsername(),
                user.getEmail(), user.getPassword());
        return userService.save(userDto);
    }

}
