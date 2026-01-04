package com.user.userManagement.dao;

import com.user.userManagement.dto.UserDTO;

import java.util.List;

public interface UserDAO {
    void saveUser(UserDTO userDTO);
    //UserDTO getAllUser();
    List<UserDTO> findAllUsers();
    void deleteUser(Long Id);
    void updateUser(Long userId, String name, String email, String pwd, String phoneNo, String usrAddress);
}
