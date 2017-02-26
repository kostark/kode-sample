package com.test.testjpa2.service;

import com.test.testjpa2.domain.Book;

/**
 * Created by Stark on 2017/2/26.
 */
public interface IBookService {
	public Book findByIsbn(String isbn);
}
