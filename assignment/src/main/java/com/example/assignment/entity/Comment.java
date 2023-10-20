package com.example.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentFrom;
    private String commentTo;
    private String message;
    private Date dateTime;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
