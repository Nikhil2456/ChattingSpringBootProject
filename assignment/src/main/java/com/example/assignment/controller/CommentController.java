package com.example.assignment.controller;

import com.example.assignment.dto.CommentDto;
import com.example.assignment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CommentController {

    @Autowired
    private CommentService commentService;

    //API to save Comment and if user is not present then save user also in user table
    @PostMapping("/comment")
    public String save(@RequestBody CommentDto commentDto) {
        var comment = commentService.createComment(commentDto);
        if (comment != null) {
            return "Comment added successfully !";
        } else {
            return "Unable to add comment!";
        }
    }

    //API to get comment by user name
    @GetMapping("/comment/{name}")
    public List<CommentDto> get(@PathVariable("name") String name) {
        return commentService.getCommentByUser(name);
    }
}
