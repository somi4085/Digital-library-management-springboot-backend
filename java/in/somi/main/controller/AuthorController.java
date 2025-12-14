package in.somi.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.somi.main.dto.AuthorDTO;
import in.somi.main.dto.CreateAuthorRequestDTO;
import in.somi.main.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	private AuthorService service;
	
	@PostMapping
	public AuthorDTO createAuthor(CreateAuthorRequestDTO dto) {
		return service.createAuthor(dto);
	}
	
	@GetMapping
	public List<AuthorDTO> getAllAuthor() {
		return service.getAllAuthors();
	}
	
	@GetMapping("/{id}")
	public AuthorDTO getById(@PathVariable Long id) {
		return service.getAuthorById(id);
	}
	
	@PutMapping("/{id}")
	public AuthorDTO updateAuthor(@RequestBody CreateAuthorRequestDTO dto, @PathVariable Long id) {
		return service.updateAuthor(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(Long id) {
		 service.deleteAuthor(id);
	}
}
