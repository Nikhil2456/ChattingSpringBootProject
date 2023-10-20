package com.example.assignment.repository;

import com.example.assignment.entity.Comment;
import com.example.assignment.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends PagingAndSortingRepository<Comment, Long> {
    List<Comment> findAllByCommentTo(String comment_to);

    Comment findByCommentId(Long id);
}
