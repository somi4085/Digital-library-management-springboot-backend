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

import in.somi.main.dto.CreateUserRequestDTO;
import in.somi.main.dto.UserDTO;
import in.somi.main.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public UserDTO addUsers(@RequestBody CreateUserRequestDTO dto) {
		return userService.createUser(dto);
	}
	
	@GetMapping("/{id}")
	public UserDTO getById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping
	public List<UserDTO> getAllusers() {
		return userService.getAllUsers();
	}
	
	@PutMapping("/{id}")
	public UserDTO updateUser(@RequestBody CreateUserRequestDTO dto, @PathVariable Long id) {
		return userService.updateUsers(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteuserById(@PathVariable Long id) {
		 userService.deleteUser(id);
	}
}
