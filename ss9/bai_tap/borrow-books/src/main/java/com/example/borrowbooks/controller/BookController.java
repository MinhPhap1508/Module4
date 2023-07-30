package com.example.borrowbooks.controller;

import com.example.borrowbooks.exceoption.DuplicateException;
import com.example.borrowbooks.model.Book;
import com.example.borrowbooks.model.BookCard;
import com.example.borrowbooks.service.IBookCardService;
import com.example.borrowbooks.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    IBookCardService bookCardService;

    @GetMapping
    public String library(Model model) {
        List<Book> list = bookService.library();
        model.addAttribute("list", list);
        return "/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return "/detail";
    }
    @GetMapping("/borrow/{id}")
    public ModelAndView borrowBook(@PathVariable int id) throws DuplicateException {
        ModelAndView modelAndView;
        Random random = new Random();

        Integer randNum= 10000 + random.nextInt(90000);
        Book book = bookService.getById(id);
        if(book.getQuantity()>0){
            modelAndView = new ModelAndView("code");
            book.setQuantity(book.getQuantity()-1);
            BookCard bookCard = new BookCard(randNum,book);
            bookCardService.save(bookCard);
            modelAndView.addObject("codeBorrow",randNum);
        }else {
            throw new DuplicateException("The number of books is now out of stock");
        }
        return modelAndView;
    }
    @ExceptionHandler(DuplicateException.class)
    public String duplicateException(){
        return "errors";
    }
}
