package com.user.userManagement.service;

import com.user.userManagement.dao.UserDAO;
import com.user.userManagement.dao.UserRepository;
import com.user.userManagement.dto.OrderDTO;
import com.user.userManagement.dto.UserDTO;
import com.user.userManagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public void saveUser(UserDTO userDTO) {
        userDTO.setPwd(passwordEncoder.encode(userDTO.getPwd()));
        userDAO.saveUser(userDTO);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userDAO.findAllUsers();
    }

    @Override
    public void deleteUser(Long Id) {
        userDAO.deleteUser(Id);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        userDAO.updateUser(userDTO);
    }

    @Override
    public UserDTO findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public void createOrder(OrderDTO orderDTO) {
        restTemplate.postForObject("http://localhost:8081/orders/createOrder",orderDTO, OrderDTO.class);
    }

}
