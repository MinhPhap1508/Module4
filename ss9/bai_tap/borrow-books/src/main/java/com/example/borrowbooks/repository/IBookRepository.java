package com.example.borrowbooks.repository;

import com.example.borrowbooks.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
}
