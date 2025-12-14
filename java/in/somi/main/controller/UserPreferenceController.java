package in.somi.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.somi.main.dto.UpdateUserPreferenceRequestDTO;
import in.somi.main.dto.UserPreferenceDTO;
import in.somi.main.service.UserprefernceService;

@RestController
@RequestMapping("/userPreference")
public class UserPreferenceController {
	
	@Autowired
	private UserprefernceService preference;
	
	@GetMapping("/{id}")
	public UserPreferenceDTO getUserpreferenceById(@PathVariable Long id) {
		return preference.getUserPrefernece(id);
	}
	
	
	@PutMapping("/{id}")
	public UserPreferenceDTO updatePrefernce(@RequestBody UpdateUserPreferenceRequestDTO dto, @PathVariable Long id) {
		return preference.updateUserPreference(id, dto);
	}
}
