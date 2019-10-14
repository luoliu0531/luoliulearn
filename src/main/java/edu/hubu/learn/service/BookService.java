package edu.hubu.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import edu.hubu.learn.dao.BookDao;
import edu.hubu.learn.entity.Book;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public Book getBook(Long id) {
        return bookDao.findById(id).get();
    }

    public List<Book> getBooks() {
        return bookDao.findAll();
    }



    public Book addBook(Book book) {
        return bookDao.save(book);
    }

}