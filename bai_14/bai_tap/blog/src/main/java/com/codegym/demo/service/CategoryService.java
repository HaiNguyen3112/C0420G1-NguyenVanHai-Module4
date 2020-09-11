package com.codegym.demo.service;

import com.codegym.demo.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();
    Category findById(Long id);
    void save(Category category);
    void remove(Long id);
}
