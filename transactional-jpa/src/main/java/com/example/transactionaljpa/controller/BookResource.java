package com.example.transactionaljpa.controller;

import com.example.transactionaljpa.model.Book;
import com.example.transactionaljpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookResource {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> find(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findBook(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> delete1(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<HttpStatus> update(@PathVariable Long id, @RequestParam(required = true) String authorName) {
        bookService.update(authorName, id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
