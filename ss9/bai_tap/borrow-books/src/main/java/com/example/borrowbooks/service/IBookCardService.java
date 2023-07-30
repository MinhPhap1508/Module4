package com.example.borrowbooks.service;

import com.example.borrowbooks.model.BookCard;

public interface IBookCardService {
    void save(BookCard bookCard);
    void delete(int code);
    BookCard getByCode(int code);
}
