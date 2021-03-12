package com.spring.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
