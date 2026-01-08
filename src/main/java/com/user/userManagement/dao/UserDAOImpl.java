package com.user.userManagement.dao;

import com.user.userManagement.dto.UserDTO;
import com.user.userManagement.dto.UserMapper;
import com.user.userManagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.persistence.*;
@Service
public class UserDAOImpl implements UserDAO{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @ PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity userEntity=userMapper.toEntity(userDTO);
        userRepository.save(userEntity);
    }

    public void getUser(UserDTO userDTO) {
        UserEntity userEntity=userMapper.toEntity(userDTO);
        userRepository.save(userEntity);
    }

    public List<UserDTO> findAllUsers() {
        //List<UserEntity> userEntityList = userRepository.findAll();
        /*List<UserDTO> userDTOList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList){
            UserDTO userDTO = userMapper.toDTO(userEntity);
            userDTOList.add(userDTO);
        }
        return userDTOList;*/
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long Id) {
        userRepository.deleteById(Id);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        Optional<UserEntity> userEntity=userRepository.findById(userDTO.getUserId());
        if(userEntity.isPresent()){
            UserEntity userEntity1=userMapper.toEntity(userDTO);
            userRepository.save(userEntity1);
        }
    }

    @Override
    public UserDTO findByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return userMapper.toDTO(userEntity);

    }

}
