package com.spring.demo.model;

import java.util.List;

import com.spring.demo.entities.Book;

public class AjaxResponseBody {

    String msg;
    List<Book> result;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Book> getResult() {
		return result;
	}
	public void setResult(List<Book> result) {
		this.result = result;
	}
	public AjaxResponseBody(String msg, List<Book> result) {
		super();
		this.msg = msg;
		this.result = result;
	}
	public AjaxResponseBody() {
		super();
		// TODO Auto-generated constructor stub
	}
}