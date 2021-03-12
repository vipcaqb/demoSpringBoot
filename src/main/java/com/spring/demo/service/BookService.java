package com.spring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.entities.Book;
import com.spring.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> findAll(){
		return (List<Book>) bookRepository.findAll();
	}
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteOne(Integer id) {
		bookRepository.deleteById(id);
	}
}
