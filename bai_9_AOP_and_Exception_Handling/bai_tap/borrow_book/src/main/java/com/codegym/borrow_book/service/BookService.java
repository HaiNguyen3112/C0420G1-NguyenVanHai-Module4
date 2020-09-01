package com.codegym.borrow_book.service;

import com.codegym.borrow_book.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();

    Book getById(int id);

    boolean rentBook(Book book);

    void giveBook(Book book);
}
