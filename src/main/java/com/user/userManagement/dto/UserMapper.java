package com.user.userManagement.dto;


import com.user.userManagement.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserDTO userDTO);
    UserDTO toDTO(UserEntity userEntity);
}
