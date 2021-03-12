package com.spring.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Nationalized;


/**
 * The persistent class for the Book database table.
 * 
 */

@Entity()
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="Name")
	@Nationalized
	@NotNull(message = "name cannot be missing or empty")
	@NotBlank(message = "name cannot be missing or empty")
	private String name;
	//bi-directional many-to-one association to Author
	@ManyToOne
	@JoinColumn(name="IdAuthor")
	private Author author;

	public Book() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author.toString() + "]";
	}
	
	

}