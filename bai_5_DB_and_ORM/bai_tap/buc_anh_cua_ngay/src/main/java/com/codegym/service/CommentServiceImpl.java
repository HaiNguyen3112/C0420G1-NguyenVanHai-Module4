package com.codegym.service;

import com.codegym.model.Comment;
import com.codegym.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.getAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id);
    }

}
