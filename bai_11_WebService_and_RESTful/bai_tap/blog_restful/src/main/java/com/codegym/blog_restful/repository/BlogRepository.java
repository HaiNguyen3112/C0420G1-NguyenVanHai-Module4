package com.codegym.blog_restful.repository;


import com.codegym.blog_restful.model.Blog;
import com.codegym.blog_restful.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    Page<Blog> findAllByTitleContainingOrderByDateAsc(String title, Pageable pageable);
    Page<Blog> findAllByCategoryOrderByDateAsc(Category category, Pageable pageable);
    List<Blog> findAllByCategoryOrderByDateAsc(Category category);
}
