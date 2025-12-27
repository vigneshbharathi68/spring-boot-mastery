package com.vignesh.crudapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vignesh.crudapi.model.BookModel;

@Repository
public interface BookRepo extends JpaRepository<BookModel, Long> {
  
}
