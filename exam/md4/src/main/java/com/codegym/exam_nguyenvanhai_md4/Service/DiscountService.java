package com.codegym.exam_nguyenvanhai_md4.Service;

import com.codegym.exam_nguyenvanhai_md4.model.Discount;

import java.util.List;

public interface DiscountService {
    List<Discount> findAll();
    Discount findById(Long id);
    void save(Discount discount);
    void deleteById(Long id);
    List<Discount> findAllByNumber(int number);
}
