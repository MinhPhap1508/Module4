package com.example.app_blog.service;

import com.example.app_blog.model.Blog;
import com.example.app_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> showList() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String name) {
        return blogRepository.findBlogByNameContaining(pageable,name);
    }


    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog getById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void edit(Blog blog) {
        blogRepository.save(blog);
    }

}
