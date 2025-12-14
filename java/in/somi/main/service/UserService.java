package in.somi.main.service;

import java.util.List;

import in.somi.main.dto.CreateUserRequestDTO;
import in.somi.main.dto.UserDTO;

public interface UserService {
	UserDTO createUser(CreateUserRequestDTO dto);
	UserDTO getUserById(Long id);
	List<UserDTO> getAllUsers();
	UserDTO updateUsers(Long id, CreateUserRequestDTO dto);
	void deleteUser(Long id);
}
