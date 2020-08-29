package com.codegym.bucanhcuangayupdate.service;


import com.codegym.bucanhcuangayupdate.model.Comment;
import com.codegym.bucanhcuangayupdate.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Page<Comment> findAllByContentContaining(String content, Pageable pageable) {
        return commentRepository.findAllByContentContaining(content,pageable);
    }

}
