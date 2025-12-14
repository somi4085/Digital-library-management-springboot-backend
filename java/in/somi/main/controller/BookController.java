package in.somi.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.somi.main.dto.BookDTO;
import in.somi.main.dto.CreateBookRequestDTO;
import in.somi.main.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService service;
	
	@PostMapping
	public BookDTO createBook(@RequestBody CreateBookRequestDTO dto) {
		return service.createBook(dto);
	}
	
	@GetMapping("/{id}")
	public BookDTO getbookByid(@PathVariable Long id) {
		return service.getBookById(id);
	}
	
	@GetMapping
	public List<BookDTO> getAllBook() {
		return service.getAllBooks();
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteBook(id);
	}
}
