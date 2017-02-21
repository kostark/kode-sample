package com.test.jpa.repository;

import com.test.jpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @since 1.0 - 2017/2/20
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByPrice(long price);

	@Query(value = "select * from #{#entityName} b where b.name=?1", nativeQuery = true)
	List<Book> findByName(String name);

	@Query(value = "select name,author,price from Book b where b.price>?1 and b.price<?2")
	List<Book> findByPriceRange(long price1, long price2);

	@Query(value = "select name,author,price from Book b where b.name like %:name%")
	List<Book> findByNameMatch(@Param("name") String name);

	@Query(value = "select name,author,price from Book b where b.name = :name AND b.author=:author AND b.price=:price")
	List<Book> findByNamedParam(@Param("name") String name, @Param("author") String author,
								@Param("price") long price);
}
