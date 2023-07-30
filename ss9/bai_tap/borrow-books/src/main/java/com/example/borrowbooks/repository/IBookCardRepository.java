package com.example.borrowbooks.repository;

import com.example.borrowbooks.model.BookCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

public interface IBookCardRepository extends JpaRepository<BookCard, Integer> {
    @Transactional
    @Modifying
    void deleteBookCardByCode(int code);
    BookCard findBookCardByCode(int code);
}
