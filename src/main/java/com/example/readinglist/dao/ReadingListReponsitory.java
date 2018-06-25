package com.example.readinglist.dao;

import com.example.readinglist.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListReponsitory extends JpaRepository<Book,Long> {
    List<Book> findByReader(String reader);
}
