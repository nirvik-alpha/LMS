package com.application.lms.repository;

import com.application.lms.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
  It extends JpaRepository which includes methods like save, findAll, findById, deleteById, etc.
 */

public interface BookRepository extends JpaRepository<Book,Long> {
}
