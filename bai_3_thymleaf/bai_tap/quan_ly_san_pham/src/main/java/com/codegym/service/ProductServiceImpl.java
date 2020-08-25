package com.codegym.service;

import com.codegym.Repository.ProductRepository;
import com.codegym.Repository.ProductRepositoryImpl;
import com.codegym.model.Product;
import java.util.List;


public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(product.getId(),product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public int size() {
        return productRepository.size();
    }
}
