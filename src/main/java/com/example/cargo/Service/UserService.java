package com.example.cargo.Service;

import com.example.cargo.Entity.User;
import com.example.cargo.model.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
