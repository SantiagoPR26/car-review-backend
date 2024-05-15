package dev.uni.infrastructure.repository.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private String name;
    private String lastName;
    private String username;
    private String email;
    private String password;
}
