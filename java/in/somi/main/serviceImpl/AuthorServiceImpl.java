package in.somi.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.somi.main.dto.AuthorDTO;
import in.somi.main.dto.CreateAuthorRequestDTO;
import in.somi.main.entity.Author;
import in.somi.main.repository.AuthorRepository;
import in.somi.main.service.AuthorService;

@Service
public class AuthorServiceImpl  implements AuthorService{
	
	@Autowired
	private AuthorRepository repository;

	@Override
	public AuthorDTO createAuthor(CreateAuthorRequestDTO dto) {
		Author author = new Author();
		author.setName(dto.getName());
		author.setBiography(dto.getBiography());
		
		Author saved = repository.save(author);
		return mapToDo(saved);
	}

	@Override
	public List<AuthorDTO> getAllAuthors() {
		return repository.findAll().stream().map(this:: mapToDo).toList();
	}

	@Override
	public AuthorDTO getAuthorById(Long id) {
		Author author = repository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
		return mapToDo(author);
	}

	@Override
	public AuthorDTO updateAuthor(Long id, CreateAuthorRequestDTO dto) {
		Author author = repository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
		
		author.setName(dto.getName());
		author.setBiography(dto.getBiography());
		
		Author updated = repository.save(author);
		return mapToDo(updated);
	}

	@Override
	public void deleteAuthor(Long id) {
		repository.deleteById(id);
	}
	
	private AuthorDTO mapToDo(Author author) {
		AuthorDTO dto = new AuthorDTO();
		dto.setId(author.getId());
		dto.setName(author.getName());
		dto.setBiography(author.getBiography());
		return dto;
	}
}
