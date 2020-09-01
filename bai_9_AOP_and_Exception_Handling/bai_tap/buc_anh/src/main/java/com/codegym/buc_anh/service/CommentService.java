package com.codegym.buc_anh.service;

import com.codegym.buc_anh.model.Comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CommentService {
    List<Comment> findAll();

    Comment findById(Long id);

    void save(Comment comment);

    Page<Comment> findAllByContentContaining(String content, Pageable pageable);

    Map<Integer,String> getList();
}
