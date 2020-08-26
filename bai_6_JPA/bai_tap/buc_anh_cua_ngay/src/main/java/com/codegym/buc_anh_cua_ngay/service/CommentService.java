package com.codegym.buc_anh_cua_ngay.service;

import com.codegym.buc_anh_cua_ngay.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findById(Long id);

    void save(Comment comment);

}
