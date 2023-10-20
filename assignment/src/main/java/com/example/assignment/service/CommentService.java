package com.example.assignment.service;

import com.example.assignment.common.service.ModelMapperService;
import com.example.assignment.dto.CommentDto;
import com.example.assignment.entity.Comment;
import com.example.assignment.entity.User;
import com.example.assignment.exception.CustomException;
import com.example.assignment.repository.CommentRepo;
import com.example.assignment.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapperService modelMapperService;

    public CommentDto createComment(CommentDto commentDto){
        if(checkName(commentDto)){
            var fromUser = userService.getUserByName(commentDto.getCommentFrom());
            var toUser = userService.getUserByName(commentDto.getCommentTo());
            if(fromUser==null){
                fromUser = userService.createUserByName(commentDto.getCommentFrom());
            }
            if(toUser == null){
                toUser = userService.createUserByName(commentDto.getCommentTo());
            }
            commentDto.setDateTime(new Date());
            commentDto.setUser(modelMapperService.map(fromUser, User.class));
            return modelMapperService.map(commentRepo.save(modelMapperService.map(commentDto, Comment.class)),CommentDto.class);
        }
        return null;
    }

    public List<CommentDto> getCommentByUser(String name){
        return modelMapperService.mapToList(commentRepo.findAllByCommentTo(name),CommentDto.class);
    }

    public CommentDto getCommentById(Long id){
        return modelMapperService.map(commentRepo.findByCommentId(id),CommentDto.class);
    }

    public Boolean checkName(CommentDto commentDto){
        if((commentDto.getCommentFrom()!=null &&commentDto.getCommentTo()!=null)
                &&(!commentDto.getCommentFrom().isBlank() &&!commentDto.getCommentTo().isEmpty())){
            if(commentDto.getCommentFrom().matches("^[a-zA-Z]*$") && commentDto.getCommentTo().matches("^[a-zA-Z]*$")){
                return true;
            }
            else{
                throw new CustomException("Name Cannot contain any Number,Special Character and symbol");
            }
        }
        else{
            throw new CustomException("Name Cannot be Empty and Null");
        }
    }

}
