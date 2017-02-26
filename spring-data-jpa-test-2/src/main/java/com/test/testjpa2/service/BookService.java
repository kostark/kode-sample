package com.test.testjpa2.service;

import com.test.testjpa2.domain.Book;
import com.test.testjpa2.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Stark on 2017/2/26.
 */
@Service
@Transactional
public class BookService implements IBookService {

	@Autowired
	private IBookRepository bookRepository;

	@Override
	@Cacheable(value = "book", key = "'findByIsbn-' + #isbn")
	public Book findByIsbn(String isbn) {
		Book book = bookRepository.findByIsbn(isbn);
		return book;
	}

}
