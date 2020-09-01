package com.codegym.buc_anh.repository;


import com.codegym.buc_anh.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    Page<Comment> findAllByContentContaining(String content, Pageable pageable);
}
