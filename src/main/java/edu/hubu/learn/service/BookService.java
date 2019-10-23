package edu.hubu.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

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
        return bookDao.findAll(new Sort(Direction.DESC, "id"));
    }



    public Book addBook(Book book) {
        return bookDao.save(book);
    }
    public void deleteBook(Long id) {
        bookDao.deleteById(id);
    }
    public void modifyBook(Book book) {
        bookDao.save(book);
    }
}