package com.codegym.Repository;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private ProductService productService = new ProductServiceImpl();

    @Override
    public List findAll() {
        return productService.findAll();
    }

    @Override
    public void save(Product product) {
        productService.save(product);
    }

    @Override
    public Product findById(int id) {
        return productService.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productService.update(id, product);
    }

    @Override
    public void remove(int id) {
        productService.remove(id);
    }

    @Override
    public int size() {
        return productService.size();
    }


}
