package com.codegym.exam_nguyenvanhai_md4.Repository;

import com.codegym.exam_nguyenvanhai_md4.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
    List<Discount> findAllByNumber(int number);
}
