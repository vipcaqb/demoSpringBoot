package com.spring.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.demo.entities.Author;
import com.spring.demo.entities.Book;
import com.spring.demo.model.AjaxResponseBody;
import com.spring.demo.service.AuthorService;
import com.spring.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired 
	private AuthorService authorService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getList(Book book) {
		System.out.println("Do GET /book");
		List<Book> list = bookService.findAll();
		ModelAndView mav = new ModelAndView("book/bookList");
		mav.addObject("list", list);
		mav.addObject("MSG", "Hello spring boot Thymeleaf");
		List<Author> listAuthor = authorService.findAll();
		mav.addObject("listAuthor", listAuthor);
		
		mav.addObject("book",book);
		return mav;
	}

	@RequestMapping(value = "/create", method = 	RequestMethod.POST)
	public ResponseEntity<?> createOne(@Valid @RequestBody Book book,  BindingResult bindingResult) {
		System.out.println("Do POST book/create");

		AjaxResponseBody result = new AjaxResponseBody();
		System.out.println(book.toString());
		if(bindingResult.hasErrors()) {
			System.out.println("Bad request");
			result.setMsg(bindingResult.getAllErrors().stream().map(x->x.getDefaultMessage())
					.collect(Collectors.joining(",")));
			
			return ResponseEntity.badRequest().body(result);
		}
		result.setMsg("Them thanh cong");
		Book x =bookService.save(book);
		List<Book> ds = new ArrayList<Book>(); 
		ds.add(x);
		System.out.println(x.toString());
		return ResponseEntity.ok(ds);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView createOne(@PathVariable("id") Integer id) {
		System.out.println("Do GET book/delete");
		bookService.deleteOne(id);
		return new ModelAndView("redirect:/book");
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView createOne(@PathVariable("id") Integer id,@RequestParam("name") String name) {
		System.out.println("Do GET book/delete");
		Book newBook = new Book();
		newBook.setId(id);
		newBook.setName(name);
		bookService.save(newBook);
		return new ModelAndView("redirect:/book");
	}
}
