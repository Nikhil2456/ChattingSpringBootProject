package com.example.assignment.service;

import com.example.assignment.common.service.ModelMapperService;
import com.example.assignment.dto.UserDto;
import com.example.assignment.entity.User;
import com.example.assignment.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapperService modelMapperService;
    public UserDto createUser(UserDto user){
        return modelMapperService.map(userRepo.save(modelMapperService.map(user, User.class)),UserDto.class);
    }

    public UserDto createUserByName(String name){
        UserDto user = new UserDto();
        user.setName(name);
        return modelMapperService.map(userRepo.save(modelMapperService.map(user, User.class)),UserDto.class);
    }

    public UserDto getUserByName(String name){
        return modelMapperService.map(userRepo.findByName(name),UserDto.class);
    }
}
