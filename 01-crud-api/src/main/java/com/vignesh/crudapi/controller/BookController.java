package com.vignesh.crudapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BookController {
  @GetMapping("/api/books")
  public String getBooks() {
      return "";
  }
  
}