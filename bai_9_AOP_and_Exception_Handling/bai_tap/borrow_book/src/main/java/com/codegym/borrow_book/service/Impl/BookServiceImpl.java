package com.codegym.borrow_book.service.Impl;

import com.codegym.borrow_book.model.Book;
import com.codegym.borrow_book.repository.BookRepository;
import com.codegym.borrow_book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {
//    private static Map<Integer,Book> bookMap = new HashMap<>();
//    static{
//          bookMap.put(0,new Book(0,"Sherlock Holmes",10));
//          bookMap.put(1,new Book(1,"Yellow Flower on Green Grass",10));
//          bookMap.put(2,new Book(2,"Currency War",2));
//    }

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public boolean rentBook(Book book) {
        Book tempBook = bookRepository.getOne(book.getId());
        if (tempBook.getAmount() == 0) {
            return false;
        } else {
            tempBook.setAmount(tempBook.getAmount() -1);
            bookRepository.save(tempBook);
            return true;
        }
    }

    @Override
    public void giveBook(Book book) {
        Book tempBook = bookRepository.getOne(book.getId());
        tempBook.setAmount(tempBook.getAmount() +1);
        bookRepository.save(tempBook);
    }
}
