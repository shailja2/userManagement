package com.user.userManagement.dao;

import com.user.userManagement.dto.UserDTO;
import com.user.userManagement.entity.UserEntity;

import java.util.List;

public interface UserDAO {
    void saveUser(UserDTO userDTO);
    //UserDTO getAllUser();
    List<UserDTO> findAllUsers();
    void deleteUser(Long Id);
    void updateUser(UserDTO userDTO);
    UserDTO findByEmail(String email);
}
