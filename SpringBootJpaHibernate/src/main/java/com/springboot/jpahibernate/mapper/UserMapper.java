package com.springboot.jpahibernate.mapper;

import com.springboot.jpahibernate.dto.UserDTO;
import com.springboot.jpahibernate.entity.User;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);
    List<UserDTO> toUserDTOs(List<User> users);
    User toUser(UserDTO userDTO);
    User map(UserDTO userDTO);
}