package in.somi.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.somi.main.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByCategoryId(Long categoryId);
	
	List<Book> findByAuthorId(Long authorId);
	
	Optional<Book> findByIsbn(String isbn);
}
