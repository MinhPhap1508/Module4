package com.example.app_blog.service;

import com.example.app_blog.model.Blog;
import com.example.app_blog.model.Category;
import com.example.app_blog.repository.IBlogRepository;
import com.example.app_blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private ICategoryService categoryService;
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
    public void deleteBlog(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Blog getById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public void edit(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findByName(String name) {
        List<Blog> findName = showList();
        List<Blog> blogList = new ArrayList<>();
        for (Blog b:findName) {
            if (b.getName().equals(name)){
                blogList.add(b);
            }
        }
        return blogList;
    }

    @Override
    public List<Blog> blogList(int idCategory) {
        List<Blog> blogList = new ArrayList<>();
        Category category = categoryService.getById(idCategory);
        List<Blog> blogs = showList();
        System.out.println("b"+category);
        for (Blog b: blogs) {
            if(b.getName().equals(category.getName())){
                blogList.add(b);
            }
        }
        return blogList;
    }

}
