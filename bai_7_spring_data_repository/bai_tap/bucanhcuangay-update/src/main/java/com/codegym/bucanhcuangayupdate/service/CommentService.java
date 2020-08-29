package com.codegym.bucanhcuangayupdate.service;

import com.codegym.bucanhcuangayupdate.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findById(Long id);

    void save(Comment comment);

    Page<Comment> findAllByContentContaining(String content, Pageable pageable);

}
