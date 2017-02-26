package com.test.testjpa2.repository;

import com.test.testjpa2.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Stark on 2017/2/26.
 */
public interface IBookRepository extends JpaRepository<Book, Long> {

	Book findByIsbn(String isbn);

	@Query("select b from Book b where 1=1")
	List<Book> findAllBook();

	@Query("select count(*) from Book b where 1=1")
	long countBook();
}
