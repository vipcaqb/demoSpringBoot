package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.entities.Author;
import com.spring.demo.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	AuthorRepository authorRepository;
	public List<Author> findAll(){
		return (List<Author>) authorRepository.findAll();
	}
	public Optional<Author> findById(Integer id) {
		return authorRepository.findById(id);
	}
	
	
}
