package com.example.transactionaljpa.service.impl;

import com.example.transactionaljpa.model.Book;
import com.example.transactionaljpa.repository.BookRepository;
import com.example.transactionaljpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    @Override
    public Book saveBook(Book book) {
        String bookName = book.getBookName();
        String authorName = book.getAutherName();
        int price = book.getPrice();
        bookRepository.insert(bookName, authorName, price);
        return book;
    }

    @Transactional
    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Book findBook(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    @Override
    public void delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
    }

    @Transactional
    @Override
    public void update(String authorName, Long id) {
        bookRepository.update(authorName, id);
    }
}
