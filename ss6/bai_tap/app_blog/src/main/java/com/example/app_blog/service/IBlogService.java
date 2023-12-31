package com.example.app_blog.service;

import com.example.app_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> showList();
    Page<Blog> findAll(Pageable pageable, String name);

    void addBlog(Blog blog);

    void delete(int id);
    void deleteBlog(Blog blog);

    Blog getById(int id);
    void edit(Blog blog);
    List<Blog> findByName(String name);

    List<Blog> blogList(int idCategory);
}
