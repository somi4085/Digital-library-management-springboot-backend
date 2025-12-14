package in.somi.main.service;

import java.util.List;

import in.somi.main.dto.AuthorDTO;
import in.somi.main.dto.CreateAuthorRequestDTO;

public interface AuthorService {
	
	AuthorDTO createAuthor(CreateAuthorRequestDTO dto);
	
	public List<AuthorDTO> getAllAuthors();
	
	public AuthorDTO getAuthorById(Long id);
	
	public AuthorDTO updateAuthor(Long id, CreateAuthorRequestDTO dto);
	
	void deleteAuthor(Long id);
}
