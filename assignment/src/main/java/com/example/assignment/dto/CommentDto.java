package com.example.assignment.dto;

import com.example.assignment.entity.User;
import lombok.Data;

import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class CommentDto {
    private Long commentId;
    private String commentFrom;
    private String commentTo;
    private String message;
    private Date dateTime;
    private User user;
}
