package in.somi.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.somi.main.dto.UpdateUserPreferenceRequestDTO;
import in.somi.main.dto.UserPreferenceDTO;
import in.somi.main.entity.UserPreference;
import in.somi.main.repository.UserPreferencesRepository;
import in.somi.main.service.UserprefernceService;

@Service
public class UserPreferenceServiceImpl implements UserprefernceService{
	
	@Autowired
	private UserPreferencesRepository preference;

	@Override
	public UserPreferenceDTO getUserPrefernece(Long userId) {
		UserPreference userPreference = preference.findById(userId).orElseThrow(() -> new RuntimeException("User prefernece not found"));
		return mapToDo(userPreference);
	}

	@Override
	public UserPreferenceDTO updateUserPreference(Long userId, UpdateUserPreferenceRequestDTO dto) {
		UserPreference userPreference = preference.findById(userId).orElseThrow(() -> new RuntimeException("User perference not found"));
		
		userPreference.setLanguage(dto.getLanguage());
		userPreference.setTheme(dto.getTheme());
		userPreference.setNotificationsEnabled(dto.getNotificationsEnabled());
		return mapToDo(userPreference);
	}
	
	private UserPreferenceDTO mapToDo(UserPreference userPreference) {
		UserPreferenceDTO dto = new UserPreferenceDTO();
		dto.setId(userPreference.getId());
		dto.setUserId(userPreference.getUserId());
		dto.setLanguage(userPreference.getLanguage());
		dto.setTheme(userPreference.getTheme());
		return dto;
	}
}
