package com.codegym.blog_management.service;

import com.codegym.blog_management.model.Blog;

import java.util.List;

public interface BlogService  {
    List<Blog> findAll();
    Blog findById (Long id);
    void save(Blog blog);
    void remove(Long id);
    List<Blog> findAllByTitleContaining(String title);
    List<Blog> findAllByTitleContainingOrderByTitleAsc(String title);
}
