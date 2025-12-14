package in.somi.main.service;

import java.util.List;

import in.somi.main.dto.BookDTO;
import in.somi.main.dto.CreateBookRequestDTO;

public interface BookService {
	
	BookDTO createBook(CreateBookRequestDTO dto);
	
	List<BookDTO> getAllBooks();
	
	BookDTO getBookById(Long id);
	
	BookDTO updateBook(Long id, CreateBookRequestDTO dto);
	
	void deleteBook(Long id);
}
