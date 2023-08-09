package com.example.transactionaljpa.service;

import com.example.transactionaljpa.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public interface BookService {

    public Book saveBook(Book book);

    public void deleteBook(Long id);

    public Book findBook(Long id);

    public void delete(Long id);

    public void update(String authorName, Long id);
}
