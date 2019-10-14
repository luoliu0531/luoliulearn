package edu.hubu.learn.web;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import edu.hubu.learn.entity.Book;
import edu.hubu.learn.service.BookService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/{id}")
    public ModelAndView book(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        Book book = bookService.getBook(id);
        mav.addObject("book", book);
        mav.setViewName("book");
        return mav;
    }


    @RequestMapping("/list")
    public ModelAndView books() {
        ModelAndView mav = new ModelAndView();
        List<Book> books = bookService.getBooks();
        mav.addObject("books", books);
        mav.setViewName("books");
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView addBook() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("book_add");
        return mav;
    }

    @RequestMapping("/do_add")
    public ModelAndView doAddBook(Book book) {
        bookService.addBook(book);
        ModelAndView mav = new ModelAndView("redirect:/book/list");
        return mav;
    }

}