package com.user.userManagement.service;

import com.user.userManagement.dao.UserDAO;
import com.user.userManagement.dao.UserRepository;
import com.user.userManagement.dto.UserDTO;
import com.user.userManagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
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
    public void updateUser(Long userId, String name, String email, String pwd, String phoneNo, String usrAddress) {
        userDAO.updateUser(userId,name,email,pwd,phoneNo,usrAddress);
    }

}
