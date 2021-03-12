package com.spring.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
