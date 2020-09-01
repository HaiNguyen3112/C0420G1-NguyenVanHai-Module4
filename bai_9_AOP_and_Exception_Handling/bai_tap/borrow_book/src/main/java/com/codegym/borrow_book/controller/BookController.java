package com.codegym.borrow_book.controller;

import com.codegym.borrow_book.exception.BorrowBookException;
import com.codegym.borrow_book.exception.GiveBackException;
import com.codegym.borrow_book.model.Book;
import com.codegym.borrow_book.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
public class BookController {
    Map<Integer,Book> bookList = new HashMap<>();

    @Autowired
    BookService bookService;
    @GetMapping("/books")
    public ModelAndView showList(){
        return new ModelAndView("list","bookList",bookService.getAllBook());
    }

    @GetMapping("/books/borrow/{id}")
    public ModelAndView viewBorrowBook(@PathVariable int id) {
        Book book = bookService.getById(id);
        if (book == null) {
            return new ModelAndView("error");
        }
        int temp = (int) Math.round(Math.random() * 99999);
        ModelAndView modelAndView = new ModelAndView("borrow","book",book);
        modelAndView.addObject("temp", temp);
        return modelAndView;
    }

    @PostMapping("/books/borrow/{code}")
    public ModelAndView borrowBook(@ModelAttribute Book book, @PathVariable int code) throws BorrowBookException {
        if (bookService.rentBook(book)){
            bookList.put(code, book);
            return new ModelAndView("redirect:/books");
        }
        throw new BorrowBookException();
    }

    @ExceptionHandler(BorrowBookException.class)
    public ModelAndView showError(){
        return new ModelAndView("error");
    }

    @PostMapping("/books/giveback")
    public ModelAndView giveBackBook(@RequestParam int code) throws GiveBackException {

       if (bookList.containsKey(code)){
           bookService.giveBook(bookList.get(code));
           bookList.remove(code);
           ModelAndView modelAndView = new ModelAndView("list");
           modelAndView.addObject("message","Tra sach thanh cong!!!");
           modelAndView.addObject("bookList",bookService.getAllBook());
           return modelAndView;
       }
       throw new GiveBackException();
    }

    @ExceptionHandler(GiveBackException.class)
    public ModelAndView showErrorGiveBack(){
        return new ModelAndView("errorBack");
    }



}
