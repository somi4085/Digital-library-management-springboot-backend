package in.somi.main.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.somi.main.dto.BookDTO;
import in.somi.main.dto.CreateBookRequestDTO;
import in.somi.main.entity.Book;
import in.somi.main.repository.BookRepository;
import in.somi.main.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository repository;
	@Override
	public BookDTO createBook(CreateBookRequestDTO dto) {
		Book book = new Book();
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setCategory(dto.getCategory());
		book.setDescription(dto.getDescription());
		book.setCopiesAvailable(dto.getCopiesAvaiable());
		book.setCopiesTotal(dto.getCopiesTotal());
		book.setIsbn(dto.getIsbn());
		book.setPublicationYear(dto.getPublicationYear());
		
		Book saved = repository.save(book);
		return mapToDo(saved);
	}

	@Override
	public List<BookDTO> getAllBooks() {
		return repository.findAll().stream().map(this::mapToDo).toList();
	}

	@Override
	public BookDTO getBookById(Long id) {
		Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("book not found"));
		return mapToDo(book);
	}

	@Override
	public BookDTO updateBook(Long id, CreateBookRequestDTO dto) {
		Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setDescription(dto.getDescription());
		book.setCopiesTotal(dto.getCopiesTotal());
		book.setIsbn(dto.getIsbn());
		book.setPublicationYear(dto.getPublicationYear());
		
		Book updated = repository.save(book);
		return mapToDo(updated);
		
	}

	@Override
	public void deleteBook(Long id) {
		repository.deleteById(id);
	}
	
	private BookDTO mapToDo(Book book) {
		BookDTO dto = new BookDTO();
		dto.setTitile(book.getTitle());
		dto.setAuthor(book.getAuthor());
		dto.setCategory(book.getCategory());
		dto.setCopiesAvailble(book.getCopiesAvailable());
		dto.setCopiesTotal(book.getCopiesTotal());
		dto.setDescriprion(book.getDescription());
		dto.setIsbn(book.getIsbn());
		dto.setPublicationYear(book.getPublicationYear());
		return dto;
	}
}
