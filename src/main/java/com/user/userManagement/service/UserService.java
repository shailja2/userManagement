package com.user.userManagement.service;

import com.user.userManagement.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);

    List<UserDTO> findAllUsers();

    void deleteUser(Long Id);

    void updateUser(Long userId, String name, String email, String pwd, String phoneNo, String usrAddress);
}