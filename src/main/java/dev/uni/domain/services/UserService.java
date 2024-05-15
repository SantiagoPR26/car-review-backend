package dev.uni.domain.services;

import dev.uni.domain.entities.User;
import dev.uni.infrastructure.repository.user.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto userDto);

    List<User> getAll();

    User getOne(int id);
}
