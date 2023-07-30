package com.example.borrowbooks.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String img;
    private String name;
    private String author;
    private String info;
    private Integer quantity;
    @OneToMany(mappedBy = "book")
    private Set<BookCard> bookCardSet;

    public Book() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Book(int id, String img, String name, String author, String info, Integer quantity) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.author = author;
        this.info = info;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<BookCard> getBookCardSet() {
        return bookCardSet;
    }

    public void setBookCardSet(Set<BookCard> bookCardSet) {
        this.bookCardSet = bookCardSet;
    }
}
