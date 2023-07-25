package com.example.app_blog.service;

import com.example.app_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> showList();

    void addBlog(Blog blog);

    void delete(int id);

    Blog getById(int id);
}
