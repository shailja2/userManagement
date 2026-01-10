package com.user.userManagement.service;

import com.user.userManagement.dto.OrderDTO;
import com.user.userManagement.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDTO);

    List<UserDTO> findAllUsers();

    void deleteUser(Long Id);

    void updateUser(UserDTO userDTO);

    UserDTO findByEmail(String email);
    void createOrder(OrderDTO orderDTO);
}