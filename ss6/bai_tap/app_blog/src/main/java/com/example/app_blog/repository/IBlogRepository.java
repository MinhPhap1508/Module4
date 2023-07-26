package com.example.app_blog.repository;

import com.example.app_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findBlogByNameContaining(Pageable pageable, String name);
}
