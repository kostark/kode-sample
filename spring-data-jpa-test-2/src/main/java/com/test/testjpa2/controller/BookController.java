package com.test.testjpa2.controller;

import com.test.testjpa2.domain.Book;
import com.test.testjpa2.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Stark on 2017/2/26.
 */
@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private IBookService bookService;

	@RequestMapping("/{isbn}")
	public Book index(@PathVariable String isbn) {
		Book b = bookService.findByIsbn(isbn);
		return b;
	}
}
