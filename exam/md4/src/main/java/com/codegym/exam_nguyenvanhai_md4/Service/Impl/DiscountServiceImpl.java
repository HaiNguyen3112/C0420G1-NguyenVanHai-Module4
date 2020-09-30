package com.codegym.exam_nguyenvanhai_md4.Service.Impl;

import com.codegym.exam_nguyenvanhai_md4.Repository.DiscountRepository;
import com.codegym.exam_nguyenvanhai_md4.Service.DiscountService;
import com.codegym.exam_nguyenvanhai_md4.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    DiscountRepository discountRepository;

    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Discount findById(Long id) {
        return discountRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Discount discount) {
            discountRepository.save(discount);
    }

    @Override
    public void deleteById(Long id) {
            discountRepository.deleteById(id);
    }

    @Override
    public List<Discount> findAllByNumber(int number) {
        return discountRepository.findAllByNumber(number);
    }

}
