package com.codegym.buc_anh_cua_ngay.service;

import com.codegym.buc_anh_cua_ngay.model.Comment;
import com.codegym.buc_anh_cua_ngay.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
