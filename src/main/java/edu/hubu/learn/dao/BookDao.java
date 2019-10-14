package edu.hubu.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hubu.learn.entity.Book;

public interface BookDao extends JpaRepository<Book, Long> {

}