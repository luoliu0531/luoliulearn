package edu.hubu.learn.web;


import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;


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
    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        bookService.deleteBook(id);
        ModelAndView mav = new ModelAndView("redirect:/book/list");
        return mav;
    }
    @RequestMapping("/modify/{id}")
    public ModelAndView modifyStudent(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("book", bookService.getBook(id));
        mav.setViewName("book_modify");
        return mav;
    }

    @RequestMapping("/do_modify")
    public ModelAndView doModifyBook(Book book) {

        bookService.modifyBook(book);
        ModelAndView mav = new ModelAndView("redirect:/book/list");
        return mav;
    }
    @RequestMapping("/search")
    public ModelAndView searchBook() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("book_search");
        return mav;
    }

    @RequestMapping("/do_search")
    public ModelAndView doSearchBook(HttpServletRequest httpRequest) {
        ModelAndView mav = new ModelAndView();
        String keyword = httpRequest.getParameter("keyword");
        List<Book> books = bookService.searchBooks(keyword);
        mav.addObject("books", books);
        mav.setViewName("books");
        return mav;
    }
}