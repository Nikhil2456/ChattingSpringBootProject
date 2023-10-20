package com.example.assignment.dto;

import com.example.assignment.entity.Comment;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long userId;
    private String name;
    private List<Comment> comments;
}
