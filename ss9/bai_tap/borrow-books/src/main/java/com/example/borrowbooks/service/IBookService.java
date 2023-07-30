package com.example.borrowbooks.service;

import com.example.borrowbooks.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> library();
    Book getById(int id);
}
