package com.codegym.update_blog.repository;


import com.codegym.update_blog.model.Blog;
import com.codegym.update_blog.model.Category;
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
}
