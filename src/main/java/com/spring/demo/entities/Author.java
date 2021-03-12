package com.spring.demo.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Nationalized;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Author database table.
 * 
 */
@Entity
@NamedQuery(name="Author.findAll", query="SELECT a FROM Author a")
public class Author implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DoB")
	private Date doB;

	@Column(name="Name")
	@Nationalized
	private String name;

	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="author")
	private List<Book> books;

	public Author() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDoB() {
		return this.doB;
	}

	public void setDoB(Date doB) {
		this.doB = doB;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setAuthor(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setAuthor(null);

		return book;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", doB=" + doB + ", name=" + name + ", books=" + books + "]";
	}
}