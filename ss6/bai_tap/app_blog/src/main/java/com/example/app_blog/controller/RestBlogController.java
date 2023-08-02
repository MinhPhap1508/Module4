package com.example.app_blog.controller;

import com.example.app_blog.model.Blog;
import com.example.app_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin("*")
@RequestMapping("api/blog")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

//        @GetMapping("")
//    public ResponseEntity<List<Blog>> getList() {
//        List<Blog> blogList = blogService.showList();
//        if ((blogList.isEmpty())) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }

    @GetMapping("")
    public ResponseEntity<Page<Blog>> getList(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page, 2, Sort.by("name").descending());
        Page<Blog> blogPage = blogService.findAll(pageable,searchName);
        if(blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Blog blog) {
        blogService.addBlog(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete1(@RequestParam int id) {
        Blog blog = blogService.getById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        blogService.deleteBlog(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Blog blog = blogService.getById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        blogService.deleteBlog(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> detail(@PathVariable int id) {
        Blog blog = blogService.getById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
