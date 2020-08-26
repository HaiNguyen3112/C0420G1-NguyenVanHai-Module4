package com.codegym.buc_anh_cua_ngay.repository;

import com.codegym.buc_anh_cua_ngay.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
