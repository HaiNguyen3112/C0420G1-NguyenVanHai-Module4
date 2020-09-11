package com.codegym.demo.service;


import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService  {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    Page<Blog> findAllByTitleContainingOrderByDateAsc(String title, Pageable pageable);
    Page<Blog> findAllByCategoryOrderByDateAsc(Category category, Pageable pageable);
    List<Blog> findAllByTitleContaining(String title);

    Page<Blog> findAll(Pageable pageable);
}
