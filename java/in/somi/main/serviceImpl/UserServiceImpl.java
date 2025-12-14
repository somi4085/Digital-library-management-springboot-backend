package in.somi.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.somi.main.dto.CreateUserRequestDTO;
import in.somi.main.dto.UserDTO;
import in.somi.main.entity.User;
import in.somi.main.repository.UserRepository;
import in.somi.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO createUser(CreateUserRequestDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		
		User saved = userRepository.save(user);
		return mapToDo(saved);
	}

	@Override
	public UserDTO getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		return mapToDo(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		return userRepository.findAll().stream().map(this::mapToDo).toList();
	}

	@Override
	public UserDTO updateUsers(Long id, CreateUserRequestDTO dto) {
		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		
		User updated = userRepository.save(user);
		return mapToDo(updated);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public UserDTO mapToDo(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(dto.getEmail());
		dto.setRole(user.getRole());
		return dto;
	}
}
