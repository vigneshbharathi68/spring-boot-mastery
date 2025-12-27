package com.vignesh.crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.crudapi.model.BookModel;
import com.vignesh.crudapi.repo.BookRepo;

@Service
public class BookService {
  @Autowired
  private BookRepo bookRepo;

  public List<BookModel> getBooks() {
    return bookRepo.findAll();
  }

  public BookModel getBookById(Long id) {
    return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
  }

  public BookModel createBook(BookModel bookDetails) {
    return bookRepo.save(bookDetails);
  }

  public BookModel updateBook(Long id, BookModel bookDetails) {
    BookModel book = getBookById(id);
    book.setAvailable(bookDetails.getAvailable());
    book.setAuthor(bookDetails.getAuthor());
    return bookRepo.save(book);
  }

  public void deleteBook(Long id) { 
    bookRepo.deleteById(id);
  }
}
