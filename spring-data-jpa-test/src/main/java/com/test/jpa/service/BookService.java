package com.test.jpa.service;

import com.test.jpa.domain.Book;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @since 1.0 - 2017/2/21
 */
public interface BookService {
	public List<Book> findAll();
	public void saveBook(Book book);

	@Cacheable(value = "books", cacheManager = "default")
	public Book findOne(long id);
	public void delete(long id);
	public List<Book> findByName(String name);
	public List<Book> findByNameAndAuthor(String name, String author);
	public List<Book> findByPrice(long price);
	List<Book> findByPriceRange(long price1, long price2);
	List<Book> findByNameMatch(String name);
	List<Book> findByNamedParam(String name, String author, long price);
}

