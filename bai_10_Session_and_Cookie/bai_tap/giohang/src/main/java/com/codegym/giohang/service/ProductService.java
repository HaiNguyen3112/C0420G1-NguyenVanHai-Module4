package com.codegym.giohang.service;

import com.codegym.giohang.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> fillAll();
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
    Product findById(Long id);
    void save(Product product);
    void delete(Long id);
}
