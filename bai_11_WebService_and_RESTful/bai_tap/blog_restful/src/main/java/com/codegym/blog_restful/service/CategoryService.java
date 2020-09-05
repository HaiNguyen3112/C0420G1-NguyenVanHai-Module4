package com.codegym.blog_restful.service;

import com.codegym.blog_restful.model.Category;


import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    Category findById(Long id);
    void save(Category category);
    void remove(Long id);
}
