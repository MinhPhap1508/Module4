package com.example.borrowbooks.service;

import com.example.borrowbooks.model.Book;
import com.example.borrowbooks.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService{
    @Autowired
    IBookRepository bookRepository;
    @Override
    public List<Book> library() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepository.findById(id).get();
    }
}
