package com.codegym.blog_ajax.service;

import com.codegym.blog_ajax.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    Category findById(Long id);
    void save(Category category);
    void remove(Long id);
}
