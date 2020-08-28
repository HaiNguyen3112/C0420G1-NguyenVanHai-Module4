package com.codegym.update_blog.service;

import com.codegym.update_blog.model.Category;


import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    Category findById(Long id);
    void save (Category category);
    void remove (Long id);
}
