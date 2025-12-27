package com.vignesh.crudapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vignesh.crudapi.model.BookModel;
import com.vignesh.crudapi.service.BookService;

/*
  GET       /api/book         → All book
  GET       /api/book/1       → Book by ID
  POST      /api/book         → Create book
  PUT       /api/book/1       → Update book
  DELETE    /api/book/1       → Delete book
*/

@RestController
public class BookController {
  private BookService bookService;

  @GetMapping("/api/book")
  public ResponseEntity<List<BookModel>> getBooks() {
    return ResponseEntity.ok(bookService.getBooks());
  }

  @GetMapping("/api/book/{id}")
  public ResponseEntity<BookModel> getBookById(@PathVariable Long id) {
    return ResponseEntity.ok(bookService.getBookById(id));
  }

  @PostMapping("/api/book")
  public ResponseEntity<BookModel> createBook(@RequestBody BookModel bookDetails) {
    return ResponseEntity.ok(bookService.createBook(bookDetails));
  }

  @PutMapping("/api/book/{id}")
  public ResponseEntity<BookModel> updateBook(@PathVariable Long id, @RequestBody BookModel bookDetails) {
    return ResponseEntity.ok(bookService.updateBook(id, bookDetails));
  }

  @DeleteMapping("/api/book/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
    return ResponseEntity.noContent().build();
  }

}