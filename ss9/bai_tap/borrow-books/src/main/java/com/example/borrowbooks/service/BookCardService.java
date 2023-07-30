package com.example.borrowbooks.service;

import com.example.borrowbooks.model.BookCard;
import com.example.borrowbooks.repository.IBookCardRepository;
import org.springframework.stereotype.Service;

@Service

public class BookCardService implements IBookCardService {
    IBookCardRepository bookCardRepository;

    @Override
    public void save(BookCard bookCard) {
        bookCardRepository.save(bookCard);
    }

    @Override
    public void delete(int code) {
        bookCardRepository.deleteBookCardByCode(code);
    }

    @Override
    public BookCard getByCode(int code) {
        return bookCardRepository.findBookCardByCode(code);
    }
}
